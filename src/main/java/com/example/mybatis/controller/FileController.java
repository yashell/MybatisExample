package com.example.mybatis.controller;

import com.example.mybatis.common.ServerResult;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@RestController
public class FileController {
    @PostMapping("/fileUpload")
    public Object fileUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        String code = UUID.randomUUID().toString();
        fileName = code + suffixName; // 新文件名
        File dest = new File(filePath + fileName);

        //调整大小
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thumbnails.of(new File(filePath + fileName))
                .sourceRegion(Positions.CENTER,400,400)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile(new File(filePath+code+ "-thumbnail"+ suffixName));

        String filename = "/temp-rainy/" + fileName;

        ServerResult<Object> serverResult = ServerResult.defaultSuccess(filename);
        return serverResult;
    }

    @GetMapping("/fileDown")
    public Object fileDown() {
        try {
            OutputStream os = new FileOutputStream("D://temp-rainy//a.jpg");
            Thumbnails.of("image/huhx.jpg")
                    .size(200, 200)
                    .outputFormat("jpg")
                    .toOutputStream(os);
//            ServerResult<Object> serverResult = ServerResult.defaultSuccess(os);
            return "http://localhost:1111/temp-rainy/a2db0e16-88a5-4e62-96c7-c96f595bef48.png";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
