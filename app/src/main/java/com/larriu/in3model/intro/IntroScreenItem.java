package com.larriu.in3model.intro;

public class IntroScreenItem {

    private String tittle, description;
    private int screenImage;

    public IntroScreenItem(String tittle, String description, int screenImage) {
        this.tittle = tittle;
        this.description = description;
        this.screenImage = screenImage;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScreenImage() {
        return screenImage;
    }

    public void setScreenImage(int screenImage) {
        this.screenImage = screenImage;
    }
}
