package com.example.buoi1;

import org.springframework.stereotype.Component;

@Component("Samsung")
public class SamSung implements Phone{

    @Override
    public void using() {
        System.out.println("Dung Sam Sung");
    }
}
