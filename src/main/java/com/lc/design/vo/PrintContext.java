package com.lc.design.vo;

public class PrintContext {
    private SysConfigVO config;

    private int imgWidth;
    private int imgHeight;

    public SysConfigVO getConfig() {
	return config;
    }

    public void setConfig(SysConfigVO config) {
	this.config = config;
    }

    public int getImgWidth() {
	return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
	this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
	return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
	this.imgHeight = imgHeight;
    }

}
