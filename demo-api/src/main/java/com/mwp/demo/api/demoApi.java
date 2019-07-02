package com.mwp.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class demoApi {

    public static void main(String[] args){
        List<String> list = new ArrayList();

        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        Stream<String> stream = list.stream();
        Stream<String> stringStream = stream.filter((String s)-> "three".equals(s));
        System.out.println(stringStream.toArray()[0]);
        //错误
        /*for(String a : list){
            if("three".equals(a)){
                System.out.println("----remove item is:"+a);
                list.remove(a);
            }
        }*/
        for(int i=0;i<list.size();i++){
            String a = list.get(i);
            if("two".equals(a)){
                System.out.println("----remove1 item is:"+a);
                list.remove(a);
            }
            if("four".equals(a)){
                System.out.println("----remove3 item is:"+a);
                list.remove(a);
            }
        }
        for(String s : list){
            System.out.println(s);
        }
    }
}
