package com.cl.comm.constants;

import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName CommonConstants
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/3 15:52
 * @Version 1.0
 **/
public class CommonConstants {
    public static final SerializerFeature[] FEATURES = new SerializerFeature[]{
            SerializerFeature.PrettyFormat,
            SerializerFeature.WriteDateUseDateFormat,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.DisableCircularReferenceDetect,
            SerializerFeature.IgnoreNonFieldGetter};
}
