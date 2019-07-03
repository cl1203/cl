package com.cl.comm.reflection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.Map;

/**
 * @ClassName ReflectionHelper
 * @Description 反射工具类. 提供调用getter/setter方法, 访问私有变量, 调用私有方法, 获取泛型类型Class,
 * 被AOP过的真实类等工具函数.
 * @Author 陈龙
 * @Date 2019/7/3 15:54
 * @Version 1.0
 **/
public class ReflectionHelper {
    /**
     * <p>
     * Field SETTER_PREFIX: set.
     * </p>
     */
    private static final String SETTER_PREFIX = "set";

    /**
     * <p>
     * Field GETTER_PREFIX: get.
     * </p>
     */
    private static final String GETTER_PREFIX = "get";

    /**
     * <p>
     * Field CGLIB_CLASS_SEPARATOR: $$.
     * </p>
     */
    private static final String CGLIB_CLASS_SEPARATOR = "$$";

    /**
     * <p>
     * Field logger: logger.
     * </p>
     */
    private static Logger logger = LoggerFactory.getLogger(ReflectionHelper.class);

    /**
     * <p>
     * Description: 将反射时的checked exception转换为unchecked exception.
     * </p>
     *
     * @param e 异常
     * @return RuntimeException
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException) {
            return new IllegalArgumentException(e);
        } else if (e instanceof InvocationTargetException) {
            return new RuntimeException(((InvocationTargetException) e).getTargetException());
        } else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

    /**
     * <p>
     * Description: 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问. 如向上转型到Object仍无法找到,
     * 返回null.
     * </p>
     *
     * @param obj 参数
     * @param fieldName 文件名
     * @return Field 返回结果
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(fieldName, "fieldName can't be blank");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            } catch (NoSuchFieldException e) {
                // Field不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * <p>
     * Description: 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问. 如向上转型到Object仍无法找到,
     * 返回null. 匹配函数名+参数类型。 用于方法需要被多次调用的情况.
     * 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object...
     * </p>
     *
     * @param obj 参数
     * @param methodName 方法名
     * @param parameterTypes 参数类型
     * @return Method 返回结果
     */
    public static Method getAccessibleMethod(final Object obj, final String methodName,
                                             final Class<?>... parameterTypes) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(methodName, "methodName can't be blank");

        for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType
                .getSuperclass()) {
            try {
                Method method = searchType.getDeclaredMethod(methodName, parameterTypes);

                makeAccessible(method);
                return method;
            } catch (NoSuchMethodException e) {
                // Method不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * <p>
     * Description: 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问. 如向上转型到Object仍无法找到,
     * 返回null. 只匹配函数名。 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object
     * obj, Object...
     * </p>
     *
     * @param obj 参数
     * @param methodName 方法名
     * @return 返回结果
     */
    public static Method getAccessibleMethodByName(final Object obj, final String methodName) {
        Validate.notNull(obj, "object can't be null");
        Validate.notBlank(methodName, "methodName can't be blank");

        for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType
                .getSuperclass()) {
            Method[] methods = searchType.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    makeAccessible(method);
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * <p>
     * Description: 通过反射, 获得Class定义中声明的泛型参数的类型, 注意泛型必须定义在父类处 如无法找到,
     * 返回Object.class. eg.
     * </p>
     *
     * @param <T> 类型
     * @param clazz 参数
     * @return 返回结果
     */
    public static <T> Class<T> getClassGenricType(final Class clazz) {
        return getClassGenricType(clazz, 0);
    }

    /**
     * <p>
     * Description: 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     * </p>
     *
     * @param clazz 参数
     * @param index 参数
     * @return 返回结果
     */
    public static Class getClassGenricType(final Class clazz, final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    /**
     * <p>
     * Description: 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     * </p>
     *
     * @param obj 参数
     * @param fieldName 文件名
     * @return Object 返回结果
     */
    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    /**
     * <p>
     * Description: getUserClass.
     * </p>
     *
     * @param instance 参数
     * @return Class<?> 返回结果
     */
    public static Class<?> getUserClass(Object instance) {
        Class clazz = instance.getClass();
        if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null && !Object.class.equals(superClass)) {
                return superClass;
            }
        }
        return clazz;

    }

    /**
     * <p>
     * Description: 调用Getter方法.
     * </p>
     *
     * @param obj 参数
     * @param propertyName 参数
     * @return Object 返回结果
     */
    public static Object invokeGetter(Object obj, String propertyName) {
        String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, new Class[] {}, new Object[] {});
    }

    /**
     * <p>
     * Description: 直接调用对象方法,
     * 无视private/protected修饰符,用于一次性调用的情况，否则应使用getAccessibleMethod()函数获得Method后反复调用.
     * 同时匹配方法名+参数类型，.
     * </p>
     *
     * @param obj obj
     * @param methodName methodName
     * @param parameterTypes parameterTypes
     * @param args args
     * @return Object 返回结果
     */
    public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
                                      final Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * <p>
     * Description: 直接调用对象方法, 无视private/protected修饰符，用于一次性调用的情况，
     * 否则应使用getAccessibleMethodByName()函数获得Method后反复调用. 只匹配函数名，如果有多个同名函数调用第一个。
     * </p>
     *
     * @param obj obj
     * @param methodName methodName
     * @param args args
     * @return Object Object
     */
    public static Object invokeMethodByName(final Object obj, final String methodName, final Object... args) {
        Method method = getAccessibleMethodByName(obj, methodName);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * <p>
     * Description: 调用Setter方法, 仅匹配方法名.
     * </p>
     *
     * @param obj obj
     * @param propertyName propertyName
     * @param value value
     */
    public static void invokeSetter(Object obj, String propertyName, Object value) {
        String setterMethodName = SETTER_PREFIX + StringUtils.capitalize(propertyName);
        invokeMethodByName(obj, setterMethodName, new Object[] { value });
    }

    /**
     * <p>
     * Description: 调用Setters方法, 仅匹配方法名.
     * </p>
     *
     * @param obj 参数
     * @param params 参数
     */
    public static void invokeSetters(Object obj, Map<String, Object> params) {
        if (null != params) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                invokeSetter(obj, entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * <p>
     * Description:
     * 改变private/protected的成员变量为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨.
     * </p>
     *
     * @param field field
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
                || Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * <p>
     * Description:
     * 改变private/protected的方法为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨.
     * </p>
     *
     * @param method 方法
     */
    public static void makeAccessible(Method method) {
        if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
                && !method.isAccessible()) {
            method.setAccessible(true);
        }
    }

    /**
     * <p>
     * Description: 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     * </p>
     *
     * @param obj 参数
     * @param fieldName 名称
     * @param value 值
     */
    public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
    }

}

