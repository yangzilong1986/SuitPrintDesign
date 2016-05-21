package com.lc.design.constant;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public enum Direction {

	UP("Up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0)), DOWN("Down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0)), LEFT("Left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0)), RIGHT("Right",
			KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));

	Direction(String text, KeyStroke keyStroke) {
		this.text = text;
		this.keyStroke = keyStroke;
	}

	private String text;
	private KeyStroke keyStroke;

	public String getText() {
		return text;
	}

	public KeyStroke getKeyStroke() {
		return keyStroke;
	}

	@Override
	public String toString() {
		return text;
	}
}