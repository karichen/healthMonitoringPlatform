
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `sid` varchar(255) NOT NULL COMMENT '学号',
  `clas` varchar(255) NOT NULL COMMENT '班级',
  `name` varchar(255) NOT NULL COMMENT '学生姓名',
  `grade` varchar(255) NOT NULL COMMENT '年级',
  `college` varchar(255) NOT NULL COMMENT '学院',
  `counselor_name` varchar(255) NOT NULL COMMENT '辅导员姓名',
  `is_danger_region` varchar(255) NOT NULL COMMENT '是否本人为中、高风险地区人员',
  `is_touch_danger_region` varchar(255) NOT NULL COMMENT '是否接触过中高风险地区人员',
  `is_arrive_danger_region` varchar(255) NOT NULL COMMENT '是否到达过中高风险地区',
  `is_touch_patient` varchar(255) NOT NULL COMMENT '是否接触过确诊或疑似病人',
  `is_illness` varchar(255) NOT NULL COMMENT '是否有发热/咳嗽/呼吸困难等症状',
  `living_together` varchar(255) NOT NULL COMMENT '共同居住人身体状况(正常、[发热、咳嗽、呼吸困难等症状]、确诊、疑似、其他)',
  `is_relative_quarantine` varchar(255) NOT NULL COMMENT '是否有家庭成员或亲戚被隔离',
  `is_touch_outlands` varchar(255) NOT NULL COMMENT '是否接触过境外人员',
  `temperature` varchar(255) NOT NULL DEFAULT 'no' COMMENT '当天体温',
  `create_date` varchar(255) NOT NULL COMMENT '记录创建的日期',
  `add_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录新增详细时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41056 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



DROP TABLE IF EXISTS `returnInfo`;
CREATE TABLE `returnInfo` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `registration_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
  `sname` varchar(255) NOT NULL COMMENT '姓名',
  `sid` varchar(255) NOT NULL COMMENT '学号',
  `college` varchar(255) NOT NULL COMMENT '学院',
  `grade` varchar(255) NOT NULL COMMENT '年级',
  `clas` varchar(255) NOT NULL COMMENT '班级',
  `counselor_name` varchar(255) NOT NULL DEFAULT '' COMMENT '辅导员',
  `now_place` varchar(255) NOT NULL DEFAULT '' COMMENT '现居住地',
  `start_city` varchar(255) NOT NULL DEFAULT '' COMMENT '出发城市',
  `if_stop_city` varchar(255) NOT NULL DEFAULT '' COMMENT '途径是否停留城市',
  `return_date` varchar(255) NOT NULL DEFAULT '' COMMENT '返校时间',
  `return_time` varchar(255) NOT NULL DEFAULT '' COMMENT '返校时间段',
  `transportation_type` varchar(255) NOT NULL DEFAULT '' COMMENT '交通方式',
  `plate_number` varchar(255) NOT NULL DEFAULT '' COMMENT '车牌车次',
  `arrive_station` varchar(255) NOT NULL DEFAULT '' COMMENT '到达车站',
  `is_health` varchar(255) NOT NULL DEFAULT '' COMMENT '本人当前身体状况',
  `living_together` varchar(255) NOT NULL DEFAULT '' COMMENT '共同居住人身体状况',
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2335 DEFAULT CHARSET=utf8 COMMENT='返校登记表格';
