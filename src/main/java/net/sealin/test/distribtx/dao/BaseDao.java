package net.sealin.test.distribtx.dao;

/**
 * @author Sealin
 * Created by Sealin on 2018-05-23.
 */
public abstract class BaseDao {
    private final String NAME_SPACE = this.getClass().getInterfaces()[0].getName();

    private String getMethodName() {
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        return s[3].getMethodName();
    }

    protected String getStateMent() {
        return String.format("%s.%s", NAME_SPACE, getMethodName());
    }
}
