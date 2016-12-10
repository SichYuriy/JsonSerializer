package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

public class Main {
    
    public static void main(String []args) {
        
        JsonSerializer serializer = new JsonSerializer();
        String jsonInt = serializer.serialize(2);
        System.out.println(jsonInt);
        
    }

}
