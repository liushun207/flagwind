package flagwind.service;

import flagwind.pojo.LoginLog;
import flagwind.pojo.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface User service.
 */
public interface IUserService
{
    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    User getUserById(long userId);


    /**
     * 获取用户.
     *
     * @param name     名称
     * @param password 密码
     * @return the user
     */
    User getUser(String name, String password);

    /**
     * 登录成功.
     *
     * @param user the user
     */
    @Transactional
    void loginSucess(User user);
}
