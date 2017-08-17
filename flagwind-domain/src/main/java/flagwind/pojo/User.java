package flagwind.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户.
 */
public class User implements Serializable
{
    private Long id;

    private String name;

    private Integer credits;

    private String password;

    private Date lastvisit;

    private String lastip;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public Integer getCredits()
    {
        return credits;
    }

    /**
     * Sets credits.
     *
     * @param credits the credits
     */
    public void setCredits(Integer credits)
    {
        this.credits = credits;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }

    /**
     * Gets lastvisit.
     *
     * @return the lastvisit
     */
    public Date getLastvisit()
    {
        return lastvisit;
    }

    /**
     * Sets lastvisit.
     *
     * @param lastvisit the lastvisit
     */
    public void setLastvisit(Date lastvisit)
    {
        this.lastvisit = lastvisit;
    }

    /**
     * Gets lastip.
     *
     * @return the lastip
     */
    public String getLastip()
    {
        return lastip;
    }

    /**
     * Sets lastip.
     *
     * @param lastip the lastip
     */
    public void setLastip(String lastip)
    {
        this.lastip = lastip == null ? null : lastip.trim();
    }
}