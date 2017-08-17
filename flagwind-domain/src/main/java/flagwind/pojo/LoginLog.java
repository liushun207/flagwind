package flagwind.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志.
 */
public class LoginLog implements Serializable
{
    private Long logid;

    private Long userid;

    private String ip;

    private Date logindatetime;

    /**
     * Id.
     *
     * @return the logid
     */
    public Long getLogid()
    {
        return logid;
    }

    /**
     * Sets logid.
     *
     * @param logid the logid
     */
    public void setLogid(Long logid)
    {
        this.logid = logid;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public Long getUserid()
    {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    /**
     * Gets ip.
     *
     * @return the ip
     */
    public String getIp()
    {
        return ip;
    }

    /**
     * Sets ip.
     *
     * @param ip the ip
     */
    public void setIp(String ip)
    {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * Gets logindatetime.
     *
     * @return the logindatetime
     */
    public Date getLogindatetime()
    {
        return logindatetime;
    }

    /**
     * Sets logindatetime.
     *
     * @param logindatetime the logindatetime
     */
    public void setLogindatetime(Date logindatetime)
    {
        this.logindatetime = logindatetime;
    }
}