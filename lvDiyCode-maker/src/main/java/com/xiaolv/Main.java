package com.xiaolv;

import com.xiaolv.generator.main.GenerateTemplate;
import com.xiaolv.generator.main.MainGenerator;
import com.xiaolv.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        GenerateTemplate generateTemplate = new MainGenerator();
        generateTemplate.doGenerate();
    }
}