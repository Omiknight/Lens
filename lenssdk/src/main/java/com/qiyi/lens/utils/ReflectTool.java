package com.qiyi.lens.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Bad implementation, Use {@link com.qiyi.lens.utils.LensReflectionTool} instead
 */
@Deprecated
public class ReflectTool {
    //[return the field value ]
    public static Object getField(Object data, String fieldName) {
        if (data != null && fieldName != null) {
            Class cls = data.getClass();
            while (cls != Object.class && cls != null) {
                try {
                    Field fld = cls.getDeclaredField(fieldName);
                    try {
                        fld.setAccessible(true);
                        return fld.get(data);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    }
                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
                    cls = cls.getSuperclass();
                }

            }

        }
        return null;
    }

    public static void setObjValue(Object data, String fieldName, Object value) {
        if (data != null && fieldName != null) {
            Class cls = data.getClass();
            while (cls != Object.class && cls != null) {
                try {
                    Field fld = cls.getDeclaredField(fieldName);
                    try {
                        fld.setAccessible(true);
                        fld.set(data, value);
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
                    cls = cls.getSuperclass();
                }

            }

        }
    }

    public static void setIntValue(Object data, String fieldName, int value) {
        if (data != null && fieldName != null) {
            Class cls = data.getClass();
            while (cls != Object.class && cls != null) {
                try {
                    Field fld = cls.getDeclaredField(fieldName);
                    try {
                        fld.setAccessible(true);
                        fld.setInt(data, value);
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
                    cls = cls.getSuperclass();
                }

            }

        }
    }


    private static void setArtMethod(Method method, KeyField field) {
        Object value = ReflectTool.getField(method, "artMethod");
        if (value != null) {
            ReflectTool.setIntValue(value, "dexCodeItemOffset", field.dexCodeItemOffset);
            ReflectTool.setIntValue(value, "dexMethodIndex", field.dexMethodIndex);
            ReflectTool.setIntValue(value, "methodIndex", field.methodIndex);
        }
    }

    private static KeyField getField(Method method) {

        Object value = ReflectTool.getField(method, "artMethod");
        if (value != null) {
            int a = (int) ReflectTool.getField(value, "dexCodeItemOffset");
            int b = (int) ReflectTool.getField(value, "dexMethodIndex");
            int c = (int) ReflectTool.getField(value, "methodIndex");
            return new KeyField(a, b, c);
        }
        return null;
    }

    static class KeyField {
        int dexCodeItemOffset;
        int dexMethodIndex;
        int methodIndex;

        KeyField(int a, int b, int c) {
            this.dexCodeItemOffset = a;
            this.dexMethodIndex = b;
            this.methodIndex = c;

        }
    }


    public static Object getStaticFeildValue(Class cls, String name) {
        while (cls != Object.class && cls != null) {
            try {
                Field fld = cls.getDeclaredField(name);
                try {
                    fld.setAccessible(true);
                    return fld.get(cls);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static boolean getStaticFieldBoolean(Class cls, String name) {
        while (cls != Object.class && cls != null) {
            try {
                Field fld = cls.getDeclaredField(name);
                try {
                    fld.setAccessible(true);
                    return fld.getBoolean(cls);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                cls = cls.getSuperclass();
            }
        }
        return false;
    }

    public static int getStaticFieldInt(Class cls, String name) {
        while (cls != Object.class && cls != null) {
            try {
                Field fld = cls.getDeclaredField(name);
                try {
                    fld.setAccessible(true);
                    return fld.getInt(cls);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return 0;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                cls = cls.getSuperclass();
            }
        }
        return 0;
    }

    public static void setStaticFieldValue(Class cls, String name, Object data) {
        while (cls != Object.class && cls != null) {
            try {
                Field fld = cls.getDeclaredField(name);
                try {
                    fld.setAccessible(true);
                    fld.set(cls, data);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    break;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                cls = cls.getSuperclass();
            }
        }
    }

    public static void setStaticFieldBoolean(Class cls, String name, boolean bl) {
        while (cls != Object.class && cls != null) {
            try {
                Field fld = cls.getDeclaredField(name);
                try {
                    fld.setAccessible(true);
                    fld.setBoolean(cls, bl);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    break;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                cls = cls.getSuperclass();
            }
        }
    }

    public static void setStaticFieldInt(Class cls, String name, int data) {
        while (cls != Object.class && cls != null) {
            try {
                Field fld = cls.getDeclaredField(name);
                try {
                    fld.setAccessible(true);
                    fld.setInt(cls, data);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    break;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                cls = cls.getSuperclass();
            }
        }
    }


    public static Object callStaticMethod(String clzName, String methodName, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (clzName != null) {
            Class cls;
            try {
                cls = Class.forName(clzName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
            Method method = cls.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            return method.invoke(null, args);
        }
        return null;
    }


}
