package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import java.util.Collection;
import java.util.LinkedList;

public class Main {
    
    public static void main(String []args) {
        
        Collection<?> setExample = new LinkedList<Integer>();
        
        System.out.println(Collection.class.isAssignableFrom(setExample.getClass()));
        
        
    }

}
