package com.lc.design.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.lc.design.panel.DesignContainer;

public class ArrowBinding extends AbstractAction {

	private DesignContainer container;

	public ArrowBinding(String text, DesignContainer container) {
		super(text);
		putValue(ACTION_COMMAND_KEY, text);
		this.container = container;
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		System.out.println("Key Binding: " + actionCommand);
		container.moveTxt(e);
	}
}
