package com.kari.service;

import com.kari.pojo.CommonResult;
import com.kari.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //更新体温
    CommonResult updateTemperature(User user);

    //插入记录
    int addInfo(User user);

    //查询当天是否有过记录 true 有 false没有
    boolean ifExit(User user);

//    //更新早间体温
//    CommonResult updateMorningTemperature(User user);
//
//    //更新午间体温
//    CommonResult updateNoonTemperature(User user);
//
//    //更新晚间体温
//    CommonResult updateEveningTemperature(User user);

    //查询最近七天用户信息
    public List<User> queryUserInfoList(User user);

    //查询一个user
    User queryUser(User user);
}
