package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import com.lc.design.constant.TPDConsts;
import com.lc.design.filter.JPGFileFilter;
import com.lc.design.panel.DesignContainer;
import com.lc.design.unit.LogUtil;

public class ImageBtnListener extends MouseAdapter {
	private DesignContainer container;

	public ImageBtnListener(DesignContainer container) {
		this.container = container;
	}

	public void mouseClicked(MouseEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new JPGFileFilter());
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		chooser.setCurrentDirectory(TPDConsts.DEAULT_DIR);
		if (chooser.showOpenDialog(container) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				container.resetImg(new ImageIcon(Files.readAllBytes(Paths.get(file.getAbsolutePath()))));
			}
			catch (Exception ex) {
				LogUtil.disError(container, ex);
			}

		}
		container.requestFocus();
	}
}
