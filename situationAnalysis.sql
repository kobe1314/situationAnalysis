DROP TABLE IF EXISTS USER;
CREATE TABLE `situationAnalysis`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `salt` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


DROP TABLE IF EXISTS monitoringLevel;
CREATE TABLE monitoringLevel(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    NAME VARCHAR(32)    COMMENT '层次名称' ,
    IMPACT_FACTOR DECIMAL(32,10)    COMMENT '影响因子' ,
    RUN_THRESHOLD INT    COMMENT '运行阈值' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME VARCHAR(32)    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME VARCHAR(32)    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '监测层次表 ';



DROP TABLE IF EXISTS monitoringObject;
CREATE TABLE monitoringObject(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    NAME VARCHAR(32)    COMMENT '对象名称' ,
    IMPACT_FACTOR DECIMAL(32,10)    COMMENT '影响因子' ,
    RUN_THRESHOLD INT    COMMENT '报警阈值' ,
    L_ID INT    COMMENT '所属层次' ,
    B_ID INT    COMMENT '所属业务' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME VARCHAR(32)    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME VARCHAR(32)    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '监测对象表 ';


DROP TABLE IF EXISTS indicator;
CREATE TABLE indicator(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    NAME VARCHAR(32)    COMMENT '名字' ,
    INSTRUCTION VARCHAR(32)    COMMENT '指标说明' ,
    IMPACT_FACTOR DECIMAL(32,10)    COMMENT '影响因子' ,
    O_ID INT    COMMENT '所属监测对象' ,
    IS_ORIGINAL_VALUE VARCHAR(32)    COMMENT '原始指标' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME VARCHAR(32)    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME VARCHAR(32)    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '指标 ';

DROP TABLE IF EXISTS businessSystem;
CREATE TABLE businessSystem(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    NAME VARCHAR(32)    COMMENT '业务名称' ,
    IMPACT_FACTOR DECIMAL(32,10)    COMMENT '影响因子' ,
    PLATFORM VARCHAR(32)    COMMENT '平台' ,
    RUN_THRESHOLD INT    COMMENT '阈值' ,
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME VARCHAR(32)    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME VARCHAR(32)    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '业务系统管理 ';



Insert into indicator(NAME) values('在线率 A11'),('连通率 A12'),('时延超标率 A13'),('使用异常 A14'),('在线率 A21'),('数据量达标率 A22'),('使用异常 A23'),('在线率 A31'),('CPU状态 B11'),('内存状态 B12'),('交换空间状态 B13'),('硬件可用性 B21'),('磁盘可用性 B22'),('I/O状态 B23'),('网络可用性 B31'),('丢包率 B32'),('流量状态 B33'),('稳定性 B41'),('稳定性 B51'),('稳定性 B61'),('视频流完好率 C11'),('标注完好率 C 12'),('录像完好率 C 21'),('录像完整率 C 22'),('标注完好率 C 23'),('图像完好率 C 31'),('图像数据一致率 C 32'),('结构化数据稳定性 C 33'),('结构化数据规范 C 34'),('服务连通率 D 11'),('服务完好率 D 12'),('服务使用率 D 13'),('服务时延指标 D 14'),('在线率 E 11'),('级联稳定率 E 12'),('访问率 E 13'),('程序稳定性 E 14'),('日志可用性 E 15');

UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='每日累计在线时长/24小时的平均值' WHERE `ID`='1';
UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='连通次数/测试连接总次数' WHERE `ID`='2';
UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='时延符合要求的次数/监测总次数' WHERE `ID`='3';
UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='设备使用异常数值/设备数' WHERE `ID`='4';




insert into monitoringLevel(NAME) values('采集设备A'),('基础设施B'),('核心数据C'),('服务资源D'),('应用平台E');



















