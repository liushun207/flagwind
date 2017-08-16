package flagwind;

import flagwind.DTO.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The type Student test.
 */
public class StudentTest implements Serializable
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        Student xiaoming = getBean();
        List<String> validate = validate(xiaoming);
        validate.forEach(row ->
        {
            System.out.println(row.toString());
        });

    }

    private static Student getBean()
    {
        Student bean = new Student();
        bean.setName(null);
        bean.setAddress("北京");
        bean.setBirthday(new Date());
        bean.setFriendName(null);
        bean.setWeight(new BigDecimal(30));
        bean.setSpellName("XIAOGANGFAN");
        bean.setEmail("xiaogangfan163.com");
        return bean;
    }

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /**
     * Validate list.
     *
     * @param <T> the type parameter
     * @param t   the t
     * @return the list
     */
    public static <T> List<String> validate(T t)
    {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations)
        {
            messageList.add(constraintViolation.getMessage());
        }
        return messageList;
    }
}
