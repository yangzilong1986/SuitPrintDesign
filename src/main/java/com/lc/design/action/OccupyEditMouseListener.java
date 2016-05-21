package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lc.design.panel.DesignContainer;
import com.lc.design.panel.OccupyDialog;
import com.lc.design.unit.LogUtil;
import com.lc.design.vo.OccupyVO;

public class OccupyEditMouseListener extends MouseAdapter {

	private DesignContainer designContainer;
	private OccupyDialog dialog;

	public OccupyEditMouseListener(DesignContainer container) {
		designContainer = container;
		dialog = new OccupyDialog(designContainer);
	}

	public void mouseClicked(MouseEvent e) {
		OccupyVO vo = designContainer.getNowOccupyVO();
		if (vo != null) {
			dialog.show(vo);
		}
		else {
			LogUtil.disError(designContainer, "请选中需要修改的的占位符！");
		}
		designContainer.requestFocus();
	}

}