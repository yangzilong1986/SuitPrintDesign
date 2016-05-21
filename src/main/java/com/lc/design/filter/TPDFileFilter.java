package com.lc.design.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import com.lc.design.constant.TPDConsts;

public class TPDFileFilter extends FileFilter {
	public String getDescription() {
		return TPDConsts.F_NAME;
	}

	public boolean accept(File file) {
		String name = file.getName();
		return file.isDirectory() || name.toLowerCase().endsWith(TPDConsts.F_NAME);// 仅显示目录和.jpg文件
	}
}
