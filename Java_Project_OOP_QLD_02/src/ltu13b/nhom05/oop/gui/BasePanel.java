package ltu13b.nhom05.oop.gui;

import ltu13b.nhom05.oop.interfaces.Base;
import ltu13b.nhom05.oop.interfaces.Constants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Heart Of Dead on 4/23/2017.
 */
public class BasePanel extends JPanel implements Constants, ActionListener,Base {
    protected JButton btnAdd, btnUpdate, btnDelete, btnReset, btnFind;
    protected DefaultTableModel tableModel;
    protected JPanel panelTitle, panelCenter;
    protected JLabel lblTitle;

    protected int sizeWidth;
    protected int sizeHeight;


    public BasePanel(int sizeWidth, int sizeHeight) {
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        initPanel();
        initControls();
        initEvent();
    }
    public JComboBox allJComboBox(JComboBox<String> cbb, int x, int y, int w, int h){
        cbb.setBounds(x,y,w,h);
        add(cbb);
        return cbb;
    }

    protected JLabel allJlable(JLabel lbl, String text, int x, int y, int h, Font font, Color color) {
        lbl.setText(text);
        FontMetrics fontMetrics = getFontMetrics(font);
        int wF = fontMetrics.stringWidth(text);
        lbl.setFont(font);
        lbl.setBounds(x, y, wF + 5, h);
        lbl.setForeground(color);
        add(lbl);
        return lbl;
    }

    protected JTextField allJtext(JTextField txt, int x, int y, int w, int h) {
        txt.setBounds(x, y, w, h);
        add(txt);
        return txt;
    }

    protected JButton allJButton(JButton btn, String string, int x, int y, int w, int h, Icon icon) {
        btn.setText(string);//set tên cho button
        btn.setActionCommand(string);//set id cho button để khi xử lý sự kiện mình sẽ gọi theo id
        btn.setBounds(x, y, w, h);//set tọa độ x,y,chiều dài của button chiều cao của button
        btn.setIcon(icon);//set icon cho button, trong trường hợp icon mình chuyền vào nó to thì nó sẽ che hết text vì thế
        //chỉ cần chọn cái icon nào có cả chữ là k cần text nữa
        add(btn);
        return btn;

    }

    protected JLabel createLabel(String text, int x, int y, int h, Font font, Color color) {
        JLabel lbl = new JLabel();
        lbl.setText(text);
        FontMetrics fontMetrics = getFontMetrics(font);
        int wF = fontMetrics.stringWidth(text);
        lbl.setFont(font);
        lbl.setBounds(x, y, wF + 5, h);
        lbl.setForeground(color);
        return lbl;
    }

    protected JTextField createTextField(int x, int y, int w, int h) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, w, h);
        return txt;
    }

    protected JComboBox createCombobox(int x, int y, int w, int h, Color color) {
        JComboBox box = new JComboBox();
        box.setBounds(x, y, w, h);
        box.setBackground(color);
        return box;
    }

    protected JRadioButton createRadioButton(String text, int x, int y, int w, int h, Color color) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, w, h);
        radioButton.setBackground(color);
        return radioButton;
    }

    protected JButton createButton(String string, int x, int y, int w, int h, Icon icon) {
        JButton btn = new JButton();
        btn.setText(string);//set tên cho button
        btn.setActionCommand(string);//set id cho button để khi xử lý sự kiện mình sẽ gọi theo id
        btn.setBounds(x, y, w, h);//set tọa độ x,y,chiều dài của button chiều cao của button
        btn.setIcon(icon);//set icon cho button, trong trường hợp icon mình chuyền vào nó to thì nó sẽ che hết text vì thế
        //chỉ cần chọn cái icon nào có cả chữ là k cần text nữa
        return btn;
    }

    protected void addEvents(){
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnUpdate.setEnabled(false);
        btnDelete.addActionListener(this);
        btnDelete.setEnabled(false);
        btnFind.addActionListener(this);
        btnReset.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void initPanel() {

    }

    @Override
    public void initControls() {

    }

    @Override
    public void initEvent() {

    }
}
