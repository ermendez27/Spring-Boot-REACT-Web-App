package com.example.spring_test.cloudinary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/pics")
public class CloudController {
    private final CloudService cloudService;

    @Autowired
    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    @GetMapping
    public void getPics() {
        cloudService.getPics();
    }
}
