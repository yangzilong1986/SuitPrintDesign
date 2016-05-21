package com.lc.design.action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import com.lc.design.constant.OutType;
import com.lc.design.panel.DesignContainer;
import com.lc.design.unit.DataItemUtil;
import com.lc.design.unit.HtmlUtil;
import com.lc.design.unit.JsonUtils;
import com.lc.design.unit.LogUtil;
import com.lc.design.vo.DataVO;
import com.lc.design.vo.DesignVO;
import com.lc.design.vo.OccupyVO;

public class PreviewBtnListener extends MouseAdapter {
    private DesignContainer container;

    public PreviewBtnListener(DesignContainer container) {
	this.container = container;
    }

    public void mouseClicked(MouseEvent e) {
	DesignVO vo = container.getDesignVO();
	try {
	    Map<String, DataVO> dataMap = new HashMap<String, DataVO>();
	    for (OccupyVO oVO : vo.getDatas()) {
		if (OutType.LIST.getCode().equals(oVO.getOutType())) {
		    dataMap.put(oVO.getName(),
			    new DataVO(DataItemUtil.build(oVO.getName(), oVO.getName(), oVO.getName(), oVO.getName())));
		}
		else {
		    dataMap.put(oVO.getName(), new DataVO(DataItemUtil.build(oVO.getName())));
		}
	    }
	    String html = HtmlUtil.buildHtml(JsonUtils.convertToString(vo), dataMap);
	    HtmlUtil.preview(html);
	}
	catch (Exception e1) {
	    LogUtil.disError(container, e1);
	}
	container.requestFocus();
    }
}
