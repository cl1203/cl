package com.cl.genertor;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;

public class OmGenertor {
    //项目路径
    private static String canonicalPath = "";
    //基本包名
    private static String basePackage = "com.cl.om";
    //作者
    private static String authorName = "chenlong";
    //要生成的表名
    private static String[] tables = {"student"};
    //table前缀
    private static String prefix = "";
    //数据库类型
    private static DbType dbType = DbType.MYSQL;
    //数据库配置四要素
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/om?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "chen123";

    public static void main(String[] orgs){
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //获取项目路径
        try{
            canonicalPath = new File("").getCanonicalPath();
        }catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 数据源配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(dbType);
        dsc.setDriverName(driverName);
        dsc.setUrl(url);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                    return DbColumnType.BOOLEAN;
                }
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        mpg.setDataSource(dsc);

        /*
         * 全局配置
         */
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(canonicalPath + "/src/main/java");//输出目录
        gc.setFileOverride(true);//是否覆盖文件
        gc.setActiveRecord(true);//开启activeRecord模式
        gc.setEnableCache(false);//xml 二级缓存
        gc.setBaseResultMap(true);//xml ResultMap
        gc.setBaseColumnList(true);//xml columnList
        gc.setOpen(false); // 生成后打开文件夹
        gc.setAuthor(authorName);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        /*gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("MP%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");*/
        mpg.setGlobalConfig(gc);

        /*
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[] {prefix});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tables); // 需要生成的表
        mpg.setStrategy(strategy);

        /*
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackage);
        //pc.setModuleName("config");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<FileOutConfig>();
        fileOutList.add(new FileOutConfig("/templates/dao.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return canonicalPath + "/src/main/resources/dao/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(fileOutList);
        mpg.setCfg(cfg);*/
        //指定模板引擎 默认是VelocityTemplateEngine ，需要引入相关引擎依赖
        //gen.setTemplateEngine(new FreemarkerTemplateEngine());
        // 执行生成
        mpg.execute();
        // 打印注入设置【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
