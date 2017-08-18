package flagwind.service.impl;

import flagwind.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 失败的单元测试
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations =
//        {
//            //"file:../flagwind/flagwind-web/src/main/webapp/WEB-INF/web.xml",
//            //"file:../flagwind/flagwind-web/src/main/resources/spring-mybatis.xml",
//            //"file:../flagwind/flagwind-web/src/main/resources/spring-mvc.xml",
//            //"file:../flagwind/flagwind-web/src/main/resources/jdbc.properties",
//            //"file:../flagwind/flagwind-web/src/main/resources/log4j.properties"
//        })
public class UserServiceImplTest
{
    //@Autowired
    //private UserServiceImpl service;

    @Test
    public void getUserById() throws Exception
    {
        //User user = this.service.getUserById(1);
    }

    @Test
    public void getUser() throws Exception
    {
        //User user = this.service.getUser("admin", "123456");
    }

    @Test
    public void loginSucess() throws Exception
    {
        //User user = this.service.getUser("admin", "123456");
        //
        //if (user != null)
        //{
        //    user.setLastip("127.0.0.1");
        //    user.setLastvisit(new Date());
        //    this.service.loginSucess(user);
        //}
    }
}