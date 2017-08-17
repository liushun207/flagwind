package flagwind.service.impl;

import flagwind.dao.ILoginLogDao;
import flagwind.dao.IUserDao;
import flagwind.pojo.LoginLog;
import flagwind.pojo.User;
import flagwind.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户服务.
 */
@Service("userService")
public class UserServiceImpl implements IUserService
{
    /**
     * 用户dao
     */
    @Resource
    private IUserDao userDao;

    /**
     * 用户登录日志dao
     */
    @Resource
    private ILoginLogDao loginLogDao;

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    public User getUserById(long userId)
    {
        return this.userDao.selectByPrimaryKey(userId);
    }

    /**
     * 获取用户.
     *
     * @param name     名称
     * @param password 密码
     * @return the user
     */
    public User getUser(String name, String password)
    {
        return this.userDao.selectByPassword(name, password);
    }

    /**
     * 登录成功.
     *
     * @param user the user
     */
    @Transactional
    public void loginSucess(User user)
    {
        user.setCredits(5 + user.getCredits());

        LoginLog loginLog = new LoginLog();
        loginLog.setUserid(user.getId());
        loginLog.setIp(user.getLastip());
        loginLog.setLogindatetime(user.getLastvisit());

        this.userDao.updateByPrimaryKey(user);
        this.loginLogDao.insert(loginLog);
    }
}
