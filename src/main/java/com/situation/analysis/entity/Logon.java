package com.situation.analysis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kobe
 * @since 2021-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("LOGON")
public class Logon implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;

    private String name;

    private String code;

    private String expiredTime;


}
