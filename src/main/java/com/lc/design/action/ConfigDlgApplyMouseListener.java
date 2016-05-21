package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lc.design.panel.ConfigDialog;
import com.lc.design.unit.LogUtil;

public class ConfigDlgApplyMouseListener extends MouseAdapter {
	private ConfigDialog dialog;

	public ConfigDlgApplyMouseListener(ConfigDialog dialog) {
		this.dialog = dialog;
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		try {
			dialog.setSuccess();
			dialog.setVisible(false);
		}
		catch (Exception ex) {
			LogUtil.disError(dialog, ex);
		}
	}
}