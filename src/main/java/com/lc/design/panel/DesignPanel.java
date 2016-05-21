package com.lc.design.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.lc.design.constant.TPDConsts;

/**
 * 菜单
 * 
 * @author liubq
 */
public class DesignPanel extends JPanel {

	// 图片
	private ImageIcon imageicon;

	// 容器
	@SuppressWarnings("unused")
	private DesignContainer dcesignContainer;

	/**
	 * 初始化
	 * 
	 * @param container
	 */
	public DesignPanel(DesignContainer container) {
		dcesignContainer = container;
		this.setBorder(BorderFactory.createLineBorder(Color.orange, TPDConsts.BORDER));
		this.setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imageicon != null) {
			imageicon.paintIcon(this, g, 0, 0);
		}
	}

	public Dimension getPreferredSize() {
		if (imageicon != null) {
			return new Dimension(imageicon.getIconWidth(), imageicon.getIconHeight());
		}
		return super.getPreferredSize();

	}

	/**
	 * 重绘底片
	 * 
	 * @param image
	 */
	public void rebuild(ImageIcon image) {
		imageicon = image;
		this.repaint();
	}

}