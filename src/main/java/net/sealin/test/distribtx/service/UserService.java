package net.sealin.test.distribtx.service;

import net.sealin.test.distribtx.dao.impl.UserDao;
import net.sealin.test.distribtx.entity.TabUser;

/**
 * @author Sealin
 * Created by Sealin on 2018-05-23.
 */
public class UserService {
    UserDao db1UserDao;
    UserDao db2UserDao;

    public UserService() {
        db1UserDao = new UserDao("db1");
        db2UserDao = new UserDao("db2");
    }

    public void insert(TabUser user) {
        int db1Affected = 0;
        int db2Affected;
        try {
            db1Affected = db1UserDao.insert(user);
            db2Affected = db2UserDao.insert(user);
            if (db1Affected > 0 && db1Affected == db2Affected) {
                System.out.println("同时新增成功,开始提交:");
                db1UserDao.commit();
                db2UserDao.commit();
                System.out.println("提交成功");
            } else if (db1Affected == 0) {
                System.out.println("DB1写入失败,数据回滚");
                rollBack();
            } else {
                System.out.println("DB2写入失败,数据回滚");
                rollBack();
            }
        } catch (Exception e) {
            System.out.println(String.format("%s 写入失败,数据回滚", db1Affected > 0 ? "DB2" : "DB1"));
            rollBack();
        } finally {
            db1UserDao.close();
            db2UserDao.close();
        }
    }

    private void rollBack() {
        db1UserDao.rollBack();
        db2UserDao.rollBack();
    }
}
