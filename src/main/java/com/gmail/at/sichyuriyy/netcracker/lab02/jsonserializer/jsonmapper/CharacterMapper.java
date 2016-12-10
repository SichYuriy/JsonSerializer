package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;

public class CharacterMapper implements JsonMapper {

    public void write(Character obj, JsonWriter writer) {
        writer.writeString(obj.toString());    
    }
    
    @Override
    public void write(Object obj, JsonWriter writer) {
        if (obj == null) {
            writer.writeNull();
            return;
        }
        if (obj instanceof Character) {
            write((Character)obj, writer);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
