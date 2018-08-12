package ltu13b.nhom05.oop.interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Heart Of Dead on 4/23/2017.
 */
public interface Constants {
    int W_FRAME_LOGIN=600;
    int H_FRAME_LOGIN=400;

    int W_FRAME_MANAGER=1200;
    int H_FRAME_MANAGER=700;


    Image BACKGROUND_LOIN=new ImageIcon(Constants.class.getResource("/res/Wallpaper-Patterns-Networks-Lines-Reflections-1440x2560.jpg")).getImage();

    String LBL_TITLE_LOGIN="Please enter your username and password";
    String LBL_USERNAME="Username";
    String LBL_PASS="Password";

    String ID_BUTTON_LOGIN="Login";
    String ID_BUTTON_LOGOUT="Exit";

    Icon ICON_LOGIN=new ImageIcon(Constants.class.getResource("/res/Untitled-1.png"));
    Icon ICON_LOGOUT=new ImageIcon(Constants.class.getResource("/res/18109690_1149665295179277_1464271228_n.png"));

    int HEIGHT_CONTROLS=25;

    String ID_BUTTON_ADD="Add";
    String ID_BUTTON_UPDATE="Update";
    String ID_BUTTON_DELETE="Delete";
    String ID_BUTTON_FIND="Find";
    String ID_BUTTON_RESET="Reset";
    String ID_BUTTON_XEM_DIEM="Xem Diem";
    String ID_BUTTON_BACK="Back";
    Icon ICON_ADD = new ImageIcon(Constants.class.getResource("/res/icon_add.png"));
    Icon ICON_UPDATE = new ImageIcon(Constants.class.getResource("/res/icon_update.png"));
    Icon ICON_DELETE = new ImageIcon(Constants.class.getResource("/res/icon_delete.png"));
    Icon ICON_FIND = new ImageIcon(Constants.class.getResource("/res/icon_find.png"));
    Icon ICON_RESET = new ImageIcon(Constants.class.getResource("/res/icon_reset.png"));


    Icon ICON_KHAC=new ImageIcon(Constants.class.getResource("/res/Add-icon.png"));
    Icon ICON_KHAC1= new ImageIcon(Constants.class.getResource("/res/Refresh.png"));
    Icon ICON_KHAC2 = new ImageIcon(Constants.class.getResource("/res/delete-xxl.png"));
    Icon ICON_KHAC3= new ImageIcon(Constants.class.getResource("/res/eLsS8.png"));
    Icon ICON_KHAC4 = new ImageIcon(Constants.class.getResource("/res/icon-search.png"));
    ImageIcon IMG_QUESTION=new ImageIcon(Constants.class.getResource("/res/question.png"));
    ImageIcon IMG_EXIT_JMENU=new ImageIcon(Constants.class.getResource("/res/button-cancel-icon.png"));

    Image IMG_TITLE = new ImageIcon(Constants.class.getResource("/res/CSS.png")).getImage();

}
