package com.example.oauth2core.properties;

import lombok.Data;

@Data
public class BrowserProperties {
    private String loginPage = "/imooc-signIn.html";
    private LoginType loginType = LoginType.JSON;
}
