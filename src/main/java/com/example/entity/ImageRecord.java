package com.example.entity;

import lombok.Data;

/**
 * @ClassName: ImageRecord
 * @Description: TODO
 * @Author: ZhaoJunfeng
 * @Date: 2024/3/26 10:40
 */
@Data
public class ImageRecord {
    private int index;
    private String url;
    private int level;
    private int type;
    private String description;

    public ImageRecord(int index, String url, int level, int type, String description) {
        this.index = index;
        this.url = url;
        this.level = level;
        this.type = type;
        this.description = description;
    }
}
