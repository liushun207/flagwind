package flagwind.DTO;

import flagwind.annotations.CheckCase;
import flagwind.enums.CaseEnum;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The type Student.
 */
public class Student implements Serializable
{
    @NotNull(message = "名字不能为空")
    private String name;

    @Size(min = 6, max = 30, message = "地址应该在6-30字符之间")
    private String address;

    @DecimalMax(value = "100.00", message = "体重有些超标哦")
    @DecimalMin(value = "60.00", message = "多吃点饭吧")
    private BigDecimal weight;

    private String friendName;

    @AssertTrue
    private Boolean isHaveFriend()
    {
        return friendName != null ? true : false;
    }

    @Future(message = "生日必须在当前实践之前")
    private Date birthday;

    @Pattern(regexp = "^(.+)@(.+)$", message = "邮箱的格式不合法")
    private String email;

    /**
     * 自定义验证
     */
    @CheckCase(value = CaseEnum.LOWER,message = "名字的拼音需要小写")
    private String spellName;

    /**
     * Sets spell name.
     *
     * @param spellName the spell name
     */
    public void setSpellName(String spellName)
    {
        this.spellName = spellName;
    }

    /**
     * Gets spell name.
     *
     * @return the spell name
     */
    public String getSpellName()
    {
        return spellName;
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
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public BigDecimal getWeight()
    {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    /**
     * Gets friend name.
     *
     * @return the friend name
     */
    public String getFriendName()
    {
        return friendName;
    }

    /**
     * Sets friend name.
     *
     * @param friendName the friend name
     */
    public void setFriendName(String friendName)
    {
        this.friendName = friendName;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday()
    {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
}