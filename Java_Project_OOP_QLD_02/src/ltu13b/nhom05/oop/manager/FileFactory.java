package ltu13b.nhom05.oop.manager;

import ltu13b.nhom05.oop.object.QuanLy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heart Of Dead on 5/4/2017.
 */
public class FileFactory<T>{
    public void savaData(List<T>list,String path){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<T>readData(String path){
        List<T>list=new ArrayList<T>();
        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            Object data=ois.readObject();
            list=(ArrayList<T>) data;
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}
