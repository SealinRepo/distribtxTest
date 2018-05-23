package net.sealin.test;

import net.sealin.test.distribtx.entity.TabUser;
import net.sealin.test.distribtx.service.UserService;
import org.junit.Test;

/**
 * @author Sealin
 * Created by Sealin on 2018-05-23.
 */
public class ServiceTest {
    @Test
    public void testService() {
        TabUser user = new TabUser();
        user.setAge(18);
        user.setName("Sealin");
        UserService service = new UserService();
        service.insert(user);
    }
}
