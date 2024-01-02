package com.xiaolv.generator.main;

public class MainGenerator extends GenerateTemplate{
    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("这次不输出dist目录哦！");
    }
}