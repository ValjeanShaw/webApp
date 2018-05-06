package UtilTest;


import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeanCopyTest {

    public static void main(String args[]){

        List<R> list1 = new ArrayList<R>();
        R r1 = new R();
        r1.setIndex(1);
        list1.add(r1);

        try{
            List<R> destList=deepCopy(list1);  //调用该方法

            R r2 = new R();
            r1.setIndex(2);
            list1.add(r2);

            System.out.println(destList);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }


}

class R implements Serializable{
    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}