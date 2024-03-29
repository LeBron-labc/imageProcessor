package com.example.controller;

import com.example.service.imageService;
import com.example.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: imageController
 * @Description: TODO
 * @Author: ZhaoJunfeng
 * @Date: 2024/3/15 18:09
 */

@RestController
@RequestMapping("/image")
public class imageController {

    @Autowired
    private imageService   imageService;

    @PostMapping("/processImages")
    public Response<String> processImages(@RequestParam("folderPath")  String folderPath,@RequestParam("baseUrl")  String baseUrl) {
       return imageService.logImageDetailsToFile(folderPath,baseUrl);

    }


}
