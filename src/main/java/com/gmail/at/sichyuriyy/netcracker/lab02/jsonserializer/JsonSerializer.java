package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.IndentedJsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.jsonwriter.JsonWriter;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.AbstractJsonMapperFactory;
import com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.mapperfacroy.JsonMapperFactory;

public class JsonSerializer {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    protected AbstractJsonMapperFactory mapperFactory;

    private boolean indent;
    private int indentSize = 2;

    public JsonSerializer(AbstractJsonMapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
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

    public void serialize(Object obj, OutputStream stream) throws IllegalStateException {
        serialize(obj, stream, DEFAULT_CHARSET);
    }

    public void serialize(Object obj, OutputStream stream, Charset charset) throws IllegalStateException {
        serialize(obj, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object obj, Writer writer) throws IllegalStateException {
        JsonWriter jsonWriter;
        if (indent) {
            jsonWriter = new IndentedJsonWriter(writer, indentSize);
        } else {
            jsonWriter = new JsonWriter(writer);
        }
        if (obj == null) {
            jsonWriter.writeNull();
        } else {
            mapperFactory.createMapper(obj.getClass()).write(obj, jsonWriter);
        }

        jsonWriter.flush();
    }

    public int getIndentSize() {
        return indentSize;
    }

    public void setIndentSize(int indentSize) {
        this.indentSize = indentSize;
    }

}
