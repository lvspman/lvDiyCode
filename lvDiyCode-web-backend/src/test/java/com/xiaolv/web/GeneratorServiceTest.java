package com.xiaolv.web;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.json.JSONUtil;
import com.xiaolv.web.service.GeneratorService;
import com.xiaolv.web.model.entity.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class GeneratorServiceTest {

    @Resource
    private GeneratorService generatorService;

    @Test
    public void testInsert() {
        Generator generator = generatorService.getById(18L);
        for (int i = 0; i < 100000; i++) {
            generator.setId(null);
            generatorService.save(generator);
        }
    }


    @Test
    public void testBase64() {
        String jsonStr = "{\n" +
                "    \"files\": [\n" +
                "      {\n" +
                "        \"groupKey\": \"git\",\n" +
                "        \"groupName\": \"开源\",\n" +
                "        \"type\": \"group\",\n" +
                "        \"condition\": \"needGit\",\n" +
                "        \"files\": [\n" +
                "          {\n" +
                "            \"inputPath\": \".gitignore\",\n" +
                "            \"outputPath\": \".gitignore\",\n" +
                "            \"type\": \"file\",\n" +
                "            \"generateType\": \"static\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"inputPath\": \"README.md\",\n" +
                "            \"outputPath\": \"README.md\",\n" +
                "            \"type\": \"file\",\n" +
                "            \"generateType\": \"static\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"inputPath\": \"src/com/yupi/acm/MainTemplate.java.ftl\",\n" +
                "        \"outputPath\": \"src/com/yupi/acm/MainTemplate.java\",\n" +
                "        \"type\": \"file\",\n" +
                "        \"generateType\": \"dynamic\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }";
        String base64 = Base64Encoder.encode(jsonStr);
        System.out.println("base64"+base64);
    }

}