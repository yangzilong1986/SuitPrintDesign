package com.lc.design.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.lc.design.panel.OccupyDialog;

/**
 * 控件 下载的代码，代码写的不好，但是能用，先凑合，以后有时间再修改吧。
 * 
 * @author liubq
 */
public class JFontChooser extends JPanel {

    // 定义变量
    private String current_fontName = "宋体";// 当前的字体名称,默认宋体.
    private int current_fontStyle = Font.PLAIN;// 当前的字样,默认常规.
    private int current_fontSize = 9;// 当前字体大小,默认9号.
    private Color current_color = Color.BLACK;// 当前字色,默认黑色.
    @SuppressWarnings("unused")
    private Component parent;// 弹出dialog的父窗体.
    private JDialog dialog;// 用于显示模态的窗体
    private LCFont myfont;// 带有Color的字体.
    private JTextField txtFont;// 显示选择字体的TEXT
    private JTextField txtStyle;// 显示选择字型的TEXT
    private JTextField txtSize;// 显示选择字大小的TEXT
    private JList<String> lstFont;// 选择字体的列表.
    private JList<String> lstStyle;// 选择字型的列表.
    private JList<String> lstSize;// 选择字体大小的列表.
    private JComboBox<String> cbColor;// 选择Color的下拉框.
    private JButton ok, cancel;// "确定","取消"按钮.
    private JScrollPane spFont;
    private JScrollPane spSize;
    private JLabel lblShow;// 显示效果的label.

    private Map<String, Integer> sizeMap;// 字号映射表.
    private Map<String, Color> colorMap;// 字着色映射表.
    // 定义变量_结束________________

    public JFontChooser() {
	init();
    }

    private void init() {
	// 实例化变量

	lblShow = new JLabel("字体选择器.");
	txtFont = new JTextField("宋体");
	txtStyle = new JTextField("常规");
	txtSize = new JTextField();
	// 取得当前环境可用字体.
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] fontNames = ge.getAvailableFontFamilyNames();
	lstFont = new JList<String>(fontNames);
	// 字形.
	lstStyle = new JList<String>(new String[] {
		"常规", "斜休", "粗休", "粗斜休"
	});
	// 字号.
	String[] sizeStr = new String[] {
		"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72", "初号",
		"小初", "一号", "小一", "二号", "小二", "三号", "小三", "四号", "小四", "五号", "小五", "六号", "小六", "七号", "八号"
	};
	int sizeVal[] = {
		8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72, 42, 36, 26, 24, 22, 18, 16, 15, 14, 12,
		11, 9, 8, 7, 6, 5
	};
	sizeMap = new HashMap<String, Integer>();
	for (int i = 0; i < sizeStr.length; ++i) {
	    sizeMap.put(sizeStr[i], sizeVal[i]);
	}
	lstSize = new JList<String>(sizeStr);
	spFont = new JScrollPane(lstFont);
	spSize = new JScrollPane(lstSize);

	String[] colorStr = new String[] {
		"黑色", "蓝色", "青色", "深灰", "灰色", "绿色", "浅灰", "洋红", "桔黄", "粉红", "红色", "白色", "黄色"
	};
	Color[] colorVal = new Color[] {
		Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
		Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
	};
	colorMap = new HashMap<String, Color>();
	for (int i = 0; i < colorStr.length; i++) {
	    colorMap.put(colorStr[i], colorVal[i]);
	}
	cbColor = new JComboBox<String>(colorStr);
	ok = new JButton("确定");
	cancel = new JButton("取消");
	// 实例化变量_结束

	// 布局控件
	this.setLayout(null);// 不用布局管理器.
	JLabel lblFont = new JLabel("字体:");
	add(lblFont);
	lblFont.setBounds(12, 10, 30, 20);
	txtFont.setEditable(false);
	add(txtFont);
	txtFont.setBounds(10, 30, 155, 20);
	lstFont.setSelectedValue("宋体", true);
	add(spFont);
	spFont.setBounds(10, 50, 155, 100);

	JLabel lblStyle = new JLabel("字型:");
	add(lblStyle);
	lblStyle.setBounds(175, 10, 30, 20);
	txtStyle.setEditable(false);
	add(txtStyle);
	txtStyle.setBounds(175, 30, 130, 20);
	lstStyle.setBorder(javax.swing.BorderFactory.createLineBorder(Color.gray));
	add(lstStyle);
	lstStyle.setBounds(175, 50, 130, 100);
	lstStyle.setSelectedValue("常规", true);

	JLabel lblSize = new JLabel("大小:");
	add(lblSize);
	lblSize.setBounds(320, 10, 30, 20);
	txtSize.setEditable(false);
	add(txtSize);
	txtSize.setBounds(320, 30, 60, 20);
	add(spSize);
	spSize.setBounds(320, 50, 60, 100);

	JLabel lblColor = new JLabel("颜色:");
	add(lblColor);
	lblColor.setBounds(13, 170, 30, 20);
	add(cbColor);
	cbColor.setBounds(10, 195, 130, 22);
	cbColor.setMaximumRowCount(5);
	// 显示框.
	JPanel showPan = new JPanel();
	showPan.setBorder(javax.swing.BorderFactory.createTitledBorder("示例"));
	add(showPan);
	showPan.setBounds(150, 170, 230, 100);
	showPan.setLayout(new BorderLayout());
	lblShow.setBackground(Color.white);
	showPan.add(lblShow);
	add(ok);
	ok.setBounds(10, 240, 60, 20);
	add(cancel);
	cancel.setBounds(80, 240, 60, 20);
	// 布局控件_结束

	// 事件
	lstFont.addListSelectionListener(new ListSelectionListener() {

	    public void valueChanged(ListSelectionEvent e) {
		current_fontName = (String) lstFont.getSelectedValue();
		txtFont.setText(current_fontName);
		lblShow.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
	    }
	});

	lstStyle.addListSelectionListener(new ListSelectionListener() {

	    public void valueChanged(ListSelectionEvent e) {
		String value = (String) ((JList<?>) e.getSource()).getSelectedValue();
		if (value.equals("常规")) {
		    current_fontStyle = Font.PLAIN;
		}
		if (value.equals("斜休")) {
		    current_fontStyle = Font.ITALIC;
		}
		if (value.equals("粗休")) {
		    current_fontStyle = Font.BOLD;
		}
		if (value.equals("粗斜休")) {
		    current_fontStyle = Font.BOLD | Font.ITALIC;
		}
		txtStyle.setText(value);
		lblShow.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
	    }
	});

	lstSize.addListSelectionListener(new ListSelectionListener() {

	    public void valueChanged(ListSelectionEvent e) {
		current_fontSize = (Integer) sizeMap.get(lstSize.getSelectedValue());
		txtSize.setText(String.valueOf(current_fontSize));
		lblShow.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
	    }
	});

	cbColor.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		current_color = (Color) colorMap.get(cbColor.getSelectedItem());
		lblShow.setForeground(current_color);
	    }
	});

	ok.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		myfont = new LCFont();
		myfont.setFont(new Font(current_fontName, current_fontStyle, current_fontSize));
		myfont.setColor(current_color);
		dialog.dispose();
		dialog = null;
	    }
	});

	cancel.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		myfont = null;
		dialog.dispose();
		dialog = null;
	    }
	});
	// 事件_结束

    }

    public LCFont showDialog(OccupyDialog parent, LCFont font) {
	dialog = new JDialog(parent.getDesignContainer().getFrame(), "字体样式选择器", true);
	dialog.add(this);
	dialog.setResizable(false);
	if (parent != null) {
	    dialog.setLocation(parent.getX(), parent.getY());
	}

	dialog.setSize(400, 330);
	dialog.addWindowListener(new WindowAdapter() {

	    @Override
	    public void windowClosing(WindowEvent e) {
		myfont = null;
		dialog.removeAll();
		dialog.dispose();
		dialog = null;
	    }
	});
	if (font != null) {
	    // 字体
	    txtFont.setText(font.getFont().getName());
	    lstFont.setSelectedValue(font.getFont().getName(), true);
	    // 样式
	    if (Font.PLAIN == font.getFont().getStyle()) {
		txtStyle.setText("常规");
		lstStyle.setSelectedValue("常规", true);
	    }
	    else if (Font.ITALIC == font.getFont().getStyle()) {
		txtStyle.setText("斜休");
		lstStyle.setSelectedValue("斜休", true);
	    }
	    else if (Font.BOLD == font.getFont().getStyle()) {
		txtStyle.setText("粗休");
		lstStyle.setSelectedValue("粗休", true);
	    }
	    else {
		txtStyle.setText("粗斜休");
		lstStyle.setSelectedValue("粗斜休", true);
	    }
	    // 字体大小
	    for (Map.Entry<String, Integer> entry : sizeMap.entrySet()) {
		if (entry.getValue().equals(font.getFont().getSize())) {
		    txtSize.setText(entry.getKey());
		    lstSize.setSelectedValue(entry.getKey(), true);
		    break;
		}
	    }
	    // 颜色
	    for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
		if (entry.getValue().equals(font.getColor())) {
		    cbColor.setSelectedItem(entry.getKey());
		    break;
		}
	    }
	}
	else {
	    // 字体
	    txtFont.setText("宋体");
	    lstFont.setSelectedValue("宋体", true);
	    txtStyle.setText("常规");
	    lstStyle.setSelectedValue("常规", true);
	    txtSize.setText("16");
	    lstSize.setSelectedValue("16", true);
	}
	dialog.setVisible(true);
	return myfont;
    }

    public static void main(String[] args) {

	JFontChooser one = new JFontChooser();
	LCFont lhf = one.showDialog(null, null);
	if (lhf != null) {
	    System.out.println(lhf.getColor());
	    System.out.println(lhf.getFont());
	}
    }
}
