package com.lc.design.unit;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.lc.design.constant.TPDConsts;
import com.lc.design.vo.DataItemVO;
import com.lc.design.vo.DataVO;
import com.lc.design.vo.DesignVO;
import com.lc.design.vo.OccupyVO;

/**
 * HTML代码生成
 * 
 * @author liubq
 */
public class HtmlUtil {

    /**
     * 组装成html代码
     * 
     * @param pdjFile
     * @param dataMap
     * @return
     * @throws Exception
     */
    public static String build(File pdjFile, Map<String, DataVO> dataMap) throws Exception {
	String json = new String(Files.readAllBytes(Paths.get(pdjFile.getAbsolutePath())));
	return buildHtml(json, dataMap);
    }

    /**
     * 组装成html代码
     * 
     * @param pdjFile
     * @param dataMap
     * @return
     * @throws Exception
     */
    public static String buildHtml(String json, Map<String, DataVO> dataMap) throws Exception {
	// 默认非空对象
	if (dataMap == null) {
	    dataMap = new HashMap<String, DataVO>();
	}
	DesignVO design = JsonUtils.convertToObject(json, DesignVO.class);
	StringBuilder sb = new StringBuilder();
	sb.append("<!doctype html>").append("\n");
	sb.append("<html>").append("\n");
	sb.append(" <head>").append("\n");
	sb.append("  <meta charset=\"UTF-8\">").append("\n");
	sb.append("  <title>Document</title>").append("\n");
	sb.append(" </head>").append("\n");
	sb.append(" <body>").append("\n");
	DataVO value;
	for (OccupyVO vo : design.getDatas()) {
	    value = dataMap.get(vo.getName());
	    value = value == null ? new DataVO(DataItemUtil.build(vo.getName())) : value;
	    sb.append("  ").append(buildDiv(design, vo, value)).append("\n");
	}
	sb.append(" </body>").append("\n");
	sb.append("</html>").append("\n");
	return sb.toString();
    }

    /**
     * 组装成html代码
     * 
     * @param pdjFile
     * @param dataMap
     * @return
     * @throws Exception
     */
    public static String buildIframe(String json, Map<String, DataVO> dataMap) throws Exception {
	DesignVO design = JsonUtils.convertToObject(json, DesignVO.class);
	StringBuilder sb = new StringBuilder();
	DataVO value;
	for (OccupyVO vo : design.getDatas()) {
	    value = dataMap.get(vo.getName());
	    value = value == null ? new DataVO(DataItemUtil.build(vo.getName())) : value;
	    sb.append(buildDiv(design, vo, value)).append("\n");
	}
	return sb.toString();
    }

    /**
     * 构建html形式的显示文字
     * 
     * @param vo
     * @param txt
     * @return
     */
    private static String buildDiv(DesignVO design, OccupyVO vo, DataVO dataVO) {
	// 空检查
	DataItemVO[] items = dataVO.getData();
	StringBuilder div = new StringBuilder();
	OccupyVO occupy;
	if (items != null) {
	    occupy = vo.clone();
	    for (int i = 0; i < items.length; i++) {
		occupy.setPositionY(vo.getPositionY() + i * (vo.getIntervalLen() + occupy.getHeight()));
		div.append(items[i].getItem(design.build(), occupy)).append("\n");
	    }
	}
	return div.toString();
    }

    public static void preview(String html) {
	try {
	    // String url = "http://www.baidu.com";
	    String name = System.currentTimeMillis() + ".html";
	    File file = new File(TPDConsts.DEAULT_DIR + File.separator + "temp" + File.separator + name);
	    if (!file.getParentFile().exists()) {
		file.getParentFile().mkdirs();
	    }
	    file.createNewFile();
	    Files.write(Paths.get(file.getAbsolutePath()), html.getBytes());
	    String path = file.getAbsolutePath().replace("\\", "/");
	    java.net.URI uri = new java.net.URI("file:/" + path);
	    // 获取当前系统桌面扩展
	    java.awt.Desktop dp = java.awt.Desktop.getDesktop();
	    // 判断系统桌面是否支持要执行的功能
	    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
		// File file = new File("D:\\aa.txt");
		// dp.edit(file);// 编辑文件
		dp.browse(uri);// 获取系统默认浏览器打开链接
		// dp.open(file);// 用默认方式打开文件
		// dp.print(file);// 用打印机打印文件
	    }
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
