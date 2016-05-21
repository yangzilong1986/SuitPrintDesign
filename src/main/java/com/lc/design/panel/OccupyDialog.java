package com.lc.design.panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lc.design.action.OccupyDlgApplyMouseListener;
import com.lc.design.action.OccupyDlgFontMouseListener;
import com.lc.design.action.OccupyDlgTypeMouseListener;
import com.lc.design.component.OccupyFont;
import com.lc.design.constant.OutType;
import com.lc.design.vo.OccupyVO;

/**
 * 占用对话框
 * 
 * @author liubq
 */
public class OccupyDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private JTextField nameTxt = new JTextField();

    private JTextField widthTxt = new JTextField();

    private JTextField heightTxt = new JTextField();

    private OccupyFont fcBtn;

    private JButton okButton = new JButton("应用");

    private javax.swing.JComboBox<String> outTypeList = new JComboBox<String>(OutType.getListName());

    private JTextField intervalTxt = new JTextField();

    private DesignContainer designContainer;

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
     */
    public OccupyDialog() {
	init();
    }

    /**
     * 构造器
     * 
     * @param owner
     */
    public OccupyDialog(DesignContainer designContainer) {
	super(designContainer.getFrame());
	this.designContainer = designContainer;
	init();
    }

    /**
     * 构造器
     * 
     * @param owner
     */
    private void init() {
	this.setModal(true);

	this.setTitle("占位符编辑");
	// 实例化面板
	JPanel panel = new JPanel();
	panel.setLayout(null);
	JLabel nameLabel = new JLabel("名称:");
	nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	nameLabel.setBounds(20, 20, 40, 30);
	panel.add(nameLabel);
	nameTxt.setBounds(70, 20, 160, 30);
	panel.add(nameTxt);

	JLabel widthLabel = new JLabel("宽度:");
	widthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	widthLabel.setBounds(20, 60, 40, 30);
	panel.add(widthLabel);
	widthTxt.setBounds(70, 60, 50, 30);
	panel.add(widthTxt);

	JLabel heightLabel = new JLabel("高度:");
	heightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	heightLabel.setBounds(140, 60, 30, 30);
	panel.add(heightLabel);
	heightTxt.setBounds(180, 60, 50, 30);
	panel.add(heightTxt);

	JLabel styleLabel = new JLabel("字体:");
	styleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	styleLabel.setBounds(20, 100, 40, 30);
	panel.add(styleLabel);
	fcBtn = new OccupyFont("请选择>>>");
	fcBtn.setBounds(70, 100, 160, 30);
	fcBtn.addMouseListener(new OccupyDlgFontMouseListener(this, fcBtn));
	panel.add(fcBtn);

	JLabel typeLabel = new JLabel("类型:");
	typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	typeLabel.setBounds(20, 140, 40, 30);
	panel.add(typeLabel);
	outTypeList.setBounds(70, 140, 70, 30);
	outTypeList.addActionListener(new OccupyDlgTypeMouseListener(this));
	panel.add(outTypeList);

	JLabel intervalLabel = new JLabel("间距:");
	intervalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	intervalLabel.setBounds(150, 140, 30, 30);
	panel.add(intervalLabel);
	intervalTxt.setBounds(190, 140, 40, 30);
	panel.add(intervalTxt);

	okButton.setBounds(115, 190, 60, 30);
	okButton.addMouseListener(new OccupyDlgApplyMouseListener(this));
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
    private void initDisplayValue(OccupyVO vo) {
	if (vo == null) {
	    return;
	}
	this.nameTxt.setText(vo.getName());
	this.widthTxt.setText(String.valueOf(vo.getWidth()));
	this.heightTxt.setText(String.valueOf(vo.getHeight()));
	this.fcBtn.setData(vo.getFc());
	this.outTypeList.setSelectedItem(OutType.getByCode(vo.getOutType()).getName());
	if (vo.getIntervalLen() > 0) {
	    this.intervalTxt.setText(String.valueOf(vo.getIntervalLen()));
	}
    }

    /**
     * 取得数据
     * 
     * @return
     * @throws Exception
     */
    public OccupyVO getData() throws Exception {
	inVO.setName(nameTxt.getText());
	inVO.setWidth(Integer.valueOf(widthTxt.getText()));
	inVO.setHeight(Integer.valueOf(heightTxt.getText()));
	inVO.setFc(fcBtn.getData());
	OutType oType = OutType.getByName((String) this.outTypeList.getSelectedItem());
	inVO.setOutType(oType.getCode());
	if (OutType.LIST.equals(oType)) {
	    inVO.setIntervalLen(Integer.valueOf(this.intervalTxt.getText()));
	}
	else {
	    inVO.setIntervalLen(0);
	}
	return inVO;
    }

    /**
     * 检查画面数据
     * 
     * @throws Exception
     */
    public void checkData() throws Exception {
	// 名称检查
	String name = nameTxt.getText();
	if (name == null || name.length() == 0) {
	    throw new Exception("名称不能为空");
	}
	// 宽度检查
	String width = widthTxt.getText();
	if (width == null || width.length() == 0) {
	    throw new Exception("宽度不能为空");
	}
	int iW;
	try {
	    iW = Integer.valueOf(width);
	}
	catch (Exception ex) {
	    throw new Exception("宽度不是数字：" + width);
	}
	if (iW < 12 || iW > 1200) {
	    throw new Exception("宽度不合理：" + width);
	}
	// 高度检查
	String height = heightTxt.getText();
	if (height == null || height.length() == 0) {
	    throw new Exception("高度不能为空");
	}
	int iH;
	try {
	    iH = Integer.valueOf(height);
	}
	catch (Exception ex) {
	    throw new Exception("高度不是数字：" + height);
	}
	if (iH < 12 || iH > 1200) {
	    throw new Exception("高度不合理：" + height);
	}

	// 名称检查
	OutType oType = OutType.getByName((String) this.outTypeList.getSelectedItem());
	if (OutType.LIST.equals(oType)) {
	    String intervalLen = this.intervalTxt.getText();
	    if (intervalLen == null || height.length() == 0) {
		throw new Exception("间距不能为空");
	    }
	    int iIntervalLen;
	    try {
		iIntervalLen = Integer.valueOf(intervalLen);
	    }
	    catch (Exception ex) {
		throw new Exception("间距不是数字：" + height);
	    }
	    if (iIntervalLen < 2 || iIntervalLen > 50) {
		throw new Exception("间距不合理：" + height);
	    }
	}
    }

    /**
     * 选择类型实际处理
     * 
     * @throws Exception
     */
    public void refreshOutType(String type) throws Exception {
	if (OutType.LIST.getName().equals(type)) {
	    this.intervalTxt.setText("5");
	    this.intervalTxt.setEditable(true);
	}
	else {
	    this.intervalTxt.setText("");
	    this.intervalTxt.setEditable(false);
	}
    }

    /**
     * 修改画面
     * 
     * @throws Exception
     */
    public void refreshOccupy() throws Exception {
	OccupyVO vo = getData();
	this.designContainer.resetOccupy(vo);
    }

    // 插入的数据
    private OccupyVO inVO;

    /**
     * 显示
     * 
     * @param vo
     */
    public void show(OccupyVO vo) {
	this.inVO = vo;
	this.setSize(280, 280);
	this.setLocation(200, 200);
	this.setLocation(500, 300);
	this.setResizable(false);
	this.initDisplayValue(vo);
	this.setVisible(true);
    }

    public static void main(String[] args) {
	OccupyDialog dialog = new OccupyDialog();
	dialog.show(null);

    }

}
