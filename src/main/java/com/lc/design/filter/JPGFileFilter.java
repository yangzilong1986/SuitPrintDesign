package com.lc.design.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class JPGFileFilter extends FileFilter {
	public String getDescription() {
		return "*.jpg";
	}

	public boolean accept(File file) {
		String name = file.getName();
		return file.isDirectory() || name.toLowerCase().endsWith(".jpg");// 仅显示目录和.jpg文件
	}
}
