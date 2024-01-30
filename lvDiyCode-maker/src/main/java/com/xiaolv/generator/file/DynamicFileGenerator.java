package com.xiaolv.generator.file;

import cn.hutool.core.io.FileUtil;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * @author 吕小匠
 * @MyHeart Endless
 */
public class DynamicFileGenerator {
    /**
     * 生成文件 （模板+数据模型 = 输出）
     *
     * @param inputPath 模板位置
     * @param outputPath 输出文件位置
     * @param dataModel 数据模型
     * @throws IOException,TemplateException
     */
    public static void doGenerateByPath(String inputPath, String outputPath, Object dataModel) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateDir);
        cfg.setDefaultEncoding("UTF-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);

        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }

        FileWriter fileWriter = new FileWriter(outputPath);
        template.process(dataModel, fileWriter);

        fileWriter.close();
    }

    /**
     * 生成文件 （模板+数据模型 = 输出）
     *
     * @param relativeInputPath 模板位置
     * @param outputPath 输出文件位置
     * @param dataModel 数据模型
     * @throws IOException,TemplateException
     */
    public static void doGenerate(String relativeInputPath, String outputPath, Object dataModel) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

        // 获取模板文件所属包和模板名称
        int lastSplitIndex = relativeInputPath.lastIndexOf("/");
        String basePackagePath = relativeInputPath.substring(0, lastSplitIndex);
        String templateName = relativeInputPath.substring(lastSplitIndex + 1);

        // 通过类加载器读取模板
        ClassTemplateLoader templateLoader = new ClassTemplateLoader(DynamicFileGenerator.class, basePackagePath);
        cfg.setTemplateLoader(templateLoader);
        cfg.setDefaultEncoding("UTF-8");

        // 创建模板对象，加载指定模板
        Template template = cfg.getTemplate(templateName);

        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }

        FileWriter fileWriter = new FileWriter(outputPath);
        template.process(dataModel, fileWriter);

        fileWriter.close();
    }
}
