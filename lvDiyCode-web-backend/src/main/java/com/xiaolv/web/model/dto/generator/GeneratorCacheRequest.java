package com.xiaolv.web.model.dto.generator;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 吕小匠
 * @MyHeart Endless
 */
@Data
public class GeneratorCacheRequest implements Serializable {

    /**
     * 生成器的 id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}
