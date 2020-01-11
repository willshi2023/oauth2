package com.example.oauth2demo.dto;

import lombok.Data;

import java.io.File;

@Data
public class FileInfo {
    private String path;
    public FileInfo(String path){
        this.path = path;
    }
}
