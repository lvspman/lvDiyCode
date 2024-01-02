package com.xiaolv.meta;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 吕小匠
 * @MyHeart Endless
 */
@NoArgsConstructor
@Data
public class Meta {

    private String name;
    private String description;
    private String basePackage;
    private String version;
    private String author;
    private String createTime;
    private FileConfig fileConfig;
    private ModelConfig modelConfig;

    @NoArgsConstructor
    @Data
    public static class FileConfig {
        private String sourceRootPath;
        private String inputRootPath;
        private String outputRootPath;
        private String type;
        private List<FileInfo> files;

        @NoArgsConstructor
        @Data
        public static class FileInfo {
            public String inputPath;
            public String outputPath;
            public String type;
            public String generateType;
            public String condition;
            public String groupKey;
            public String groupName;
            public List<FileInfo> files;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ModelConfig {
        private List<ModelInfo> models;

        @NoArgsConstructor
        @Data
        public static class ModelInfo {
            public String fieldName;
            public String type;
            public String description;
            public Object defaultValue;
            public String abbr;
            public String groupKey;
            public String groupName;
            public List<ModelInfo> models;
            public String condition;

            // 中间参数
            // 该分组下所有参数拼接字符串
            private String allArgsStr;
        }
    }
}
