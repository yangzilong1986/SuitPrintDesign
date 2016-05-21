package com.lc.design.panel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.lc.design.action.ConfigBtnListener;
import com.lc.design.action.DeleteBtnListener;
import com.lc.design.action.ExportBtnListener;
import com.lc.design.action.ImageBtnListener;
import com.lc.design.action.ImportBtnListener;
import com.lc.design.action.OccupyBtnListener;
import com.lc.design.action.OccupyEditMouseListener;
import com.lc.design.action.PreviewBtnListener;
import com.lc.design.constant.TPDConsts;

/**
 * 菜单
 * 
 * @author liubq
 */
public class MenuPanel extends JPanel {

	// 容器
	private DesignContainer designContainer;

	/**
	 * 初始化
	 * 
	 * @param container
	 */
	public MenuPanel(DesignContainer container) {
		this.designContainer = container;
		this.setBorder(BorderFactory.createLineBorder(Color.orange, TPDConsts.BORDER));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 1));
		JButton backgroundBtn = new JButton("底片");
		this.add(backgroundBtn);
		JButton occupyBtn = new JButton("插入");
		this.add(occupyBtn);
		JButton occupyEditBtn = new JButton("编辑");
		this.add(occupyEditBtn);
		JButton deleteBtn = new JButton("删除");
		this.add(deleteBtn);
		JButton previewBtn = new JButton("预览");
		this.add(previewBtn);
		JButton configBtn = new JButton("配置");
		this.add(configBtn);
		JButton importBtn = new JButton("导入");
		this.add(importBtn);
		JButton exportBtn = new JButton("导出");
		this.add(exportBtn);
		backgroundBtn.addMouseListener(new ImageBtnListener(designContainer));
		occupyBtn.addMouseListener(new OccupyBtnListener(designContainer));
		importBtn.addMouseListener(new ImportBtnListener(designContainer));
		exportBtn.addMouseListener(new ExportBtnListener(designContainer));
		occupyEditBtn.addMouseListener(new OccupyEditMouseListener(designContainer));
		previewBtn.addMouseListener(new PreviewBtnListener(designContainer));
		deleteBtn.addMouseListener(new DeleteBtnListener(designContainer));
		configBtn.addMouseListener(new ConfigBtnListener(designContainer));
	}

}