package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.BooleanMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.CharacterMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.CollectionMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.JsonMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.MapMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.NumberMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.ObjectArrayMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.PojoMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.PrimitiveArrayMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.StringMapper;

public class JsonMapperFactory extends AbstractJsonMapperFactory {
    
    private Map<Class<?>, JsonMapper> mappers;
    
    private final Class<?> collectionClass = Collection.class;
    private final Class<?> mapClass = Map.class;
    
    private JsonMapper primitiveArrayMapper;
    private JsonMapper objectArrayMapper;
    
    
    public JsonMapperFactory() {
        mappers = new HashMap<Class<?>, JsonMapper>();
        
        NumberMapper numberMapper = new NumberMapper();
        BooleanMapper booleanMapper = new BooleanMapper();
        CharacterMapper characterMapper = new CharacterMapper();
        StringMapper stringMapper = new StringMapper();
        CollectionMapper collectionMapper = new CollectionMapper(this);
        MapMapper mapMapper = new MapMapper(this);
        
        mappers.put(Byte.class, numberMapper);
        mappers.put(byte.class, numberMapper);
        mappers.put(Short.class, numberMapper);
        mappers.put(short.class, numberMapper);
        mappers.put(Integer.class, numberMapper);
        mappers.put(int.class, numberMapper);
        mappers.put(Long.class, numberMapper);
        mappers.put(long.class, numberMapper);
        mappers.put(Float.class, numberMapper);
        mappers.put(float.class, numberMapper);
        mappers.put(Double.class, numberMapper);
        mappers.put(double.class, numberMapper);
        mappers.put(Boolean.class, booleanMapper);
        mappers.put(Character.class, characterMapper);
        mappers.put(char.class, characterMapper);
        mappers.put(String.class, stringMapper);
        
        mappers.put(collectionClass, collectionMapper);
        mappers.put(mapClass, mapMapper);
        
        this.primitiveArrayMapper = new PrimitiveArrayMapper(this);
        this.objectArrayMapper = new ObjectArrayMapper(this);
    }
    
    @Override
    public void addMapper(Class<?> clazz, JsonMapper mapper) {
        mappers.put(clazz, mapper);
    }
    
    @Override
    public JsonMapper createMapper(Class<?> clazz) {
        if (mapClass.isAssignableFrom(clazz)) {
            return mappers.get(mapClass);
        }
        if (collectionClass.isAssignableFrom(clazz)) {
            return mappers.get(collectionClass);
        }
        
        if (clazz.isArray()) {
            if (clazz.getComponentType().isPrimitive()) {
                return primitiveArrayMapper;
            } else {
                return objectArrayMapper;
            }
        }
        
        JsonMapper mapper = mappers.get(clazz);
        if (mapper == null) {
            mapper = createPojoMapper(clazz);
            mappers.put(clazz, mapper);
        }
        return mapper;
    }
    
    @Override
    protected JsonMapper createPojoMapper(Class<?> clazz) {
        return new PojoMapper(clazz, this);
    }
    
}
