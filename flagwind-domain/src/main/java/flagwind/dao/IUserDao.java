package flagwind.dao;

import flagwind.pojo.User;
import org.apache.ibatis.annotations.Param;
import sun.security.util.Password;

/**
 * 用户db接口.
 */
public interface IUserDao
{
    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(User record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(User record);

    /**
     * Select by primary key user.
     *
     * @param id the id
     * @return the user
     */
    User selectByPrimaryKey(Long id);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过用户名、密码获取用户.
     *
     * @param name 用户名
     * @param password 密码
     * @return User
     */
    User selectByPassword(@Param("name") String name, @Param("password") String password);
}