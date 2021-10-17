package com.situation.analysis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ADNAME")
    private String adname;

    @TableField("EMPCODE")
    private String empcode;

    @TableField("CNNAME")
    private String cnname;

    @TableField("ORGANIZATIONALID")
    private String organizationalid;

    @TableField("PHONENUMBER")
    private String phonenumber;

    @TableField("EMAIL")
    private String email;

    @TableField("POSITIONID")
    private String positionid;

    @TableField("ORGANIZATIONALNAME")
    private String organizationalname;

    @TableField("POSITIONNAME")
    private String positionname;

    @TableField("PLANT_CODE")
    private String plantCode;

    @TableField("ISDISABLEAD")
    private String isdisablead;

    @TableField("Gender")
    private String Gender;

    @TableField("EmpStatus")
    private String EmpStatus;

    @TableField("EmpStatusName")
    private String EmpStatusName;

    @TableField("EmpType")
    private String EmpType;

    @TableField("EmpTypeName")
    private String EmpTypeName;

    @TableField("JoinDate")
    private String JoinDate;

    @TableField("CardId")
    private String CardId;


}
