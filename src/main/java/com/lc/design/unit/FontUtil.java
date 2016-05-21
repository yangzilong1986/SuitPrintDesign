package com.lc.design.unit;

import java.awt.Color;
import java.awt.Font;

import com.lc.design.component.LCFont;
import com.lc.design.vo.ColorVO;
import com.lc.design.vo.FontVO;
import com.lc.design.vo.FontColorVO;

public class FontUtil {
	public static FontVO convert(Font font) {
		if (font == null) {
			return null;
		}
		FontVO vo = new FontVO();
		vo.setName(font.getName());
		vo.setStyle(font.getStyle());
		vo.setSize(font.getSize());
		return vo;
	}

	public static Font convert(FontVO vo) {
		if (vo == null) {
			return null;
		}
		return new Font(vo.getName(), vo.getStyle(), vo.getSize());
	}

	public static ColorVO convert(Color color) {
		if (color == null) {
			return null;
		}
		ColorVO vo = new ColorVO();
		vo.setRed(color.getRed());
		vo.setGreen(color.getGreen());
		vo.setBlue(color.getBlue());
		return vo;
	}

	public static Color convert(ColorVO vo) {
		if (vo == null) {
			return null;
		}
		return new Color(vo.getRed(), vo.getGreen(), vo.getBlue());
	}

	public static FontColorVO convert(LCFont font) {
		if (font == null) {
			return null;
		}
		FontColorVO vo = new FontColorVO();
		vo.setFont(convert(font.getFont()));
		vo.setColor(convert(font.getColor()));
		return vo;
	}

	public static LCFont convert(FontColorVO vo) {
		if (vo == null) {
			return null;
		}
		LCFont font = new LCFont();
		font.setFont(convert(vo.getFont()));
		font.setColor(convert(vo.getColor()));
		return font;
	}
}
