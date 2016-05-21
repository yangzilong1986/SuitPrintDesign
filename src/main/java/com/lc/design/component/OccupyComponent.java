package com.lc.design.component;

import java.awt.Color;

import javax.swing.JTextArea;

import com.lc.design.unit.FontUtil;
import com.lc.design.vo.OccupyVO;

/**
 * 占位符对象
 * 
 * @author liubq
 */
public class OccupyComponent extends JTextArea {

    // 数据
    private OccupyVO data;

    /**
     * 安装信息初始化占位符
     * 
     * @param vo
     */
    public void initInfo(OccupyVO vo) {
	data = vo;
	resetInfo(vo);

    }

    /**
     * 安装信息初始化占位符
     * 
     * @param vo
     */
    private void resetInfo(OccupyVO vo) {
	if (vo != null) {
	    this.setText(vo.getName());
	    this.setBounds(vo.getPositionX(), vo.getPositionY(), vo.getWidth(), vo.getHeight());
	    this.setBackground(Color.GRAY);
	    if (vo.getFc() != null) {
		this.setFont(FontUtil.convert(vo.getFc().getFont()));
		this.setForeground(FontUtil.convert(vo.getFc().getColor()));
	    }
	    this.setEditable(false);
	}
    }

    /**
     * 取得信息
     * 
     * @return
     */
    public OccupyVO getInfo() {
	data.setPositionX(this.getX());
	data.setPositionY(this.getY());
	return data;
    }
}
