package com.lc.design.action;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import com.lc.design.panel.OccupyDialog;
import com.lc.design.unit.LogUtil;

public class OccupyDlgTypeMouseListener implements java.awt.event.ActionListener {
    private OccupyDialog occupyDialog;

    public OccupyDlgTypeMouseListener(OccupyDialog dialog) {
	this.occupyDialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JComboBox<?> outType = (JComboBox<?>) e.getSource();
	String selType = (String) outType.getSelectedItem();
	try {
	    occupyDialog.refreshOutType(selType);
	}
	catch (Exception e1) {
	    LogUtil.disError(occupyDialog, e1);
	}
    }

}
