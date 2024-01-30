package com.xiaolv.cli.command;

/**
 * @author 吕小匠
 * @MyHeart Endless
 */

import cn.hutool.core.util.ReflectUtil;
import com.xiaolv.model.DataModel;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * 查看参数信息
 */

@Command(name = "config",
        description = "查看参数信息",
        mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    @Override
    public void run() {
        System.out.println("查看参数信息：");

        Field[] fields = ReflectUtil.getFields(DataModel.class);

        for (Field field: fields) {
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
            System.out.println("---");
        }
    }
}
