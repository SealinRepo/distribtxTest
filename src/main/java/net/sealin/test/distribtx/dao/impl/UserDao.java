package net.sealin.test.distribtx.dao.impl;

import net.sealin.test.distribtx.utils.MybatisUtil;
import net.sealin.test.distribtx.dao.BaseDao;
import net.sealin.test.distribtx.dao.TabUserMapper;
import net.sealin.test.distribtx.entity.TabUser;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Sealin
 * Created by Sealin on 2018-05-23.
 */
public class UserDao extends BaseDao implements TabUserMapper {
    private final SqlSession session;

    public UserDao(String datasourceId) {
        session = MybatisUtil.getSession(datasourceId);
    }

    @Override
    public int deleteByPrimaryKey(Integer id, String name) {
        return 0;
    }

    @Override
    public int insert(TabUser record) {
        return session.insert(getStateMent(), record);
    }

    @Override
    public TabUser selectByPrimaryKey(Integer id, String name) {
        return null;
    }

    @Override
    public List<TabUser> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(TabUser record) {
        return 0;
    }

    public void rollBack() {
        session.rollback();
    }

    public void commit() {
        session.commit();
    }

    public void close() {
        session.close();
    }
}
