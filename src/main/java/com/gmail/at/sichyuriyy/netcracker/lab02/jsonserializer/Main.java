package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static void main(String []args) {
        JsonSerializer serializer = new JsonSerializer();
        serializer.setIndent(true);
        
        Map<String, Object> input = new LinkedHashMap<String, Object>();
        input.put("firstName", "Yuriy");
        input.put("lastName", "Sych");
        input.put("age", 19);
        List<String> brothers = new LinkedList<String>();
        brothers.add("Sergiy");
        brothers.add("Oleg");
        input.put("brothers", brothers);
        
        String actual = serializer.serialize(input);
       
        System.out.println(actual);
        
        
    }

}
