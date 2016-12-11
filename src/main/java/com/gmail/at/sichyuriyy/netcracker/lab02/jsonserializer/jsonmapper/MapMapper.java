package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import java.util.Map;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;

public class MapMapper implements JsonMapper {

private AbstractJsonMapperFactory mapperFactory;
    
    public MapMapper(AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
        
    }
    
    
    public void write(Map<?, ?> map, JsonWriter writer) {
        writer.writeObjectBegin();
        for (Object key : map.keySet()) {
            if (key.toString().equals("")) {
                throw new IllegalStateException();
            }
            writer.writeString(key.toString());
            writer.writePropertySeparator();
            Object obj = map.get(key);
            
            if (obj == null) {
                writer.writeNull();
                writer.writeSeparator();
                continue;
            }
            JsonMapper mapper = mapperFactory.createMapper(obj.getClass());
            mapper.write(obj, writer);
            writer.writeSeparator();
        }
        writer.writeObjectEnd();
    } 
    
    @Override
    public void write(Object obj, JsonWriter writer) {
        if (obj == null) {
            writer.writeNull();
            return;
        }
        if (obj instanceof Map<?, ?>) {
            write((Map<?, ?>)obj, writer);
        } else {
            throw new IllegalArgumentException();
        }
        
    }

}
