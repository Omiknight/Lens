package com.qiyi.lens.utils.reflect;

import android.util.SparseArray;

import java.lang.reflect.Field;
import java.util.LinkedList;

public class ArrayFieldInfo extends FieldInfo {
    public ArrayFieldInfo(Object obj, SparseArray hashMap, Invalidate par) {
        super(obj, hashMap, par);
    }

    public ArrayFieldInfo(Field fld, Object src, SparseArray hs, Invalidate pa) {
        super(fld, src, hs, pa);
    }

    @Override
    public void preBuildSpannables(StringBuilder stringBuilder, LinkedList<SpanableInfo> infosList) {
        if (value != null) {
            stringBuilder.append("\n");
            String space = makeSpace();
            stringBuilder.append(space);
            stringBuilder.append(value.getClass());
            stringBuilder.append(" ");
            Object[] da = (Object[]) value;
            stringBuilder.append(da.length);
            stringBuilder.append("\n");
        }
    }

    @Override
    public void makeList(LinkedList linkedList) {
        if (value != null) {

            Object[] data = (Object[]) value;
            int size = data.length;
            if (list == null) {
                list = new LinkedList<>();
            } else {
                list.clear();
            }

            for (Object datum : data) {
                if (datum != null) {
                    FieldInfo info = ObjectFieldCollector.create(datum, hashMap, this);
                    info.setAsSimple(isSimple);
                    list.add(info);
                }
            }

        }
    }


}
