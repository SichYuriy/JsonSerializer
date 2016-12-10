package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    
    @Test
    public void testSerialize_Null() {
        String input = null;
        String actual = serializer.serialize(input);
        String expected = "null";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_Collection() {
        LinkedList<Object> input = new LinkedList<Object>();
        input.add(1);
        input.add("str");
        input.add(null);
        input.add(false);
        String actual = serializer.serialize(input);
        String expected = "[1,\"str\",null,false]";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_CollectionInCollection() {
        LinkedList<Object> input = new LinkedList<Object>();
        input.add(1);
        input.add("str");
        input.add(null);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(777);
        arrayList.add(123);
        arrayList.add("str2");
        input.add(arrayList);
        input.add(false);
       
        String actual = serializer.serialize(input);
        String expected = "[1,\"str\",null,[777,123,\"str2\"],false]";
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_Map() {
        Map<String, Object> input = new LinkedHashMap<String, Object>();
        input.put("firstName", "Yuriy");
        input.put("lastName", "Sych");
        input.put("age", 19);
        List<String> brothers = new LinkedList<String>();
        brothers.add("Sergiy");
        brothers.add("Oleg");
        input.put("brothers", brothers);
        
        String actual = serializer.serialize(input);
        String expected = "{"
                + "\"firstName\":\"Yuriy\","
                + "\"lastName\":\"Sych\","
                + "\"age\":19,"
                + "\"brothers\":[\"Sergiy\",\"Oleg\"]"
                + "}";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_ObjectArray() {
        String []input = new String[]{"str1", "str2", "str3"};
        String actual = serializer.serialize(input);
        String expected = "[\"str1\",\"str2\",\"str3\"]";
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSerialize_PrimitiveArray() {
        int []input = new int[]{1, 2, 3};
        String actual = serializer.serialize(input);
        String expected = "[1,2,3]";
        assertEquals(expected, actual);
    }
   
    
   

}
