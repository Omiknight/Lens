package com.qiyi.lens.utils.reflect;

import android.util.SparseArray;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class ListFieldInfo extends FieldInfo {
    public ListFieldInfo(Object obj, SparseArray hashMap, Invalidate par) {
        super(obj, hashMap, par);
    }

    public ListFieldInfo(Field fld, Object src, SparseArray hs, Invalidate pa) {
        super(fld, src, hs, pa);
    }

    @Override
    public void preBuildSpannables(StringBuilder stringBuilder, LinkedList<SpanableInfo> infosList) {
        if (value != null) {
            stringBuilder.append("\n");
            String space = makeSpace();
            stringBuilder.append(space);
//            stringBuilder.append(value.getClass());
            stringBuilder.append("size: ");
            List list = (List) value;
            stringBuilder.append(list.size());
//            stringBuilder.append("\n");
        }
    }

    @Override
    public void makeList(LinkedList linkedList) {
        if (value != null) {

            List data = (List) value;
            if (list == null) {
                list = new LinkedList<>();
            } else {
                list.clear();
            }


            for (Object var : data) {
                if (var != null) {
                    FieldInfo info = ObjectFieldCollector.create(var, hashMap, this);
                    info.setLevel(level + 1);
                    info.setAsSimple(isSimple);
                    list.add(info);
                }
            }


        }
    }


}
