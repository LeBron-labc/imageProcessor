package com.example.service;

import com.example.util.ErrorCode;
import com.example.util.Response;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @ClassName: imageService
 * @Description: TODO
 * @Author: ZhaoJunfeng
 * @Date: 2024/3/15 18:09
 */
@Service
public class imageService {

    private static final String LOG_FILE_PATH = "output_log.txt";

    public Response<String> logImageDetailsToFile(String folderPath, String baseUrl) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH))) { // 不使用 'true' 参数，替换原有文件内容
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    if (file.isFile() && isImageFile(file)) {
                        String originalName = file.getName();
                        String extension = FilenameUtils.getExtension(originalName); // 需引入Apache Commons IO库

                        // 构造新的URL形式的名称
                        String urlName = baseUrl + "/" + originalName;

                        // 将日志写入文件
                        writer.println("原图名称: " + originalName + ", URL形式: " + urlName);
                    }
                }
                writer.println("图片文件遍历完成。");
                return new Response<>(200, "图片处理完成", null);
            } else {
                writer.println("文件夹为空或不存在。");
                return new Response<>(ErrorCode.FILE_NOT_FOUND.getCode(), ErrorCode.FILE_NOT_FOUND.getMessage(), null);
            }
        } catch (IOException e) {
            System.err.println("无法写入日志文件: " + e.getMessage());
            e.printStackTrace();
        }
        return new Response<>(200, "图片处理完成", null);
    }
    // 假设isImageFile是一个用于检查文件是否为图像文件的方法，您可能需要自行实现或引用已存在的库
    private boolean isImageFile(File file) {
        // 这里可以根据文件扩展名判断是否为图片文件
        String ext = FilenameUtils.getExtension(file.getName()); // 同样需要Apache Commons IO库
        return Arrays.asList("jpg", "jpeg", "png", "gif","webp").contains(ext.toLowerCase());
    }



}
