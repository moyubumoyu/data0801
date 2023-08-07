package test01.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;//


    static {
        Properties pro = new Properties();
        InputStream fis = JDBCUtils.class.getClassLoader().getResourceAsStream("durid.properties");
        try {
            pro.load(fis);
            dataSource= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * 返回连接池
     * */
    public static DataSource getDataSource() {

        return dataSource;
    }
}
