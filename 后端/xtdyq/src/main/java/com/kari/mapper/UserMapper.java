package com.kari.mapper;

import com.kari.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
  int addInfo(User user);

  int queryNum(User user);

//  int updateMorningTemperature(User user);
//
//  int updateNoonTemperature(User user);
//
//  int updateEveningTemperature(User user);

  int updateTemperature(User user);

  User queryUser(User user);

  List<User> queryUserInfoList(User user);

}
