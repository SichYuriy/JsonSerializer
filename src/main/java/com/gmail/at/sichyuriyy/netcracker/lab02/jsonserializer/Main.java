package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Main {
    
    public static void main(String []args) {
        JsonSerializer serializer = new JsonSerializer();
        serializer.setIndent(true);
        
        LinkedList<Object> input = new LinkedList<Object>();
        input.add(1);
        input.add("str");
        input.add(null);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(777);
        arrayList.add(123);
        arrayList.add("str2");
        input.add(arrayList);
        input.add(false);
       
        String actual = serializer.serialize(input);
        System.out.println(actual);
        
        
    }

}
