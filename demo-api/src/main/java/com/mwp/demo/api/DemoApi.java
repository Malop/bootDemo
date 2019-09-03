package com.mwp.demo.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class DemoApi {

    public static void main(String[] args){
        System.out.println("the result is === "+checkStr("[(qweq])"));
        List<String> list = new ArrayList();

        list.add("one");
        list.add("two");
        //list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        //使用jdk1.8的stream过滤指定字符串
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
            if("three".equals(a)){
                System.out.println("----remove3 item is:"+a);
                list.remove(a);
            }
        }
        for(String s : list){
            System.out.println(s);
        }
    }

    public static int checkStr(String s){

        int resultValue = 0; // 初始返回值
        LinkedList<Byte> ll = new LinkedList(); // 用于存放括号的栈
        byte[] bs = s.getBytes();
        // 遍历String
        for (byte b : bs) {
            // 如果是左括号，存入栈
            if (b == '(' || b == '[') {
                ll.add(b);
            } else if (b == ')') {
                // 如果是‘）’，取栈中最后的括号，判断是否匹配
                // 若不匹配，则返回1；
                if (ll.getLast() != '(') {
                    resultValue = 1;
                    break;
                }
            } else if (b == ']') {
                if (ll.getLast() != '[') {
                    resultValue = 1;
                    break;
                }
            }
        }
        return resultValue;
    }
}
