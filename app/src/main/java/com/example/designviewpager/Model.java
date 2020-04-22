package com.example.designviewpager;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private String title;
    private String desc;
    private int img;
    private  List<Model> models=new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Model() {
    }

    public Model(String title, String desc, int img) {
        this.title = title;
        this.desc = desc;
        this.img = img;
    }
    public void setAllModels(){


    }
    public List<Model> getAllModels(){
         return models;
    }
}
