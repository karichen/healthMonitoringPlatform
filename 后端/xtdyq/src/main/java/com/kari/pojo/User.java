package com.kari.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    int id;
    String sid;  //学号
    String clas;  //班级
    String name; //学生姓名
    String grade; //年纪
    String college;//学院
    String counselorName;//辅导员
//    String phone;  //手机号码
    String isDangerRegion; //是否本人为中、高风险地区人员
    String isTouchDangerRegion;//是否接触过中高风险地区人员
    String isArriveDangerRegion;//是否到达过中高风险地区
    String isTouchPatient;   //是否接触过确诊或疑似病人
    String isIllness;    //是否有发热/咳嗽/呼吸困难等症状
    String livingTogether; //共同居住人身体状况(正常、[发热、咳嗽、呼吸困难等症状]、确诊、疑似、其他)
    String isRelativeQuarantine; //是否有家庭成员或亲戚被隔离
    String isTouchOutlands; //是否接触过境外人员
    String temperature; //填报体温
//    String morningTemperature; //早晨填报体温
//    String noonTemperature; //中午填报体温
//    String eveningTemperature;//晚上填报体温
    String createDate;//记录创建的日期
    String addTime;//填报时间
}
