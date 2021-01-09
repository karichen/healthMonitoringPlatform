package com.kari.service;

import com.kari.mapper.ReturnInfoMapper;
import com.kari.pojo.CommonResult;
import com.kari.pojo.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class ReturnInfoServiceImpl  implements ReturnInfoService {

    @Autowired
    CommonResult commonResult;

    @Autowired
    ReturnInfoMapper returnInfoMapper;

    @Autowired
    ReturnInfo returnInfo;

    //更新返校记录
    @Override
    public CommonResult updateReturnInfo(ReturnInfo returnInfo) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        String msg="error";
        Integer code=405;
        try {
            int num=returnInfoMapper.queryNum(returnInfo.getSid()); //查询学号对应记录数
            if (num>0){ //如果大于零,说明已经填报过则更新
                if (returnInfoMapper.updateReturnInfo(returnInfo)>0) {msg="success"; code=200;}
            }else { //否则就重新插入记录
                if(returnInfoMapper.addReturnInfo(returnInfo)>0) {msg="success"; code=200;}
            }
            commonResult.setCode(code);
            commonResult.setMsg(msg);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return commonResult;
    }

    //通过学号查询返校记录
    @Override
    public CommonResult queryReturnInfoBySid(ReturnInfo returnInfo) {
        String msg="error";
        Integer code=405;
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
        int num=returnInfoMapper.queryNum(returnInfo.getSid()); //查询学号对应记录数
        if(num<1){msg="no info";}
        else{ msg="success";code=200;}
        commonResult.setCode(code);
        commonResult.setMsg(msg);
        commonResult.setData(returnInfoMapper.queryReturnInfoBySid(returnInfo.getSid()));
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
         return commonResult;

    }
}
