package com.lc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import com.lc.design.constant.TPDConsts;
import com.lc.design.filter.TPDFileFilter;
import com.lc.design.unit.DataItemUtil;
import com.lc.design.unit.HtmlUtil;
import com.lc.design.vo.DataVO;

/**
 * 模板答应的Web代码生成
 * 
 * @author liubq
 */
public class PrintHtmlMain {
    public static void main(String[] args) {

	try {

	    JFileChooser chooser = new JFileChooser();
	    chooser.setFileFilter(new TPDFileFilter());
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setMultiSelectionEnabled(false);
	    chooser.setCurrentDirectory(TPDConsts.DEAULT_DIR);
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		File file = chooser.getSelectedFile();
		Map<String, DataVO> dataMap = new HashMap<String, DataVO>();
		dataMap.put("#name0#", new DataVO(DataItemUtil.build("12")));
		dataMap.put("#name1#", new DataVO(DataItemUtil.build("34")));
		dataMap.put("#name2#", new DataVO(DataItemUtil.build(" ")));
		dataMap.put("#name3#", new DataVO(DataItemUtil.build(" ")));
		dataMap.put("#name4#", new DataVO(DataItemUtil.build(" ")));
		dataMap.put("#name5#", new DataVO(DataItemUtil.build(" ")));
		String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		String html = HtmlUtil.buildIframe(json, dataMap);
		System.out.println(html);
	    }

	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
