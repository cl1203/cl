package com.cl.comm.excel;

/**
 * @ClassName ExcelHeader
 * @Description 用来存储Excel列标题的对象，通过该对象可以获取列标题和方法的对应关系.
 * @Author 陈龙
 * @Date 2019/7/3 15:55
 * @Version 1.0
 **/
public class ExcelHeader {
    /**
     * <p>
     * Field title: excel的列标题名称.
     * </p>
     */
    private String title;

    /**
     * <p>
     * Field titleColumnIndex: excel的列标题所在的列索引.
     * </p>
     */
    private int titleColumnIndex;

    /**
     * <p>
     * Field methodName: 说对应方法名称.
     * </p>
     */
    private String methodName;

    /**
     * <p>
     * Field returnClazz: 方法的类型.
     * </p>
     */
    private Class<?> returnClazz;

    /**
     * <p>
     * Field link: 是否需要超链接.
     * </p>
     */
    private String link;

    /**
     * <p>
     * Field notNull: 是否必填.
     * </p>
     */
    private boolean notNull;

    /**
     * <p>
     * Field nullSkip: 为空是否跳过本行.
     * </p>
     */
    private boolean nullSkip;

    /**
     * <p>
     * Description: ExcelHeader.
     * </p>
     *
     * @param title 标题
     * @param methodName 方法名
     * @param returnClazz 返回类
     * @param link 链接
     * @param notNull 非空标识
     */
    public ExcelHeader(String title, String methodName, Class<?> returnClazz, String link, boolean notNull) {
        super();
        this.title = title;
        this.returnClazz = returnClazz;
        this.methodName = methodName;
        this.link = link;
        this.notNull = notNull;
    }

    /**
     * <p>
     * Description: getLink.
     * </p>
     *
     * @return link
     */
    public String getLink() {
        return this.link;
    }

    /**
     * <p>
     * Description: getMethodName.
     * </p>
     *
     * @return methodName
     */
    public String getMethodName() {
        return this.methodName;
    }

    /**
     * <p>
     * Description: getNotNull.
     * </p>
     *
     * @return notNull
     */
    public boolean getNotNull() {
        return this.notNull;
    }

    /**
     * <p>
     * Description: getReturnClazz.
     * </p>
     *
     * @return returnClazz
     */
    public Class<?> getReturnClazz() {
        return this.returnClazz;
    }

    /**
     * <p>
     * Description: getTitle.
     * </p>
     *
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * <p>
     * Description: getTitleColumnIndex.
     * </p>
     *
     * @return titleColumnIndex
     */
    public int getTitleColumnIndex() {
        return this.titleColumnIndex;
    }

    /**
     * <p>
     * Description: isNullSkip.
     * </p>
     *
     * @return nullSkip
     */
    public boolean isNullSkip() {
        return this.nullSkip;
    }

    /**
     * <p>
     * Description: setLink.
     * </p>
     *
     * @param link link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * <p>
     * Description: setMethodName.
     * </p>
     *
     * @param methodName methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * <p>
     * Description: setNotNull.
     * </p>
     *
     * @param notNull notNull
     */
    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    /**
     * <p>
     * Description: setNullSkip.
     * </p>
     *
     * @param nullSkip nullSkip
     */
    public void setNullSkip(boolean nullSkip) {
        this.nullSkip = nullSkip;
    }

    /**
     * <p>
     * Description: setReturnClazz.
     * </p>
     *
     * @param returnClazz returnClazz
     */
    public void setReturnClazz(Class<?> returnClazz) {
        this.returnClazz = returnClazz;
    }

    /**
     * <p>
     * Description: setTitle.
     * </p>
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <p>
     * Description: setTitleColumnIndex.
     * </p>
     *
     * @param titleColumnIndex titleColumnIndex
     */
    public void setTitleColumnIndex(int titleColumnIndex) {
        this.titleColumnIndex = titleColumnIndex;
    }

    @Override
    public String toString() {
        return "ExcelHeader [link=" + this.link + ", methodName=" + this.methodName + ", notNull=" + this.notNull
                + ", returnClazz=" + this.returnClazz + ", title=" + this.title + ", titleColumnIndex="
                + this.titleColumnIndex + "]";
    }
}
