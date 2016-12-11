package com.gmail.at.sichyuriyy.netcracker.lab02.jsonserializer.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class ReflectionUtils {
    
    public enum ModifierType {
        PUBLIC, PRIVATE, PROTECTED, PACKAEG_PRIVATE
    }
    
    public ModifierType getModifierType(Field field) {
        int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return ModifierType.PUBLIC;
        } else if (Modifier.isProtected(modifiers)) {
            return ModifierType.PROTECTED;
        } else if (Modifier.isPrivate(modifiers)) {
            return ModifierType.PRIVATE;
        } else  {
            return ModifierType.PACKAEG_PRIVATE;
        }
    }
    
}
