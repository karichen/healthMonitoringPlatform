package com.kari.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ReturnInfo {
    int id;//序号
    String registrationTime;//登记时间
    String sname;//姓名
//    String phone;//手机号
    String sid;//学号
    String college;//学院
    String grade;// 年级
    String clas;//班级
    String counselorName;//辅导员
//    String ifRegister;//是否登记
    String nowPlace;//现居住地
    String startCity;//出发城市
    String ifStopCity;//途径是否停留城市
    String returnDate;//返校时间
    String returnTime;//返校时间段
    String transportationType;//交通方式
    String plateNumber;//车牌车次
    String arriveStation;//到达车站
    String isHealth;//本人当前身体状况
    String livingTogether; //共同居住人身体状况


}
