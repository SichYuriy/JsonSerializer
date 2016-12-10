package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy;

import java.util.HashMap;
import java.util.Map;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.JsonMapper;

public class JsonMapperFactory extends AbstractJsonMapperFactory {
    
    private Map<Class<?>, JsonMapper> mappers;
    
    
    public JsonMapperFactory() {
        mappers = new HashMap<Class<?>, JsonMapper>();
    }
    
    @Override
    public void addMapper(Class<?> clazz, JsonMapper mapper) {
        mappers.put(clazz, mapper);
    }
    
    @Override
    public JsonMapper createMapper(Class<?> clazz) {
        JsonMapper mapper = mappers.get(clazz);
        if (mapper == null) {
            mapper = createPojoMapper();
            mappers.put(clazz, mapper);
        }
        return mapper;
    }
    
    @Override
    protected JsonMapper createPojoMapper() {
        return null;//TODO:
    }
    
}
