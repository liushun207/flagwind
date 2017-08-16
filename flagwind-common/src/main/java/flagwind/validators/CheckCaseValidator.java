package flagwind.validators;

import flagwind.annotations.CheckCase;
import flagwind.enums.CaseEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 检查大小写注解的约束
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String>
{
    /**
     * 枚举
     */
    private CaseEnum caseEnum;

    /**
     * 初始化
     */
    public void initialize(CheckCase constraintAnnotation)
    {
        this.caseEnum = constraintAnnotation.value();
    }

    /**
     * 是否有效
     */
    public boolean isValid(String object, ConstraintValidatorContext constraintContext)
    {
        if (object == null)
            return true;

        if (caseEnum == caseEnum.UPPER)
            return object.equals(object.toUpperCase());
        else
            return object.equals(object.toLowerCase());
    }
}
