package com.example.application.model;

public class PictureModel {
    private int pictureId;
    private String pictureClass;
    private String pictureSrc;

    public PictureModel(int pictureId, String pictureClass, String pictureSrc){
        this.pictureId = pictureId;
        this.pictureClass = pictureClass;
        this.pictureSrc = pictureSrc;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureClass() {
        return pictureClass;
    }

    public void setPictureClass(String pictureClass) {
        this.pictureClass = pictureClass;
    }

    public String getPictureSrc() {
        return pictureSrc;
    }

    public void setPictureSrc(String pictureSrc) {
        this.pictureSrc = pictureSrc;
    }

}
