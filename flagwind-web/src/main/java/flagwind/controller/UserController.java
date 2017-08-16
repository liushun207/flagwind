package flagwind.controller;

import flagwind.pojo.User;
import flagwind.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * The type User controller.
 */
@Controller
@RequestMapping("/user")
public class UserController
{
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public User helloMvc(long userId)
    {
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test() throws Exception
    {
        throw new Exception("测试异常捕捉");
        //return "123";
    }
}