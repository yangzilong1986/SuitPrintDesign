package com.lc.design.vo;

import java.util.List;

public class DesignVO {
    private int width;
    private int height;
    private int designWidth;
    private int designHeight;

    private int imgWidth;
    private int imgHeight;
    private int menuWidth;
    private int menuHeight;

    private List<OccupyVO> datas;

    private SysConfigVO configVO = new SysConfigVO();

    public int getWidth() {
	return width;
    }

    public void setWidth(int width) {
	this.width = width;
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	this.height = height;
    }

    public int getDesignWidth() {
	return designWidth;
    }

    public void setDesignWidth(int designWidth) {
	this.designWidth = designWidth;
    }

    public int getDesignHeight() {
	return designHeight;
    }

    public void setDesignHeight(int designHeight) {
	this.designHeight = designHeight;
    }

    public int getMenuWidth() {
	return menuWidth;
    }

    public void setMenuWidth(int menuWidth) {
	this.menuWidth = menuWidth;
    }

    public int getMenuHeight() {
	return menuHeight;
    }

    public void setMenuHeight(int menuHeight) {
	this.menuHeight = menuHeight;
    }

    public List<OccupyVO> getDatas() {
	return datas;
    }

    public void setDatas(List<OccupyVO> datas) {
	this.datas = datas;
    }

    public SysConfigVO getConfigVO() {
	return configVO;
    }

    public void setConfigVO(SysConfigVO configVO) {
	this.configVO = configVO;
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

    public PrintContext build() {
	PrintContext context = new PrintContext();
	context.setConfig(configVO);
	context.setImgHeight(imgHeight);
	context.setImgWidth(imgWidth);
	return context;
    }
}
