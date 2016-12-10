package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter;

import java.io.IOException;
import java.io.Writer;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.exception.JsonWriterIOException;

public class JsonWriter {
    
    protected static final char OBJ_BEGIN = '{';
    protected static final char OBJ_END = '}';
    protected static final char ARR_BEGIN = '[';
    protected static final char ARR_END = ']';
    protected static final char SEPARATOR = ',';
    protected static final char PROP_SEPARATOR = ':';
    protected static final char STR_SEPARATOR = '\"';
    protected static final String NULL = "null";
    
    protected Writer writer;
    
    protected boolean separatorLast;
    
    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    public void writeObjectBegin() {
        checkSeparator();
        try {
            writer.write(OBJ_BEGIN);
        } catch (IOException e) {
           throw new JsonWriterIOException();
        }
        
        
    }

    public void writeObjectEnd() {
        separatorLast = false;
        try {
            writer.write(OBJ_END);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }

    public void writeArrayBegin() {
        checkSeparator();
        try {
            writer.write(ARR_BEGIN);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }

    public void writeArrayEnd() {
        separatorLast = false;
        try {
            writer.write(ARR_END);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
        
    }

    public void writeString(String str) {
        checkSeparator();
        try {
            writer.append(STR_SEPARATOR).append(str).append(STR_SEPARATOR);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }

    public void writeNumber(Number number) {
        checkSeparator();
        try {
            writer.write(number.toString());
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }

    public void writeSeparator() {
        separatorLast = true;
    }
    
    public void writePropertySeparator() {
        try {
            writer.write(PROP_SEPARATOR);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }
    
    public void writeBoolean(Boolean val) {
        checkSeparator();
        try {
            writer.write(val.toString());
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }

    }
    
    public void writeNull() {
        checkSeparator();
        try {
            writer.write(NULL);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }
    
    public void flush() {
        try {
            writer.flush();
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }
    
    protected void writeSeparatorNow() {
        try {
            writer.write(SEPARATOR);
        } catch (IOException e) {
            throw new JsonWriterIOException();
        }
    }
    
    protected void checkSeparator() {
        if (separatorLast) {
            writeSeparatorNow();
            separatorLast = false;
        }
    }

}
