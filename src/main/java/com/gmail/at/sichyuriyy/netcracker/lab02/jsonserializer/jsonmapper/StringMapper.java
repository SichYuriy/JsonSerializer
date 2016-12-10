package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;

public class StringMapper implements JsonMapper {

    public void write(String str, JsonWriter writer) {
        writer.writeString(str);
        
    }
    
    public void write(Object obj, JsonWriter writer) {
        if (obj == null) {
            writer.writeNull();
            return;
        } 
        if (obj instanceof String) {
            write((String)obj, writer);
        } else {
            throw new IllegalArgumentException();
        }
        
    }
    
    

}
