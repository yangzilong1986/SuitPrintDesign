package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lc.design.panel.DesignContainer;
import com.lc.design.vo.OccupyVO;

public class OccupyBtnListener extends MouseAdapter {
	private DesignContainer main;

	public static int index = 0;

	public OccupyBtnListener(DesignContainer design) {
		main = design;
	}

	public void mouseClicked(MouseEvent e) {
		OccupyVO vo = new OccupyVO();
		String name = "name" + index++;
		vo.setName("#" + name + "#");
		vo.setWidth(80);
		vo.setHeight(18);
		OccupyVO nowVO = main.getNowOccupyVO();
		if (nowVO != null) {
			vo.setPositionX(nowVO.getPositionX() + nowVO.getWidth() + 10);
			vo.setPositionY(nowVO.getPositionY() + nowVO.getHeight() + 10);
		}
		main.addNewOccupy(vo);
		main.requestFocus();
	}
}
