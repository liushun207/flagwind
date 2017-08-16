package flagwind.service;

import flagwind.pojo.User;

/**
 * The interface User service.
 */
public interface IUserService
{
    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    User getUserById(long userId);
}
