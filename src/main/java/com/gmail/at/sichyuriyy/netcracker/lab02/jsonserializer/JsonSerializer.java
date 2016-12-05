package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class JsonSerializer {
    
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    
    public boolean isIndent() {
        return true; //TODO:
    }
    
    public void setIndent(boolean indent) {
        //TODO:
    }
    
    public String serialize(Object obj) throws IllegalStateException {
        return null; //TODO:
    }
    
    public void serialize(Object obj, OutputStream stream) {
        serialize(obj, stream, DEFAULT_CHARSET);
    }
    
    public void serialize(Object obj, OutputStream stream, Charset charset) {
        serialize(obj, new OutputStreamWriter(stream, charset));
    }
    
    public static void serialize(Object obj, Writer writer) {
        //TODO:
    }
}
