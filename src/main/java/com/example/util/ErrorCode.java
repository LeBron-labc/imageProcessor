package com.example.util;

public enum ErrorCode {
    FILE_NOT_FOUND(404, "文件未找到"),
    FILE_PROCESSING_ERROR(500, "文件处理错误");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

