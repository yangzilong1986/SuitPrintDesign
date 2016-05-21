package com.lc.design.unit;

import java.util.ArrayList;
import java.util.List;

import com.lc.design.vo.DataItemVO;
import com.lc.design.vo.imp.DefaultDataItemImpVO;

public class DataItemUtil {
    public static DataItemVO[] build(String... datas) {
	if (datas == null || datas.length == 0) {
	    return null;
	}
	List<DataItemVO> list = new ArrayList<DataItemVO>();
	for (String data : datas) {
	    list.add(new DefaultDataItemImpVO(data));
	}
	return list.toArray(new DataItemVO[list.size()]);
    }
}
