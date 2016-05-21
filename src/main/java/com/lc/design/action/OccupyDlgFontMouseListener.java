package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.lc.design.component.JFontChooser;
import com.lc.design.component.LCFont;
import com.lc.design.component.OccupyFont;
import com.lc.design.panel.OccupyDialog;
import com.lc.design.unit.FontUtil;

public class OccupyDlgFontMouseListener extends MouseAdapter {
    private OccupyDialog occupyDialog;
    private OccupyFont btnObj;

    public OccupyDlgFontMouseListener(OccupyDialog dialog, OccupyFont btnObj) {
	this.occupyDialog = dialog;
	this.btnObj = btnObj;
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
	try {
	    occupyDialog.setVisible(false);
	    JFontChooser one = new JFontChooser();
	    LCFont lhf = one.showDialog(occupyDialog, FontUtil.convert(btnObj.getData()));
	    if (lhf != null) {
		System.out.println(lhf.getFont());
		btnObj.refresh(lhf);
	    }
	}
	finally {
	    occupyDialog.setVisible(true);
	}

    }
}
