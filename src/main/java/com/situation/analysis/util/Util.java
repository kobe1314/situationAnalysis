package com.situation.analysis.util;

import com.situation.analysis.entity.ObjectEntity4Record;
import com.situation.analysis.entity.secondary.ResultEntity;
import com.situation.analysis.model.IndicatorInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description: utils
 * @author: Kobe
 * @date: 2021/2/28 下午4:12
 * @version: v1.0
 */
@Slf4j
public class Util {

    public static String encryptPassword(String password, String salt) {
        int times = 2;
        String algorithmName = "md5";
        String encodePassword = new SimpleHash(algorithmName, password, salt, times).toString();
        return encodePassword;

    }

    public static ObjectEntity4Record createObjectEntity4Record(float healthRating) {
        ObjectEntity4Record objectEntity4Record = new ObjectEntity4Record();
        objectEntity4Record.setDiagTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        objectEntity4Record.setHealthRating(healthRating);
        return objectEntity4Record;
    }

    public static float getImpactedFactor(List<IndicatorInfo> indicatorInfos, String name) {
        log.debug("indicator name: {}", name);
        IndicatorInfo indicator = indicatorInfos.stream().filter(indicatorInfo -> indicatorInfo.getName().equals(name)).findFirst().orElse(new IndicatorInfo());
        return Optional.of(indicator.getImpactFactor()).orElse((float) 0);
    }

    public static float calculateRating(int successRecords, int totalRecords) {

        if (totalRecords == 0) {
            return 0;
        }
        return (float) successRecords / totalRecords;
    }

    public static Integer calculateQualified(List<String> vList) {
        return vList.stream().filter(info ->
                !Arrays.asList(info.split("\\|")).stream().anyMatch(
                        str -> Integer.valueOf(str) > 100 || Integer.valueOf(str) < 60
                )).collect(Collectors.toList()).size();

    }

    public static boolean includeSpecifyTaskType(Integer[] contains, Integer taskType) {
        return Arrays.asList(contains).stream().anyMatch(type -> type.equals(taskType));
    }

    public static ResultEntity getResultEntity(List<ResultEntity> resultList, Integer code) {
        return resultList.stream().filter(result -> result.getCivilcode() == code).findFirst().orElse(new ResultEntity());
    }

    public static float convertFloat(float score) {
        String result = String.format("%.1f", score * 100);
        return Float.valueOf(result);
    }

}
