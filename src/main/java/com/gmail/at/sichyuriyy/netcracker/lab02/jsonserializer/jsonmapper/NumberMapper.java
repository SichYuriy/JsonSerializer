package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;

public class NumberMapper implements JsonMapper {

    public void write(Number number, JsonWriter writer) {
        writer.writeNumber(number);
        
    }
    
    public void write(Object obj, JsonWriter writer) {
        if (obj == null) {
            writer.writeNull();
            return;
        }
        if (obj instanceof Number) {
            write((Number)obj, writer);
        } else {
            throw new IllegalArgumentException();
        }
        
    }
    
   

}
