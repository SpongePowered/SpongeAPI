/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.util.inventory;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.VectorNi;
import com.flowpowered.math.vector.Vectord;
import com.flowpowered.math.vector.Vectorf;
import com.flowpowered.math.vector.Vectorl;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;


/**
 * Utility class for coercing unknown values to specific target types.
 */
public final class Coerce {
    
    private static final Pattern listPattern = Pattern.compile("^([\\(\\[\\{]?)(.+?)([\\)\\]\\}]?)$");
    
    private static final String[] listPairings = { "([{", ")]}" }; 
    
    private static final Pattern vector2Pattern = Pattern.compile("^\\( *(-?[\\d\\.]{1,10}), *(-?[\\d\\.]{1,10}) *\\)$");
    
    /**
     * No subclasses for you.
     */
    private Coerce() {}
    
    /**
     * Coerce the supplied object to a string.
     * 
     * @param obj Object to coerce
     * @return Object as a string, empty string if the object is null
     */
    public static String toString(@Nullable Object obj) {
        if (obj == null) {
            return ""; 
        }
        
        if (obj.getClass().isArray()) {
            return Coerce.toList(obj).toString();
        }
        
        return obj.toString();
    }
    
    /**
     * Coerce the supplied object to a list. Accepts lists and all types of 1D
     * arrays. Also (naively) supports lists in Strings in a format like
     * <code>{1,2,3,I,am,a,list}</code>
     * 
     * @param obj Object to coerce
     * @return Some kind of List filled with unimaginable horrors
     */
    public static List<?> toList(@Nullable Object obj) {
        if (obj == null) {
            return Collections.<Object>emptyList();
        }
        
        if (obj instanceof List) {
            return (List<?>)obj;
        }
        
        Class<? extends Object> clazz = obj.getClass();
        if (clazz.isArray()) {
            if (clazz.getComponentType().isPrimitive()) {
                return Coerce.primitiveArrayToList(obj);
            }
            
            return Arrays.asList((Object[])obj);
        }
        
        return Coerce.parseStringToList(obj.toString());
    }
    
    /**
     * Coerce the specified object to a list containing only objects of type
     * specified by <code>ofClass</code>. Also coerces list values where
     * possible. 
     * 
     * @param obj Object to coerce
     * @param ofClass Class to coerce to
     * @param <T> type of list (notional)
     * @return List of coerced values
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> toListOf(@Nullable Object obj, Class<T> ofClass) {
        List<T> filteredList = new ArrayList<T>();

        for (Object o : Coerce.toList(obj)) {
            if (ofClass.isAssignableFrom(o.getClass())) {
                filteredList.add((T)o);
            } else if (ofClass.equals(String.class)) {
                filteredList.add((T)Coerce.toString(o));
            } else if (ofClass.equals(Integer.TYPE) || ofClass.equals(Integer.class)) {
                filteredList.add((T)(Integer)Coerce.toInteger(o));
            } else if (ofClass.equals(Float.TYPE) || ofClass.equals(Float.class)) {
                filteredList.add((T)new Float(Coerce.toDouble(o)));
            } else if (ofClass.equals(Double.TYPE) || ofClass.equals(Double.class)) {
                filteredList.add((T)(Double)Coerce.toDouble(o));
            } else if (ofClass.equals(Boolean.TYPE) || ofClass.equals(Boolean.class)) {
                filteredList.add((T)(Boolean)Coerce.toBoolean(o));
            }
        }
        
        return filteredList;
    }
    
    /**
     * Coerce the supplied object to a boolean, matches strings such as "yes" as
     * well as literal boolean values.
     * 
     * @param obj Object to coerce
     * @return Object as a boolean, <code>false</code> if the object is null
     */
    public static boolean toBoolean(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        
        return (obj instanceof Boolean) ? ((Boolean)obj).booleanValue() : obj.toString().trim().matches("^(1|true|yes)$");
    }
    
    /**
     * Coerce the supplied object to an integer, parse it if necessary.
     * 
     * @param obj Object to coerce
     * @return Object as an integer, <code>0</code> if the object is null or
     *      cannot be parsed
     */
    public static int toInteger(@Nullable Object obj) {
        if (obj == null) {
            return 0;
        }
        
        if (obj instanceof Number) {
            return ((Number)obj).intValue();
        }
        
        String strObj = Coerce.sanitiseNumber(obj);
        Integer iParsed = Ints.tryParse(strObj);
        if (iParsed != null) {
            return iParsed.intValue();
        }

        Double dParsed = Doubles.tryParse(strObj);
        return dParsed != null ? dParsed.intValue() : 0;
    }
    
    /**
     * Coerce the supplied object to a double-precision floating-point number,
     * parse it if necessary
     * 
     * @param obj Object to coerce
     * @return Object as a double, <code>0.0</code> if the object is null or
     *      cannot be parsed
     */
    public static double toDouble(@Nullable Object obj) {
        if (obj == null) {
            return 0.0;
        }
        
        if (obj instanceof Number) {
            return ((Number)obj).doubleValue();
        }
        
        Double parsed = Doubles.tryParse(Coerce.sanitiseNumber(obj));
        return parsed != null ? parsed.doubleValue() : 0.0;
    }

    /**
     * Coerce the specified object to an enum of the supplied type, returns the
     * first enum constant in the enum if parsing fails.
     * 
     * @param obj Object to coerce
     * @param enumClass Enum class to coerce to
     * @param <E> enum type
     * @return Coerced enum value
     */
    public static <E extends Enum<E>> E toEnum(@Nullable Object obj, Class<E> enumClass) {
        return Coerce.toEnum(obj, enumClass, enumClass.getEnumConstants()[0]);
    }

    /**
     * Coerce the specified object to an enum of the supplied type, returns the
     * specified default value if parsing fails.
     * 
     * @param obj Object to coerce
     * @param enumClass Enum class to coerce to
     * @param defaultValue default value to return if coercion fails 
     * @param <E> enum type
     * @return Coerced enum value
     */
    public static <E extends Enum<E>> E toEnum(@Nullable Object obj, Class<E> enumClass, E defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        
        if (enumClass.isAssignableFrom(obj.getClass())) {
            @SuppressWarnings("unchecked")
            E enumObj = (E)obj;
            return enumObj;
        }

        String strObj = obj.toString().trim();
        
        try {
            // Efficient but case-sensitive lookup in the constant map
            return Enum.valueOf(enumClass, strObj);
        } catch (IllegalArgumentException ex) {
            // fall through
        }
        
        // Try a case-insensitive lookup
        for (E value : enumClass.getEnumConstants()) {
            if (value.name().equalsIgnoreCase(strObj)) {
                return value;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * Coerce the specified object to the specified pseudo-enum type using the
     * supplied pseudo-enum dictionary class.
     * 
     * @param obj Object to coerce
     * @param pseudoEnumClass The pseudo-enum class
     * @param dictionaryClass Pseudo-enum dictionary class to look in
     * @param defaultValue Value to return if lookup fails
     * @param <T> pseudo-enum type
     * @return Coerced value or default if coercion fails
     */
    public static <T> T toPseudoEnum(@Nullable Object obj, Class<T> pseudoEnumClass, Class<?> dictionaryClass, T defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        
        if (pseudoEnumClass.isAssignableFrom(obj.getClass())) {
            @SuppressWarnings("unchecked")
            T enumObj = (T)obj;
            return enumObj;
        }

        String strObj = obj.toString().trim();
        
        try {
            for (Field field : dictionaryClass.getFields()) {
                if ((field.getModifiers() & Modifier.STATIC) != 0 && pseudoEnumClass.isAssignableFrom(field.getType())) {
                    String fieldName = field.getName();
                    @SuppressWarnings("unchecked")
                    T entry = (T)field.get(null);
                    if (strObj.equalsIgnoreCase(fieldName)) {
                        return entry;
                    }
                }
            }
        } catch (Exception ex) {
            // well that went badly
        }
        
        return defaultValue;
    }
    
    /**
     * Coerce the supplied object to a Vector2i
     * 
     * @param obj Object to coerce
     * @return Vector2i, returns Vector2i.ZERO if coercion failed
     */
    public static Vector2i toVector2i(@Nullable Object obj) {
        if (obj == null) {
            return Vector2i.ZERO;
        }
        
        if (obj instanceof Vectorl) {
            obj = ((Vectorl)obj).toInt();
        } else if (obj instanceof Vectorf) {
            obj = ((Vectorf)obj).toInt();
        } else if (obj instanceof Vectord) {
            obj = ((Vectord)obj).toInt();
        }
        
        if (obj instanceof Vector2i) {
            return (Vector2i)obj;
        } else if (obj instanceof Vector3i) {
            return new Vector2i((Vector3i)obj);
        } else if (obj instanceof Vector4i) {
            return new Vector2i((Vector4i)obj);
        } else if (obj instanceof VectorNi) {
            return new Vector2i((VectorNi)obj);
        }
        
        Matcher vecMatch = Coerce.vector2Pattern.matcher(obj.toString());
        if (listBracketsMatch(vecMatch)) {
            return new Vector2i(Integer.parseInt(vecMatch.group(1)), Integer.parseInt(vecMatch.group(2)));
        }
        
        List<?> list = Coerce.toList(obj);
        if (list.size() == 2) {
            return new Vector2i(Coerce.toInteger(list.get(0)), Coerce.toInteger(list.get(1)));
        }

        return Vector2i.ZERO;
    }

    /**
     * Sanitise a string containing a common representation of a number to make
     * it parseable. Strips thousand-separating commas and trims later members
     * of a comma-separated list. For example the string "(9.5, 10.6, 33.2)"
     * will be sanitised to "9.5".  
     * 
     * @param obj Object to sanitise
     * @return Sanitised number-format string to parse
     */
    private static String sanitiseNumber(Object obj) {
        String string = obj.toString().trim();
        if (string.length() < 1) {
            return "0";
        }
        
        Matcher candidate = Coerce.listPattern.matcher(string);
        if (Coerce.listBracketsMatch(candidate)) {
            string = candidate.group(2).trim();
        }
        
        int decimal = string.indexOf('.');
        int comma = string.indexOf(',', decimal);
        if (decimal > -1 && comma > -1) {
            return Coerce.sanitiseNumber(string.substring(0, comma));
        }
        
        if (string.indexOf('-', 1) != -1) {
            return "0";
        }
        
        return string.replace(",", "").split(" ")[0];
    }

    private static boolean listBracketsMatch(Matcher candidate) {
        return candidate.matches() && Coerce.listPairings[0].indexOf(candidate.group(1)) == Coerce.listPairings[1].indexOf(candidate.group(3));
    }

    private static List<?> primitiveArrayToList(Object obj) {
        if (obj instanceof boolean[]) {
            return Booleans.asList((boolean[])obj);
        } else if (obj instanceof char[]) {
            return Chars.asList((char[])obj);
        } else if (obj instanceof byte[]) {
            return Bytes.asList((byte[])obj);
        } else if (obj instanceof short[]) {
            return Shorts.asList((short[])obj);
        } else if (obj instanceof int[]) {
            return Ints.asList((int[])obj);
        } else if (obj instanceof long[]) {
            return Longs.asList((long[])obj);
        } else if (obj instanceof float[]) {
            return Floats.asList((float[])obj);
        } else if (obj instanceof double[]) {
            return Doubles.asList((double[])obj);
        }
        
        return Collections.<Object>emptyList();
    }
    
    private static List<?> parseStringToList(String string) {
        Matcher candidate = Coerce.listPattern.matcher(string);
        if (!Coerce.listBracketsMatch(candidate)) {
            return Collections.<Object>emptyList();
        }
        
        List<String> list = new ArrayList<String>();
        for (String part : candidate.group(2).split(",")) {
            if (part != null) {
                list.add(part);
            }
        }
        return list;
    }

}
