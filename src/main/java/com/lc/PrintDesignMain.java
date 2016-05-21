package com.lc;

import java.awt.EventQueue;

import com.lc.design.PrintDesignFrame;

public class PrintDesignMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintDesignFrame frame = new PrintDesignFrame();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}