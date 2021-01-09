package com.kari.mapper;

import com.kari.pojo.ReturnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReturnInfoMapper {
    int addReturnInfo(ReturnInfo returnInfo);

    int updateReturnInfo(ReturnInfo returnInfo);

    int queryNum(String sid);

    ReturnInfo queryReturnInfoBySid(String sid);
}
