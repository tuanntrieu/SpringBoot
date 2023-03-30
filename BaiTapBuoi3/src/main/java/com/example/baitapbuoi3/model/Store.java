package com.example.baitapbuoi3.model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    static List<User> list=new ArrayList<>();
    static{
        list.add(new User("tuantrieu","tuan03nd","Trieu Dang Tuan"));
        list.add(new User("thangnohope","thang04nd","Pham Duc Thang"));
        list.add(new User("tienhetthoi","tien03nd","Pham Trung Tien"));
    }

    public static List<User> getList() {
        return list;
    }

    public static void setList(List<User> list) {
        Store.list = list;
    }
}
