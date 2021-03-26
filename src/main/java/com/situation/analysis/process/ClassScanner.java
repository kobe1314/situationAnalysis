package com.situation.analysis.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: Kobe
 * @date: 2021/3/24 上午8:47
 * @version: v1.0
 */
@Slf4j
public class ClassScanner implements ResourceLoaderAware {
    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(this.resourcePatternResolver);

    private final List<TypeFilter> includeFilters = new LinkedList<>();
    private final List<TypeFilter> excludeFilters = new LinkedList<>();


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
    }

    public void addIncludeFilter(TypeFilter includeFilter) {
        this.includeFilters.add(includeFilter);
    }

    public void addExcludeFilter(TypeFilter excludeFilter) {
        this.excludeFilters.add(0, excludeFilter);
    }

    public void resetFilters(boolean useDefaultFilters) {
        this.includeFilters.clear();
        this.excludeFilters.clear();
    }

    /**
     * 扫描指定路径指定注解的类
     * @param basePackage
     * @param annotations
     * @return
     */
    public static Set<Class> scan(String basePackage, Class<? extends Annotation>... annotations) {
        ClassScanner classScanner = new ClassScanner();

        for (Class<? extends Annotation> annotation : annotations) {
            classScanner.addIncludeFilter(new AnnotationTypeFilter(annotation));
        }
        return classScanner.doScan(basePackage);
    }

    /**
     * 扫描多个路径下包含指定注解的类
     * @param basePackages
     * @param annotations
     * @return
     */
    public static Set<Class> scan(String[] basePackages, Class<? extends Annotation>... annotations) {
        ClassScanner classScanner = new ClassScanner();
        for (Class<? extends Annotation> annotation : annotations) {
            classScanner.addIncludeFilter(new AnnotationTypeFilter(annotation));
        }

        Set<Class> classes = new HashSet<>();
        for (String basePackage : basePackages) {
            classes.addAll(classScanner.doScan(basePackage));
        }

        return classes;
    }

    /**
     * 扫描指定路径下的类信息
     * @param basePackage
     * @return
     */
    public Set<Class> doScan(String basePackage) {
        Set<Class> classes = new HashSet<>();

        // 扫描路径
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                + ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage))
                + "/**/*.class";
        try {

            // 获取指定扫描路径的资源
            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);

            for (Resource resource : resources) {
                if (resource.isReadable()) {

                    MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);

                    if ((this.includeFilters.size() == 0 && this.excludeFilters.size() == 0) || matches(metadataReader)) {

                        try {
                            // 返回符合条件的资源
                            classes.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                        } catch (ClassNotFoundException e) {
                            log.error("class forName 异常：", e);
                        }

                    }
                }
            }
        } catch (IOException e) {

            log.error("扫描加载资源io异常：", e);
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning", e);
        }

        return classes;
    }


    /**
     * 资源是否匹配
     * @param metadataReader
     * @return
     * @throws IOException
     */
    private boolean matches(MetadataReader metadataReader) throws IOException {

        for (TypeFilter excludeFilter : this.excludeFilters) {
            if (excludeFilter.match(metadataReader, this.metadataReaderFactory)) {
                return false;
            }
        }

        for (TypeFilter includeFilter : this.includeFilters) {
            if (includeFilter.match(metadataReader, this.metadataReaderFactory)) {
                return true;
            }
        }

        return false;
    }
}