package com.example.spring_test.cloudinary;

import org.springframework.http.HttpHeaders;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CloudService {

    public void getPics() {
        RestTemplate restTemplate = new RestTemplate();

        String API_KEY = "872422462183523";
        String API_SECRET = "TWE-hHZumObya4eS4za-YtWxjH4";
        String url = "https://api.cloudinary.com/v1_1/dheusvwas/resources/image/upload/cld-sample-5";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        String token = new String(Base64.getEncoder().encode((API_KEY + ":" + API_SECRET).getBytes()));
        headers.add("Authorization", "Basic " + token);

        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<byte[]> result = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        byte[] test = result.getBody();

        for (int i = 0; i < test.length; i++)
            System.out.println(test[i]);

        /*
         * ImageIO.getImageWritersBySuffix("jpg");
         * BufferedImage img;
         * try {
         * img = ImageIO.read(new ByteArrayInputStream(result.getBody()));
         * ImageIO.write(img, "jpg", new File("image.jpg"));
         * } catch (IOException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         */
    }

}
