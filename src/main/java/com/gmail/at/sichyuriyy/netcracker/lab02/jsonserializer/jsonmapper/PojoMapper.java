package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.annotation.JsonIgnore;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.annotation.JsonProperty;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.reflection.ReflectionUtils;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.reflection.ReflectionUtils.ModifierType;

public class PojoMapper implements JsonMapper {

    private AbstractJsonMapperFactory mapperFactory;

    private Map<String, Integer> fieldDepthMap;
    private Map<String, String> fieldNameJsonNameMap;

    public PojoMapper(Class<?> clazz, AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;

        int depth = 0;
        this.fieldDepthMap = new HashMap<String, Integer>();
        this.fieldNameJsonNameMap = new HashMap<String, String>();

        while (clazz != null) {
            Map<String, String> fields = getFieldsToSerialize(clazz);
            for (String jsonName : fields.keySet()) {
                if (!fieldNameJsonNameMap.containsValue(jsonName)) {
                    fieldNameJsonNameMap.put(fields.get(jsonName), jsonName);
                    fieldDepthMap.put(fields.get(jsonName), depth);
                }
            }
            clazz = clazz.getSuperclass();
            depth++;
        }
    }

    private Map<String, String> getFieldsToSerialize(Class<?> clazz) {
        Map<String, String> jsonNameFieldNameMap = new HashMap<String, String>();
        ReflectionUtils reflectionUtils = new ReflectionUtils();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (reflectionUtils.getModifierType(field) == ModifierType.PUBLIC) {
                String jsonName = field.getName();;
                if (field.isAnnotationPresent(JsonProperty.class)) {
                   jsonName = field.getAnnotation(JsonProperty.class).name();
                   if (jsonName.equals("")) {
                        jsonName = field.getName();
                   }
                }
                Set<String> jsonNameSet = jsonNameFieldNameMap.keySet();
                if (!jsonNameSet.contains(jsonName) 
                        && !field.isAnnotationPresent(JsonIgnore.class)) {
                    jsonNameFieldNameMap.put(jsonName, field.getName());
                }
            } else {
                if (field.isAnnotationPresent(JsonProperty.class)) {
                    String jsonName = field.getAnnotation(JsonProperty.class).name();
                    if (jsonName.equals("")) {
                        jsonName = field.getName();
                    }
                    jsonNameFieldNameMap.put(jsonName, field.getName());
                }
            }
        }

        return jsonNameFieldNameMap;
    }

    @Override
    public void write(Object obj, JsonWriter writer) {
        writer.writeObjectBegin();
        for (String fieldName : fieldNameJsonNameMap.keySet()) {
            int depth = fieldDepthMap.get(fieldName);

            writer.writeString(fieldNameJsonNameMap.get(fieldName));
            writer.writePropertySeparator();
            Object fieldVal = getFieldValue(obj, fieldName, depth);

            if (fieldVal == null) {
                writer.writeNull();
                writer.writeSeparator();
                continue;
            }
            JsonMapper mapper = mapperFactory.createMapper(fieldVal.getClass());
            mapper.write(fieldVal, writer);
            writer.writeSeparator();
        }
        writer.writeObjectEnd();

    }

    private Object getFieldValue(Object obj, String fieldName, int depth) {
        Class<?> clazz = obj.getClass();
        for (int i = 0; i < depth; i++) {
            clazz = clazz.getSuperclass();
        }
        Object result = null;

        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            result = field.get(obj);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
