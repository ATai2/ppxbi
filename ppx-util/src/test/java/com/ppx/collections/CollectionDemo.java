package com.ppx.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo {
    public static void main2(String[] args) {
        List<User> list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user=new User(i,"User"+i);
            list.add(user);
        }
        Iterator<User> it=list.iterator();
        while(it.hasNext()){
            User user=it.next();
            if("User6".equals(user.getName()))
                list.remove(user);
        }
    }
}
