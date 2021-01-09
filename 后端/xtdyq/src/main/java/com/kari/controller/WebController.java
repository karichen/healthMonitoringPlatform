package com.kari.controller;

import com.kari.pojo.CommonResult;
import com.kari.pojo.ReturnInfo;
import com.kari.pojo.User;
import com.kari.service.ReturnInfoService;
import com.kari.service.UserServiceImpl;
import com.kari.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    User user;

    @Autowired
    DateUtil dateUtil;

    @Autowired
    CommonResult commonResult;

    @Autowired
    ReturnInfoService returnInfoService;

    @Autowired
    ReturnInfo returnInfo;

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @PostMapping("/temperatureReport")
     public CommonResult temperatureReport(@RequestParam(value="sid")  String sid,
                                           @RequestParam(value="clas")  String clas,
                                           @RequestParam(value="name")  String name,
                                           @RequestParam(value="grade")  String grade,
                                           @RequestParam(value="college")  String college,
                                           @RequestParam(value="counselor_name")  String counselorName,
//                                           @RequestParam(value="phone")  String phone,
                                           @RequestParam(value="is_danger_region")  String isDangerRegion,
                                           @RequestParam(value="is_touch_danger_region")  String isTouchDangerRegion,
                                           @RequestParam(value="is_arrive_danger_region")  String isArriveDangerRegion,
                                           @RequestParam(value="is_touch_patient")  String isTouchPatient,
                                           @RequestParam(value="is_illness")  String isIllness,
                                           @RequestParam(value="living_together")  String livingTogether,
                                           @RequestParam(value="is_relative_quarantine")  String isRelativeQuarantine,
                                           @RequestParam(value="is_touch_outlands")  String isTouchOutlands,
                                           @RequestParam(value="temperature")  String temperature){
        user.setSid(sid);
        user.setClas(clas);
        user.setName(name);
        user.setGrade(grade);
        user.setCollege(college);
        user.setCounselorName(counselorName);
//        user.setPhone(phone);
        user.setIsDangerRegion(isDangerRegion);
        user.setIsTouchDangerRegion(isTouchDangerRegion);
        user.setIsArriveDangerRegion(isArriveDangerRegion);
        user.setIsTouchPatient(isTouchPatient);
        user.setIsIllness(isIllness);
        user.setLivingTogether(livingTogether);
        user.setIsRelativeQuarantine(isRelativeQuarantine);
        user.setIsTouchOutlands(isTouchOutlands);
        user.setCreateDate(dateUtil.getDay());

        return userService.updateTemperature(user,temperature);
    }


    @PostMapping("/seven/info")
    public CommonResult queryUserSevenInfo(@RequestParam(value="sid")  String sid){
        user.setSid(sid);
        commonResult.setCode(200);
        commonResult.setMsg("success");
        commonResult.setData(userService.queryUserInfoList(user));
        return commonResult;
    }

    @PostMapping("/return/register")
    public CommonResult registerReturnInfo( @RequestParam(value="sname")String sname,
//                                            @RequestParam(value="phone")String phone,
                                            @RequestParam(value="sid")String sid,
                                            @RequestParam(value="college")String college,
                                            @RequestParam(value="grade")String grade,
                                            @RequestParam(value="clas")String clas,
                                            @RequestParam(value="counselor_name")String counselorName,
//                                            @RequestParam(value="if_register")String ifRegister,
                                            @RequestParam(value="now_place")String nowPlace,
                                            @RequestParam(value="start_city")String startCity,
                                            @RequestParam(value="if_stop_city")String ifStopCity,
                                            @RequestParam(value="return_date")String returnDate,
                                            @RequestParam(value="return_time")String returnTime,
                                            @RequestParam(value="transportation_type")String transportationType,
                                            @RequestParam(value="plate_number")String plateNumber,
                                            @RequestParam(value="arrive_station")String arriveStation,
                                            @RequestParam(value="is_health")String isHealth,
                                            @RequestParam(value="living_together")String livingTogether){
         returnInfo.setSname(sname);
//         returnInfo.setPhone(phone);
         returnInfo.setSid(sid);
         returnInfo.setCollege(college);
         returnInfo.setGrade(grade);
         returnInfo.setClas(clas);
         returnInfo.setCounselorName(counselorName);
//         returnInfo.setIfRegister(ifRegister);
         returnInfo.setNowPlace(nowPlace);
         returnInfo.setStartCity(startCity);
         returnInfo.setIfStopCity(ifStopCity);
         returnInfo.setReturnDate(returnDate);
         returnInfo.setReturnTime(returnTime);
         returnInfo.setTransportationType(transportationType);
         returnInfo.setPlateNumber(plateNumber);
         returnInfo.setArriveStation(arriveStation);
         returnInfo.setIsHealth(isHealth);
         returnInfo.setLivingTogether(livingTogether);
        return returnInfoService.updateReturnInfo(returnInfo);
    }


    @PostMapping("/return/info")
    public CommonResult queryStudentReturnInfo(@RequestParam(value="sid")  String sid){
        returnInfo.setSid(sid);
        return returnInfoService.queryReturnInfoBySid(returnInfo);
    }

}
