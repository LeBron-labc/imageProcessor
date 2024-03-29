package com.example.util;

import lombok.Data;

/**
 * @ClassName: Response
 * @Description: TODO
 * @Author: ZhaoJunfeng
 * @Date: 2024/3/15 18:18
 */
@Data
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters and setters
}
