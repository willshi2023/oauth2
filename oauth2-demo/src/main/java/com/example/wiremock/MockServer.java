package com.example.wiremock;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServer {
    public static void main(String[] args) throws IOException {
        configureFor(8062);
        removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");


    }

    private static void mock(String url, String fileName) throws IOException {
        String filePath = "D:\\代码\\oauth2\\oauth2-demo\\src\\main\\resources\\mock\\response\\";
        File file = new File(filePath+fileName+".txt");
        String content = StringUtils.join(FileUtils.readLines(file, "UTF-8"), "\n");
        stubFor(get(urlPathEqualTo(url))
                .willReturn(aResponse()
                        .withBody(content)
                        .withStatus(200)));
    }
}
