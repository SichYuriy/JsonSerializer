package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.BooleanMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.CharacterMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.NumberMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonmapper.StringMapper;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.JsonMapperFactory;

public class JsonSerializer {
    
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    
    protected AbstractJsonMapperFactory mapperFactory;
    
    
    private boolean indent;
    
    
    
    public JsonSerializer(AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
        NumberMapper numberMapper = new NumberMapper();
        BooleanMapper booleanMapper = new BooleanMapper();
        CharacterMapper characterMapper = new CharacterMapper();
        mapperFactory.addMapper(Byte.class, numberMapper);
        mapperFactory.addMapper(byte.class, numberMapper);
        mapperFactory.addMapper(Short.class, numberMapper);
        mapperFactory.addMapper(short.class, numberMapper);
        mapperFactory.addMapper(Integer.class, numberMapper);
        mapperFactory.addMapper(int.class, numberMapper);
        mapperFactory.addMapper(Long.class, numberMapper);
        mapperFactory.addMapper(long.class, numberMapper);
        mapperFactory.addMapper(Float.class, numberMapper);
        mapperFactory.addMapper(float.class, numberMapper);
        mapperFactory.addMapper(Double.class, numberMapper);
        mapperFactory.addMapper(double.class, numberMapper);
        mapperFactory.addMapper(Boolean.class, booleanMapper);
        mapperFactory.addMapper(Character.class, characterMapper);
        mapperFactory.addMapper(char.class, characterMapper);
        mapperFactory.addMapper(String.class, new StringMapper());
    }
    
    public JsonSerializer() {
        this(new JsonMapperFactory());
    }
    
    public boolean isIndent() {
        return indent;
    }
    
    public void setIndent(boolean indent) {
        this.indent = indent;
    }
    
    public String serialize(Object obj) throws IllegalStateException {
        StringWriter writer = new StringWriter();
        serialize(obj, writer);
        return writer.toString(); 
    }
    
    public void serialize(Object obj, OutputStream stream) {
        serialize(obj, stream, DEFAULT_CHARSET);
    }
    
    public void serialize(Object obj, OutputStream stream, Charset charset) {
        serialize(obj, new OutputStreamWriter(stream, charset));
    }
    
    public void serialize(Object obj, Writer writer) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        mapperFactory.createMapper(obj.getClass()).write(obj, jsonWriter);
        jsonWriter.flush();
    }
    
    
}
