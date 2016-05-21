package com.lc.design.action;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.lc.design.panel.DesignContainer;

public class OccupyKeyListener extends KeyAdapter {
	private DesignContainer designContainer;

	public OccupyKeyListener(DesignContainer container) {
		designContainer = container;
	}

	public void keyPressed(final KeyEvent e) {
		designContainer.moveTxt(e);
	}

}