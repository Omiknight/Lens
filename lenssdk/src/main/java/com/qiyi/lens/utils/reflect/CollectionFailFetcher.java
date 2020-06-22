package com.qiyi.lens.utils.reflect;

import com.qiyi.lens.utils.iface.IViewInfoHandle;
import com.qiyi.lens.utils.iface.ObjectDescription;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionFailFetcher {

    private Object value;

    public CollectionFailFetcher(Object value) {
        this.value = value;

    }

    public Object[] getObjectSizeAndIndexAt(IViewInfoHandle handle, Object view, int size, int index) {

        Class cls = value.getClass();
        List data = new LinkedList();
        while (cls != Object.class && cls != null) {

            Field[] flds = cls.getDeclaredFields();
            for (Field field : flds) {
                try {
                    field.setAccessible(true);
                    Object object = field.get(value);
                    if (object instanceof List) {
                        List list = (List) object;
                        if (list.size() == size) {
                            Object indexValue = list.get(index);
                            data.add(indexValue);

                            if (handle != null) {
                                Object[] vars = handle.onViewAnalyse(view, indexValue);
                                if (vars != null) {
                                    Collections.addAll(data, vars);
                                }
                            }

                        }

                    } else if (object instanceof Object[]) {
                        Object[] array = (Object[]) object;
                        if (array.length == size) {
                            data.add(new ObjectDescription(array[index],"index " + index));
                            if (handle != null) {
                                Object[] vars = handle.onViewAnalyse(view, array[index]);
                                if (vars != null) {
                                    data.addAll(Arrays.asList(vars));
                                }
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }

            }

            cls = cls.getSuperclass();

        }


        if (!data.isEmpty()) {
            Object[] value = new Object[data.size()];
            data.toArray(value);
            return value;
        }

        return null;
    }
}
