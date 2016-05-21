package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lc.design.panel.ConfigDialog;
import com.lc.design.panel.DesignContainer;
import com.lc.design.unit.LogUtil;
import com.lc.design.vo.SysConfigVO;

public class ConfigBtnListener extends MouseAdapter {
	private DesignContainer container;
	private ConfigDialog dialog;

	public ConfigBtnListener(DesignContainer container) {
		this.container = container;
		dialog = new ConfigDialog(container);
	}

	public void mouseClicked(MouseEvent e) {
		SysConfigVO vo = container.getConfigVO();
		try {
			dialog.show(vo);
			SysConfigVO configVO = dialog.getData();
			if (configVO != null) {
				container.setConfigVO(configVO);
			}
		}
		catch (Exception e1) {
			LogUtil.disError(container, e1);
		}
		container.requestFocus();
	}
}
