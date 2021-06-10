package com.atguigu.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class customerBlockHandler {
    public static String test(BlockException e){
        return "使用统一的处理方法";
    }
}
