package com.xiaolv.generator;

import com.xiaolv.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(DataModel model) throws TemplateException, IOException {
        String inputRootPath = ".source/project";
        String outputRootPath = "generated";

        String inputPath;
        String outputPath;

            boolean needGit = model.needGit;
            boolean loop = model.loop;
                String name = model.mainTemplate.name;
                String outputText = model.mainTemplate.outputText;

        // groupKey = git
        if(needGit) {
           inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
           outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
           StaticGenerator.copyFilesByHutool(inputPath, outputPath);
           inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
           outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
           StaticGenerator.copyFilesByHutool(inputPath, outputPath);
        }
       inputPath = new File(inputRootPath, "src/com/xiaolv/acm/MainTemplate.java.ftl").getAbsolutePath();
       outputPath = new File(outputRootPath, "src/com/xiaolv/acm/MainTemplate.java").getAbsolutePath();
       DynamicGenerator.doGenerate(inputPath, outputPath, model);
    }
}