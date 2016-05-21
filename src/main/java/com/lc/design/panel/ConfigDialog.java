package com.lc.design.panel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lc.design.action.ConfigDlgApplyMouseListener;
import com.lc.design.vo.SysConfigVO;

/**
 * 配置对话框
 * 
 * @author liubq
 */
public class ConfigDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField xTxt = new JTextField("8");

	private JTextField yTxt = new JTextField("8");

	private JButton okButton = new JButton("确定");

	private DesignContainer designContainer;

	// 是否按下确认按钮
	private boolean ok = false;

	/**
	 * 容器
	 * 
	 * @return
	 */
	public DesignContainer getDesignContainer() {
		return designContainer;
	}

	/**
	 * 构造器
	 * 
	 * @param owner
	 */
	public ConfigDialog(DesignContainer designContainer) {
		super(designContainer.getFrame());
		this.setModal(true);
		this.designContainer = designContainer;
		this.setTitle("系统配置");
		// 实例化面板
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel xLabel = new JLabel("横向补偿:");
		xLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		xLabel.setBounds(20, 20, 60, 30);
		panel.add(xLabel);
		xTxt.setBounds(90, 20, 120, 30);
		panel.add(xTxt);

		JLabel yLabel = new JLabel("纵向补偿:");
		yLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		yLabel.setBounds(20, 60, 60, 30);
		panel.add(yLabel);
		yTxt.setBounds(90, 60, 120, 30);
		panel.add(yTxt);

		okButton.setBounds(110, 100, 60, 30);
		okButton.addMouseListener(new ConfigDlgApplyMouseListener(this));
		panel.add(okButton);

		// 将面板添加到帧窗口
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 * 初始化显示
	 * 
	 * @param vo
	 */
	private void initDisplayValue(SysConfigVO vo) {
		this.xTxt.setText(String.valueOf(vo.getFillX()));
		this.yTxt.setText(String.valueOf(vo.getFillY()));
	}

	/**
	 * 取得数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public SysConfigVO getData() throws Exception {
		if (this.ok) {
			inVO.setFillX(Integer.valueOf(xTxt.getText()));
			inVO.setFillY(Integer.valueOf(yTxt.getText()));
			return inVO;
		}
		return null;
	}

	/**
	 * 检查画面数据
	 * 
	 * @throws Exception
	 */
	public void checkData() throws Exception {
		// 横向补充检查
		String x = xTxt.getText();
		if (x == null || x.length() == 0) {
			throw new Exception("横向补偿不能为空,建议无边框默认为8");
		}
		int ix;
		try {
			ix = Integer.valueOf(x);
		}
		catch (Exception ex) {
			throw new Exception("横向补偿数字：" + x);
		}
		if (ix < 0 || ix > 1000) {
			throw new Exception("横向补偿不合理：" + x);
		}
		// 横向补充检查
		String y = xTxt.getText();
		if (y == null || y.length() == 0) {
			throw new Exception("纵向补偿不能为空,建议无边框默认为8");
		}
		int iy;
		try {
			iy = Integer.valueOf(y);
		}
		catch (Exception ex) {
			throw new Exception("纵向补偿数字：" + y);
		}
		if (iy < 0 || iy > 1000) {
			throw new Exception("纵向补偿不合理：" + y);
		}
	}

	// 插入的数据
	private SysConfigVO inVO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Dialog#setVisible(boolean)
	 */
	public void setVisible(boolean b) {
		// 每次显示时，先设定按钮未按下
		if (b) {
			this.ok = false;
		}
		super.setVisible(b);
	}

	/**
	 * 确认按钮按下
	 */
	public void setSuccess() {
		this.ok = true;
	}

	/**
	 * 显示
	 * 
	 * @param vo
	 */
	public void show(SysConfigVO vo) {
		this.inVO = vo;
		this.setSize(280, 180);
		this.setLocation(500, 300);
		this.setResizable(false);
		this.initDisplayValue(vo);
		this.setVisible(true);
	}

}