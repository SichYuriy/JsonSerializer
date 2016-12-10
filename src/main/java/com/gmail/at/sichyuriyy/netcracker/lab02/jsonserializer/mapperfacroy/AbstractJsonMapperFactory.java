package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.JsonMapper;

public abstract class AbstractJsonMapperFactory {
    
    public abstract void addMapper(Class<?> clazz, JsonMapper mapper);
    
    public abstract JsonMapper createMapper(Class<?> clazz);
    
    protected abstract JsonMapper createPojoMapper();

}
