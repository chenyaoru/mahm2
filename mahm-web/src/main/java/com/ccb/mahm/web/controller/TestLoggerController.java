package com.ccb.mahm.web.controller;

import java.util.Map;

import com.ccb.mahm.common.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testLog")
    public class TestLoggerController {

    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        log.error("getExceptionLogger===日志测试");
        log.info("getExceptionLogger===debug测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
        return "helloworld";

    }
}