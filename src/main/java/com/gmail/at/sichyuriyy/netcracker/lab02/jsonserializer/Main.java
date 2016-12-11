package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.annotation.JsonIgnore;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.annotation.JsonProperty;

public class Main {
    
    public static void main(String []args) {
        JsonSerializer serializer = new JsonSerializer();
        serializer.setIndent(true);
        
        Example a = new ExampleChild();
        
        
        String actual = serializer.serialize(a);
        
       
        System.out.println(actual);
        
        
        
    }

}

class Example {
    
    public int namedVar = 2;
    
    @JsonIgnore
    public int b = 3;
    
    @JsonProperty
    private String var = "private";
}


class ExampleChild extends Example {
    
    public int var = 3;
    
    @JsonProperty(name="namedVar")
    private int a = 123;
}
