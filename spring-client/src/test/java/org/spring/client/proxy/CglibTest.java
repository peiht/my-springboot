package org.spring.client.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class CglibTest {

    @Test
    public void testCglib(){
        DaoProxy daoProxy = new DaoProxy();
        DaoProxy1 daoProxy1 = new DaoProxy1();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallbacks(new Callback[]{daoProxy, daoProxy1, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new DaoFilter());

        Dao dao = (Dao) enhancer.create();
        dao.update();
        dao.select();

    }
}
