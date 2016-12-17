package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import java.lang.reflect.Array;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;

public class ObjectArrayMapper implements JsonMapper{

    private AbstractJsonMapperFactory mapperFactory;

    public ObjectArrayMapper(AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;

    }
    
    @Override
    public void write(Object array, JsonWriter writer) {
        if (array == null) {
            writer.writeNull();
            return;
        }
        writer.writeArrayBegin();
        Object obj;
        for (int i = 0; i < Array.getLength(array) - 1; i++) {
            obj = Array.get(array, i);
            if (obj == null) {
                writer.writeNull();
                writer.writeSeparator();
                continue;
            }
            JsonMapper mapper = mapperFactory.createMapper(obj.getClass());
            mapper.write(obj, writer);
            writer.writeSeparator();
        }
        obj = Array.get(array, Array.getLength(array) - 1);
        if (obj == null) {
            writer.writeNull();
        } else {
            JsonMapper mapper = mapperFactory.createMapper(obj.getClass());
            mapper.write(obj, writer);
        }
        
        writer.writeArrayEnd();

    }
}
