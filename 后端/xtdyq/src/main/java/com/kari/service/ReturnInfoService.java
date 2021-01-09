package com.kari.service;

import com.kari.pojo.CommonResult;
import com.kari.pojo.ReturnInfo;
import org.springframework.stereotype.Service;

@Service
public interface ReturnInfoService {
    //更新返校记录
    CommonResult updateReturnInfo(ReturnInfo returnInfo);

    //通过学号查询返校记录
    CommonResult queryReturnInfoBySid(ReturnInfo returnInfo);


}
