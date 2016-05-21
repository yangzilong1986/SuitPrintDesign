package com.lc.design.vo.imp;

import java.awt.Font;

import com.lc.design.vo.DataItemVO;
import com.lc.design.vo.FontColorVO;
import com.lc.design.vo.OccupyVO;
import com.lc.design.vo.PrintContext;

public class DefaultDataItemImpVO implements DataItemVO {

    private String data;

    public DefaultDataItemImpVO(String inData) {
	this.data = inData;
    }

    @Override
    public String getItem(PrintContext cont, OccupyVO vo) {
	StringBuilder div = new StringBuilder();
	// position:fixed;left:425px;top:46px;width:400px;height:207px;
	div.append("<div style=\"position:fixed;background-color:red;");
	// 需要平移x(8) y(8)大致位置才能相同，不知道为什么，我用Doro PDF Writer模拟打印测试的。
	div.append("left:").append(vo.getPositionX() + cont.getConfig().getFillX()).append("px").append(";");
	// int newY = vo.getPositionY() + i * (vo.getIntervalLen() +
	// vo.getHeight());
	div.append("top:").append(vo.getPositionY() + cont.getConfig().getFillY()).append("px").append(";");
	div.append("width:").append(vo.getWidth()).append("px").append(";");
	div.append("height:").append(vo.getHeight()).append("px").append(";");
	div.append("\">");
	if (vo.getFc() != null) {
	    FontColorVO f = vo.getFc();
	    div.append("<span style=\"vertical-align:super;");
	    div.append("font-family:").append(f.getFont().getName()).append(";");
	    int size = f.getFont().getSize();
	    int pxSize = (size * 4 / 4);
	    div.append("font-size:").append(pxSize).append("px;");
	    // 加粗
	    if (Font.BOLD == f.getFont().getStyle()) {
		div.append("font-weight:900;");
	    }
	    // 加斜
	    else if (Font.ITALIC == f.getFont().getStyle()) {
		div.append("font-style:italic;");
	    }
	    // 粗斜体
	    else if ((Font.BOLD | Font.ITALIC) == f.getFont().getStyle()) {
		div.append("font-weight:100;");
		div.append("font-style:italic;");
	    }

	    int r = f.getColor().getRed();
	    int g = f.getColor().getGreen();
	    int b = f.getColor().getBlue();
	    String rgb = "rgb(" + r + "," + g + "," + b + ")";
	    div.append("color:").append(rgb).append(";");
	    div.append("\">");
	    div.append(data);
	    div.append("</span>");
	}
	else {
	    div.append(data);
	}

	div.append("</div>");
	return div.toString();
    }

}
