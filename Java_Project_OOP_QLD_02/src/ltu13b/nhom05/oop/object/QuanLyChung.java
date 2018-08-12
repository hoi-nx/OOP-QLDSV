package ltu13b.nhom05.oop.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Heart Of Dead on 5/22/2017.
 */
public class QuanLyChung<T>{
    private List<T> lists;
    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public QuanLyChung(){
        lists=new ArrayList<T>();


    }
    public boolean addObject(T t){
        for(T list:lists){
            if(list.equals(t)){
            return false;
            }
        }
        return lists.add(t);

    }


    public T getObject(int index){
        return lists.get(index);
    }
    public boolean removeObject(T t) {
        for (T list : lists) {
            if (list.equals(t)) {
                return lists.remove(t);
            }
        }
        return false;
    }

    public boolean updateObject(T t) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).equals(t)) {
                lists.set(i, t);
                return true;
            }
        }
        return false;
    }

    public void saveObject(List<T>list,String path){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<T>readObject(String path){
        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            Object data=ois.readObject();
            lists=(ArrayList<T>) data;
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public void sortObject(Object object){
        Comparator<T> tComparator=new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {

                o1= (T) object;
                o2= (T) object;


                return 0;
            }
        };
    }

}
