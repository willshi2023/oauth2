package com.example.oauth2demo.web.controller;

import com.example.oauth2demo.dto.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    private String folder="D:\\代码\\oauth2\\oauth2-demo\\src\\main\\java\\com\\example\\oauth2demo\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        log.info("filesize: {}",file.getSize());
        File localFile = new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try(InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
            OutputStream outputStream = response.getOutputStream();) // jdk1.7新特性，在try的括号里面写流不需要手动关闭流
        {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");//指定下载的名字
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }catch (Exception e){
            log.error("exception is :{}",e.getMessage());
        }
    }
}
