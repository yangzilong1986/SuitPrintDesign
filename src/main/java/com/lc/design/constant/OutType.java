package com.lc.design.constant;

import java.util.ArrayList;
import java.util.List;

public enum OutType {

    ONE(1, "单个"), LIST(2, "循环");

    OutType(Integer code, String name) {
	this.code = code;
	this.name = name;
    }

    private Integer code;
    private String name;

    public Integer getCode() {
	return code;
    }

    public String getName() {
	return name;
    }

    @Override
    public String toString() {
	return name;
    }

    public static OutType getByCode(Integer code) {
	for (OutType type : OutType.values()) {
	    if (type.getCode().equals(code)) {
		return type;
	    }
	}
	return null;
    }

    public static OutType getByName(String name) {
	for (OutType type : OutType.values()) {
	    if (type.getName().equals(name)) {
		return type;
	    }
	}
	return null;
    }

    public static String[] getListName() {
	List<String> list = new ArrayList<String>();
	for (OutType value : OutType.values()) {
	    list.add(value.getName());
	}
	return list.toArray(new String[list.size()]);
    }

    public boolean equals(OutType obj) {
	if (obj == null) {
	    return false;
	}
	if (obj == this) {
	    return true;
	}
	if (obj.getCode().equals(this.getCode())) {
	    return true;
	}
	return false;
    }
}
