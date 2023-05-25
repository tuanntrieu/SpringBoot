package com.example.buoi7.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigCloudinary {
    @Bean
    Cloudinary cloudinary(){
        Map<String,String>config =new HashMap<>();
        config.put("api_key","777472666545861");
        config.put("api_secret","DW6I8TSkkBIX4Om20vMf7JL-1LM");
        config.put("cloud_name","ddwkfsbfl");
        return new Cloudinary(config);
    }
}
