package copy_utils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CopyMaker {

    public static void copy(Object origin, Object copy) throws Exception {
        Class originClass = origin.getClass();
        Class copyClass = copy.getClass();
        List<Field> originFields = collectFields(originClass);
        List<Field> copyFields = collectFields(copyClass);
        for (Field source : originFields) {
            Field target = findAndRemove(source, copyFields);
            if ((target) != null) {
                target.set(copy, source.get(origin));
            }
        }
    }

    private static List<Field> collectFields(Class c) {
        List<Field> accessibleFields = new ArrayList<>();
        do {
            for (Field field : c.getDeclaredFields()) {
                field.setAccessible(true);
                accessibleFields.add(field);
            }
            c = c.getSuperclass();
        } while (c != null && c != Object.class);
        return accessibleFields;
    }

    private static Field findAndRemove(Field field, List<Field> fields) {
        for (Iterator<Field> i = fields.iterator(); i.hasNext(); ) {
            Field actual = i.next();
            if (field.getName().equals(actual.getName())
                    && field.getType().equals(actual.getType())) {
                i.remove();
                return actual;
            }
        }
        return null;
    }
}
