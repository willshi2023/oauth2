package com.example.oauth2demo.web.controller;

import com.example.oauth2demo.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        log.info("filesize: {}",file.getSize());
        String folder="D:\\代码\\oauth2\\oauth2-demo\\src\\main\\java\\com\\example\\oauth2demo\\web\\controller";
        File localFile = new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }
}
