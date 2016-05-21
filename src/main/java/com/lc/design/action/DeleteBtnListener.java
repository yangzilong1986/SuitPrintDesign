package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lc.design.panel.DesignContainer;

public class DeleteBtnListener extends MouseAdapter {
	private DesignContainer container;

	public DeleteBtnListener(DesignContainer container) {
		this.container = container;
	}

	public void mouseClicked(MouseEvent e) {
		container.removeNowTxt();
	}
}
