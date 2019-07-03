package com.cl.comm.excel;

/**
 * @ClassName ExcelResources
 * @Description 用来在对象的get方法上加入的annotation，通过该annotation说明某个属性所对应的标题.
 * @Author 陈龙
 * @Date 2019/7/3 15:55
 * @Version 1.0
 **/
public @interface ExcelResources {

    /**
     * <p>
     * Description: 列所在的位置.
     * </p>
     *
     */
    int columnIndex() default -1;

    /**
     * <p>
     * Description: 是否需要超链接.
     * </p>
     *
     */
    String link() default "";

    /**
     * <p>
     * Description: 是否必填.
     * </p>
     *
     *
     */
    boolean notNull() default false;

    /**
     * <p>
     * Description: 为空跳过本行.
     * </p>
     *
     * @return
     */
    boolean nullSkip() default false;

    /**
     * <p>
     * Description: 属性的标题名称.
     * </p>
     *
     * @return
     */
    String title() default "";

    /**
     * <p>
     * Description: 列标题必须存在.
     * </p>
     *
     * @return
     */
    boolean titleMustExist() default false;

    /**
     * <p>
     * Description: 是否使用Title自动匹配Excel所在的列.
     * </p>
     *
     * @return
     */
    boolean useTitle() default true;

}
