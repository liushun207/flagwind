package flagwind.annotations;

import flagwind.enums.CaseEnum;
import flagwind.validators.CheckCaseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 检查大小写注解.
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class) // 约束
@Documented
public @interface CheckCase
{
    /**
     * Message 消息.
     *
     * @return the string
     */
    String message() default "{flagwind.constraints.checkcase}";

    /**
     * Groups class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] groups() default {};

    /**
     * Payload class [ ].
     *
     * @return the class [ ]
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Value case enum.
     *
     * @return the case enum
     */
    CaseEnum value();
}
