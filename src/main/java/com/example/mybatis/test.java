package com.example.mybatis;

import com.example.mybatis.utils.HardwareUtils;
import com.sun.xml.internal.ws.api.ResourceLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.DefaultResourceLoader;

import javax.annotation.Resource;

public class test {
    public static void main(String[] args) throws Exception {
        System.out.print("进测试");
        String CPU = HardwareUtils.getCPUSerial();
        System.out.print("CPU:"+CPU);
        String mac = HardwareUtils.getMac();
        System.out.print("mac:"+mac);

    }
}
