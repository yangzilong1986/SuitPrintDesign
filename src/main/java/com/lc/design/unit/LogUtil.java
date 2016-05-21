package com.lc.design.unit;

import java.awt.Component;

import javax.swing.JOptionPane;

public class LogUtil {
	public static void disError(Component parentComponent, String msg) {
		JOptionPane.showMessageDialog(parentComponent, msg, "异常提示", JOptionPane.ERROR_MESSAGE);
	}

	public static void disError(Component parentComponent, Exception e) {
		JOptionPane.showMessageDialog(parentComponent, e.getMessage(), "异常提示", JOptionPane.ERROR_MESSAGE);
	}
}
