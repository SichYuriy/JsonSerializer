package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import java.util.Collection;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;

public class CollectionMapper implements JsonMapper {
    
    private AbstractJsonMapperFactory mapperFactory;
    
    public CollectionMapper(AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
        
    }
    
    
    public void write(Collection<?> collection, JsonWriter writer) {
        writer.writeArrayBegin();
        for (Object obj : collection) {
            if (obj == null) {
                writer.writeNull();
                writer.writeSeparator();
                continue;
            }
            JsonMapper mapper = mapperFactory.createMapper(obj.getClass());
            mapper.write(obj, writer);
            writer.writeSeparator();
        }
        writer.writeArrayEnd();
    } 
    
    
    public void write(Object obj, JsonWriter writer) {
        if (obj == null) {
            writer.writeNull();
            return;
        }
        if (obj instanceof Collection<?>) {
            write((Collection<?>)obj, writer);
        } else {
            throw new IllegalArgumentException();
        }
        
    }

}
