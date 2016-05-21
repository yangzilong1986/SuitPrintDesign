package com.lc.design;

import javax.swing.JFrame;

import com.lc.design.panel.DesignContainer;

/**
 * 打印设计
 * 
 * @author liubq
 */
public class PrintDesignFrame extends JFrame {

	// 构造
	private DesignContainer designContainer;

	/**
	 * 初始化
	 */
	public PrintDesignFrame() {
		this.setTitle("套打设计器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.designContainer = new DesignContainer(this);
		this.add(designContainer);
		this.setLocation(400, 150);
		this.setSize(800, 600);
		this.setResizable(false);
	}

	public DesignContainer getDesignContainer() {
		return designContainer;
	}

}