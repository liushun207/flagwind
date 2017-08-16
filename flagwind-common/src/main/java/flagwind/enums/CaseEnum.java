package flagwind.enums;

/**
 * 表示`大小写`枚举.
 */
public enum CaseEnum
{
    /**
     * 大写.
     */
    UPPER
    {
        int getValue()
        {
            return 0;
        }
    },

    /**
     * 小写.
     */
    LOWER
    {
        int getValue()
        {
            return 1;
        }
    }
}
