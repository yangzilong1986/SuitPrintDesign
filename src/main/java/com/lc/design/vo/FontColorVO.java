package com.lc.design.vo;

public class FontColorVO {
	private FontVO font;
	private ColorVO color;

	public FontVO getFont() {
		return font;
	}

	public void setFont(FontVO font) {
		this.font = font;
	}

	public ColorVO getColor() {
		return color;
	}

	public void setColor(ColorVO color) {
		this.color = color;
	}

	public FontColorVO clone() {
		FontVO fvo = new FontVO();
		fvo.setName(this.getFont().getName());
		fvo.setStyle(this.getFont().getStyle());
		fvo.setSize(this.getFont().getSize());
		ColorVO cvo = new ColorVO();
		cvo.setRed(this.getColor().getRed());
		cvo.setGreen(this.getColor().getGreen());
		cvo.setBlue(this.getColor().getBlue());
		FontColorVO vo = new FontColorVO();
		vo.setColor(cvo);
		vo.setFont(fvo);
		return vo;
	}

}
