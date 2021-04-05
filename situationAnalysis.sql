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
    IMPACT_FACTOR FLOAT    COMMENT '影响因子' ,
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
    IMPACT_FACTOR FLOAT    COMMENT '影响因子' ,
    BUSINESS_IMPACT_FACTOR FLOAT    COMMENT '业务影响因子' ,
    RUN_THRESHOLD INT    COMMENT '报警阈值' ,
    L_ID INT    COMMENT '所属层次' ,
    B_ID INT    COMMENT '所属业务' ,
    IS_ORIGINAL_VALUE VARCHAR(32)    COMMENT '原始指标' ,
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
    IMPACT_FACTOR FLOAT    COMMENT '影响因子' ,
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
    IMPACT_FACTOR FLOAT    COMMENT '影响因子' ,
    PLATFORM VARCHAR(32)    COMMENT '平台' ,
    RUN_THRESHOLD INT    COMMENT '阈值' ,
    IS_ORIGINAL_VALUE VARCHAR(32)    COMMENT '原始指标' ,
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


DROP TABLE IF EXISTS objectRecord;
CREATE TABLE objectRecord(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    O_ID INT    COMMENT '对象ID' ,
    HEALTH_RATING FLOAT    COMMENT '健康度' ,
    PRIMARY KEY (ID)
) COMMENT = '对象记录表 ';


insert into monitoringLevel(NAME) values('采集设备A'),('基础设施B'),('核心数据C'),('服务资源D'),('应用平台E');

DROP TABLE IF EXISTS indicatorOfImage;
CREATE TABLE indicatorOfImage(
    ID INT    COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区名称' ,
    ONLINE_A21 DECIMAL(32,10)    COMMENT '在线率A21' ,
    RATE_OF_REACH_A22 DECIMAL(32,10)    COMMENT '数据量达标率A22' ,
    EXCEPTION_A23 DECIMAL(32,10)    COMMENT '使用异常A23' ,
) COMMENT = '图像数据采集设备的指标 ';

DROP TABLE IF EXISTS image;
CREATE TABLE image(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区名称' ,
    IMAGE_A2 DECIMAL(32,10)    COMMENT '图像数据采集设备A2' ,
    PRIMARY KEY (ID)
) COMMENT = '图像数据采集设备A2 ';

DROP TABLE IF EXISTS indicatorOfVideo;
CREATE TABLE indicatorOfVideo(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    ONLINE_RATE_A11 DECIMAL(32,10)    COMMENT '在线率 A11' ,
    CONNECT_RATE_A12 DECIMAL(32,10)    COMMENT '连通率 A12' ,
    DELAY_RATE_A13 DECIMAL(32,10)    COMMENT '时延超标率 A13' ,
    EXCEPTION_A14 DECIMAL(32,10)    COMMENT '使用异常 A14' ,
    PRIMARY KEY (ID)
) COMMENT = '视频流采集设备的指标 ';

DROP TABLE IF EXISTS video;
CREATE TABLE video(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    VIDEO_A1 DECIMAL(32,10)    COMMENT '视频流采集设备A1' ,
    PRIMARY KEY (ID)
) COMMENT = '视频流采集设备A1 ';

DROP TABLE IF EXISTS indicatorRealTimeVideo;
CREATE TABLE indicatorRealTimeVideo(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    VIDEO_INTENSITY_RATE_C11 DECIMAL(32,10)    COMMENT '视频流完好率C11' ,
    ANNOTATION_INTENSITY_RATE_C12 DECIMAL(32,10)    COMMENT '标注完好率C12' ,
    PRIMARY KEY (ID)
) COMMENT = '实时视频流质量的指标 ';

DROP TABLE IF EXISTS realTimeVideo;
CREATE TABLE realTimeVideo(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    ONLINE_VIDEO_QUANTITY_C1 VARCHAR(32)    COMMENT '实时视频流质量C1' ,
    PRIMARY KEY (ID)
) COMMENT = '实时视频流质量C1 ';

DROP TABLE IF EXISTS IndicatorOfHistoryVideo;
CREATE TABLE IndicatorOfHistoryVideo(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    VIDEO_INTENSITY_RATE_C21 DECIMAL(32,10)    COMMENT '录像完好率分值C21' ,
    VIDEO_WHOLE_RATE_C22 DECIMAL(32,10)    COMMENT '录像完整率分值C22' ,
    ANNOTATION_RATE_C23 DECIMAL(32,10)    COMMENT '标注率分值C23' ,
    PRIMARY KEY (ID)
) COMMENT = '历史视频质量的指标 ';

DROP TABLE IF EXISTS historyVideo;
CREATE TABLE historyVideo(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    HISTORY_VIDEO_QUANTITY_C2 VARCHAR(32)    COMMENT '历史视频质量C2' ,
    PRIMARY KEY (ID)
) COMMENT = '历史视频质量C2 ';

DROP TABLE IF EXISTS indicatorOfImageQuantity;
CREATE TABLE indicatorOfImageQuantity(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    IMAGE_C31 DECIMAL(32,10)    COMMENT '图像完好率C31' ,
    IAMGE_C32 DECIMAL(32,10)    COMMENT '图像数据一致率C31' ,
    IMAGE_C33 DECIMAL(32,10)    COMMENT '结构化数据规范C34' ,
    IMAGE_C34 DECIMAL(32,10)    COMMENT '结构化数据稳定性C33' ,
    PRIMARY KEY (ID)
) COMMENT = '图像数据质量的指标 ';

DROP TABLE IF EXISTS imageQuantity;
CREATE TABLE imageQuantity(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    IAMGE_QUANTITY_C3 DECIMAL(32,10)    COMMENT '图像数据质量C3' ,
    PRIMARY KEY (ID)
) COMMENT = '图像数据质量C3 ';

DROP TABLE IF EXISTS indicatorOfService;
CREATE TABLE indicatorOfService(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    SERVICE_D11 DECIMAL(32,10)    COMMENT '服务连通率分值D11' ,
    SERVICE_D12 DECIMAL(32,10)    COMMENT '服务完好率分值D12' ,
    SERVICE_D13 DECIMAL(32,10)    COMMENT '服务使用率分值D13' ,
    SERVICE_D14 DECIMAL(32,10)    COMMENT '服务时延指标分值D14' ,
    PRIMARY KEY (ID)
) COMMENT = '服务的指标 ';

DROP TABLE IF EXISTS service;
CREATE TABLE service(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区划名称' ,
    SERVICE_OBEJCT_D1 DECIMAL(32,10)    COMMENT '服务对象D1' ,
    PRIMARY KEY (ID)
) COMMENT = '服务D1 ';

DROP TABLE IF EXISTS level;
CREATE TABLE level(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区名称' ,
    L_ID INT    COMMENT '监测层次ID' ,
    HEALTH_RATING DECIMAL(32,10)    COMMENT '健康度' ,
    PRIMARY KEY (ID)
) COMMENT = '层次 ';

DROP TABLE IF EXISTS holographic;
CREATE TABLE holographic(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区名称' ,
    HEALTH_RATING DECIMAL(32,10)    COMMENT '健康度' ,
    PRIMARY KEY (ID)
) COMMENT = '全息';

DROP TABLE IF EXISTS business;
CREATE TABLE business(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    DIAGTIME VARCHAR(32)    COMMENT '检测时间' ,
    CODE VARCHAR(32)    COMMENT '行政区划编码' ,
    NAME VARCHAR(32)    COMMENT '行政区名称' ,
    B_ID INT    COMMENT '业务系统ID' ,
    HEALTH_RATING DECIMAL(32,10)    COMMENT '健康度' ,
    PRIMARY KEY (ID)
) COMMENT = '业务';















