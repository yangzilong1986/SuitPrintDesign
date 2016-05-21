package com.lc.design.vo;

public class DataVO {
    private DataItemVO[] datas;

    public DataVO(DataItemVO... inDatas) {
	datas = inDatas;
    }

    public DataItemVO[] getData() {
	return datas;
    }
}
