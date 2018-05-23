package net.sealin.test.distribtx.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Sealin
 * Created by Sealin on 2018-05-23.
 */
public class MybatisUtil {
    private static SqlSessionFactory factory;

    private static void init(String envid) {
        String config = "mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(inputStream, envid);
        } catch (IOException e) {
            // ignored
        }
    }

    public static SqlSession getSession(String datasourceId) {
        init(datasourceId);
        return factory.openSession();
    }
}
