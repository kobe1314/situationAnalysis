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
CREATE TABLE monitoringObjects(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    NAME VARCHAR(32)    COMMENT '对象名称' ,
    IMPACT_FACTOR DECIMAL(32,10)    COMMENT '影响因子' ,
    RUN_THRESHOLD INT    COMMENT '报警阈值' ,
    L_ID INT    COMMENT '所属层次' ,
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
    CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME VARCHAR(32)    COMMENT '创建时间' ,
    UPDATED_BY VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME VARCHAR(32)    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '指标 ';



Insert into indicator(NAME) values('在线率'),('连通率'),('时延超标率'),('使用异常'),('数据量达标率'),('视频流完好率'),('标注完好率'),('录像完好率'),
                                  ('录像完整率'),('图像完好率'),('图像数据一致率'),('结构化数据稳定性'),
                                  ('结构化数据规范'),('服务连通率'),('服务完好率'),('服务使用率'),('服务时延指标');

UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='每日累计在线时长/24小时的平均值' WHERE `ID`='1';
UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='连通次数/测试连接总次数' WHERE `ID`='2';
UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='时延符合要求的次数/监测总次数' WHERE `ID`='3';
UPDATE `situationAnalysis`.`indicator` SET `INSTRUCTION`='设备使用异常数值/设备数' WHERE `ID`='4';




insert into monitoringLevel(NAME) values('采集设备'),('基础设施'),('核心数据'),('服务资源'),('应用平台');



















