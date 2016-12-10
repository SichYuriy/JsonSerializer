package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;

public class StringMapper implements JsonMapper {

    public void write(String str, JsonWriter writer) {
        if (str == null) {
            writer.writeNull();
        } else {
            writer.writeString(str);
        }
        
    }
    
    public void write(Object obj, JsonWriter writer) {
        if (obj instanceof String) {
            write((String)obj, writer);
        } else {
            throw new IllegalArgumentException();
        }
        
    }
    
    

}
