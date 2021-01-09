package com.kari.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CommonResult<T> {
private Integer code;
private String msg;
private T data;

public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
