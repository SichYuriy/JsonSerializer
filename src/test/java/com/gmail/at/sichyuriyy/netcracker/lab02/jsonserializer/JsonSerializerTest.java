package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JsonSerializerTest {
    
    private JsonSerializer serializer;
    
    @Before
    public void setUp() {
        serializer = new JsonSerializer();
    }
    
    @After
    public void tearDown() {
        serializer = null;
    }


    @Test
    public void testSerialize_BytePrimitive() {
        byte input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_ByteObject() {
        Byte input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_ShortPrimitive() {
        short input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_ShortObject() {
        Short input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_IntegerPrimitive() {
        int input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_IntegerObject() {
        Integer input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_LongPrimitive() {
        long input = 113;
        String actual = serializer.serialize(input);
        String expected = "113";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_LongObject() {
        Long input = 113123l;
        String actual = serializer.serialize(input);
        String expected = "113123";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_FloatPrimitive() {
        float input = 113.2f;
        String actual = serializer.serialize(input);
        String expected = "113.2";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_FloatObject() {
        Float input = 113.2f;
        String actual = serializer.serialize(input);
        String expected = "113.2";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_DoublePrimitive() {
        double input = 113.25d;
        String actual = serializer.serialize(input);
        String expected = "113.25";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_DoubleObject() {
        Double input = 113.25d;
        String actual = serializer.serialize(input);
        String expected = "113.25";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_BooleanPrimitive() {
        boolean input = false;
        String actual = serializer.serialize(input);
        String expected = "false";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_BooleanObject() {
        Boolean input = false;
        String actual = serializer.serialize(input);
        String expected = "false";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_CharacterPrimitive() {
        char input = 'a';
        String actual = serializer.serialize(input);
        String expected = "\"a\"";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_CharacterObject() {
        Character input = 'a';
        String actual = serializer.serialize(input);
        String expected = "\"a\"";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_String() {
        String input = "str";
        String actual = serializer.serialize(input);
        String expected = "\"str\"";
        assertEquals(expected, actual);
    }
    
   

}
