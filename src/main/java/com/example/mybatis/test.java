package com.example.mybatis;

import com.example.mybatis.utils.HardwareUtils;

public class test {
    public static void main(String[] args) throws Exception {
        System.out.print("进测试");
        String CPU = HardwareUtils.getCPUSerial();
        System.out.print("CPU:"+CPU);
        String mac = HardwareUtils.getMac();
        System.out.print("mac:"+mac);

//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("http://localhost:6379");
//        jedis.auth("123456");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
//        System.out.println("======================key==========================");
//        //清除当前数据库所有数据
//        jedis.flushDB();
//        //设置键值对
//        jedis.set("xiaohua","我是fsdfdadasfas小花");
//        //查看存储的键的总数
//        System.out.println(jedis.dbSize());
//        //取出设置的键值对并打印
//        System.out.println(jedis.get("xiaohua"));

    }
}
