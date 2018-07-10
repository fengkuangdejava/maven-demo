package com.liting.maven.start;

import com.liting.maven.pojo.User;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Start {
    public static void main(String args[]) throws IOException {
        User user = new User("小明",16);
        Start start = new Start();
        System.out.println("--------------------------------"+user.getName()+"-----------------------------------");
        start.getFile("aa.txt");
    }

    private  void getFile(String fileName) throws IOException {
    /*    ClassLoader classLoader = getClass().getClassLoader();
        *//**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         *//*
        URL url = classLoader.getResource(fileName);
        *//**
         * url.getFile() 得到这个文件的绝对路径
         *//*
        System.out.println(url.getFile());
        File file = new File(url.getFile());*/
        InputStream in = Start.class.getClassLoader().getResourceAsStream(fileName);
        System.out.println(inputStream2String(in));
       /* System.out.println(file.exists());*/
    }

    public   String   inputStream2String   (InputStream   in)   throws IOException {
        StringBuffer   out   =   new   StringBuffer();
        byte[]   b   =   new   byte[4096];
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {
            out.append(new   String(b,   0,   n));
        }
        return   out.toString();
    }
}
