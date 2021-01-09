package com.kari.service;

import com.kari.mapper.UserMapper;
import com.kari.pojo.CommonResult;
import com.kari.pojo.User;
import com.kari.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    DateUtil dateUtil;

    @Autowired
    CommonResult commonResult;
   //更新体温
   public CommonResult  updateTemperature(User user,String temperature){
       ReentrantLock lock = new ReentrantLock();
       lock.lock();
       String msg="unknown error";
       Integer code=405;
       try {
           if(userService.ifExit(user)){ //不存在记录就插入
               userService.addInfo(user);
           }
           int H= Integer.parseInt(dateUtil.getH());

           if(H<17){
               user.setTemperature(temperature);
               return userService.updateTemperature(user);
           }else {
               msg="out of time";
           }
//           if(H>=6&&H<10){
//               //早晨填报
//               user.setMorningTemperature(temperature);
//               return userService.updateMorningTemperature(user);
//           }else if(H>=11&&H<13){
//               user.setNoonTemperature(temperature);
//               return userService.updateNoonTemperature(user);
//           }else if(H>=19&&H<23) {
//               user.setEveningTemperature(temperature);
//               return  userService.updateEveningTemperature(user);
//           }else {
//               msg="out of time";
//           }
           commonResult.setCode(code);
           commonResult.setMsg(msg);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
       return commonResult;
    }



    //插入记录
    public int addInfo(User user){
      return  userMapper.addInfo(user);
    }

    //查询当天是否有过记录 true 有 false没有
    public  boolean ifExit(User user){
        if(userMapper.queryNum(user)==0){
            return true;
        }else {
            return false;
        }
    }

    //更新体温
    @Override
    public CommonResult updateTemperature(User user) {
        String msg="unknown error";
        Integer code=405;
          if (userService.queryUser(user).getTemperature().equals("no")){
             if(userMapper.updateTemperature(user)>0){ msg="success"; code=200;}
          }else {
              msg="repeat";
          }
          commonResult.setCode(code);
          commonResult.setMsg(msg);
          return commonResult;
    }

//    //更新早间体温
//    public CommonResult updateMorningTemperature(User user){
//        String msg="unknown error";
//        Integer code=405;
//          if (userService.queryUser(user).getMorningTemperature().equals("no")){
//             if(userMapper.updateMorningTemperature(user)>0){ msg="success"; code=200;}
//          }else {
//              msg="moring repeat";
//          }
//          commonResult.setCode(code);
//          commonResult.setMsg(msg);
//          return commonResult;
//    }
//
//    //更新午间体温
//    public CommonResult updateNoonTemperature(User user){
//        String msg="unknown error";
//        Integer code=405;
//        if(userService.queryUser(user).getNoonTemperature().equals("no")){
//            if(userMapper.updateNoonTemperature(user)>0){msg="success"; code=200;}
//        }else {
//            msg="noon repeat";
//        }
//        commonResult.setCode(code);
//        commonResult.setMsg(msg);
//        return commonResult;
//    }
//
//    //更新晚间体温
//    public CommonResult updateEveningTemperature(User user){
//        String msg="unknown error";
//        Integer code=405;
//        if(userService.queryUser(user).getEveningTemperature().equals("no")){
//            if(userMapper.updateEveningTemperature(user)>0){msg="success"; code=200;}
//        }else {
//            msg="evening repeat";
//        }
//        commonResult.setCode(code);
//        commonResult.setMsg(msg);
//        return commonResult;
//    }

    //查询最近七天用户信息
    public List<User> queryUserInfoList(User user){
       return  userMapper.queryUserInfoList(user);
    }

    //查询一个user
    public User queryUser(User user){
        return userMapper.queryUser(user);
    }

}
