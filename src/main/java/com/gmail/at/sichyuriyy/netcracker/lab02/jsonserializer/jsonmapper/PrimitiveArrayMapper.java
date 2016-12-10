package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import java.lang.reflect.Array;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;

public class PrimitiveArrayMapper implements JsonMapper {
    
    private AbstractJsonMapperFactory mapperFactory;

    public PrimitiveArrayMapper(AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
        
    }

    public void write(Array array, JsonWriter writer) {
        
    }
    
    @Override
    public void write(Object array, JsonWriter writer) {
        if (array == null) {
            writer.writeNull();
            return;
        }

        writer.writeArrayBegin();
        JsonMapper mapper;
        if (Array.getLength(array) > 0) {
            mapper = mapperFactory.createMapper(Array.get(array, 0).getClass());
            
            for (int i = 0; i < Array.getLength(array); i++) {
                Object obj = Array.get(array, i);
                mapper.write(obj, writer);
                writer.writeSeparator();
            }
        }
        
        writer.writeArrayEnd();

    }
}
