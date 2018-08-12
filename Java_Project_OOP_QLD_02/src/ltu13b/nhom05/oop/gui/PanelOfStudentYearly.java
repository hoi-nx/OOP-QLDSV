package ltu13b.nhom05.oop.gui;

import javax.swing.*;

/**
 * Created by Heart Of Dead on 5/23/2017.
 */
public class PanelOfStudentYearly extends BasePanel {
    public PanelOfStudentYearly(int sizeWidth, int sizeHeight) {
        super(sizeWidth, sizeHeight);
        setLayout(null);
        JLabel jLabel=new JLabel("Panel sinh viên Niên chế");
        jLabel.setBounds(100,100,200,50);
        add(jLabel);
    }
}
