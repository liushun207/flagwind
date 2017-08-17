package flagwind.dao;

import flagwind.pojo.LoginLog;

/**
 * 登录日志db接口.
 */
public interface ILoginLogDao
{

    /**
     * Delete by primary key int.
     *
     * @param logid the logid
     * @return the int
     */
    int deleteByPrimaryKey(Long logid);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(LoginLog record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(LoginLog record);

    /**
     * Select by primary key login log.
     *
     * @param logid the logid
     * @return the login log
     */
    LoginLog selectByPrimaryKey(Long logid);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(LoginLog record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(LoginLog record);
}