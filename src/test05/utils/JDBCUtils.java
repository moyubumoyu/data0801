package test05.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;
    static {
        Properties properties = new Properties();
        InputStream fis = JDBCUtils.class.getClassLoader().getResourceAsStream("durid.properties");
        try{
            properties.load(fis);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
        return dataSource;
    }

}
