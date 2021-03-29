package com.situation.analysis.util;

import com.situation.analysis.entity.ObjectEntity4Record;
import com.situation.analysis.model.IndicatorInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @description: utils
 * @author: Kobe
 * @date: 2021/2/28 下午4:12
 * @version: v1.0
 */
@Slf4j
public class Util {

    public static String encryptPassword(String password,String salt) {
        int times = 2;
        String algorithmName = "md5";
        String encodePassword = new SimpleHash(algorithmName, password, salt, times).toString();
        return encodePassword;

    }

    public static ObjectEntity4Record createObjectEntity4Record(float healthRating) {
        ObjectEntity4Record objectEntity4Record = new ObjectEntity4Record();
        objectEntity4Record.setDiagTime(new Date().toLocaleString());
        objectEntity4Record.setHealthRating(healthRating);
        return objectEntity4Record;
    }

    public static float getImpactedFactor(List<IndicatorInfo> indicatorInfos, String name) {
        log.debug("indicator name: {}", name);
        IndicatorInfo indicator = indicatorInfos.stream().filter(indicatorInfo -> indicatorInfo.getName().equals(name)).findFirst().get();
        return Optional.of(indicator.getImpactFactor()).orElse((float) 0);
    }
}
