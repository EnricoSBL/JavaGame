package com.example.application.views.dtos;

public class PictureDto {

    private int pictureId;
    private String pictureClass;
    private String pictureSrc;

    public PictureDto(int pictureId, String pictureClass, String pictureSrc){
        this.pictureId = pictureId;
        this.pictureClass = pictureClass;
        this.pictureSrc = pictureSrc;
    }

    public PictureDto(){}

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
