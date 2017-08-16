package flagwind.service.impl;

import flagwind.dao.IUserDao;
import flagwind.pojo.User;
import flagwind.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The type User service.
 */
@Service("userService")
public class UserServiceImpl implements IUserService
{
    /**
     *
     */
    @Resource
    private IUserDao userDao;

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
}
