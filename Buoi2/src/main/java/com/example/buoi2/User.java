package com.example.buoi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    @Qualifier("XeVision")
    public  XeMay xeMay;
    public void getXeMay(){
        xeMay.xe();
    }
    @Autowired
    @Qualifier("XeWave")
    public XeMay xeMay2;
    public void getXeMay2(){
        xeMay2.xe();
    }

}
