package flagwind.controller;

import flagwind.infrastructure.LoginCommand;
import flagwind.pojo.User;
import flagwind.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 登录控制器.
 */
@Controller
@RequestMapping("/login")
public class LoginController
{
    @Resource
    private IUserService userService;

    /**
     * Login page string.
     *
     * @return the string
     */
    @RequestMapping(value = "/index.html")
    public String loginPage()
    {
        return "login";
    }

    /**
     * Login check model and view.
     *
     * @param request      the request
     * @param loginCommand the login command
     * @return the model and view
     */
    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand)
    {
        User user = userService.getUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (user == null)
        {
            return new ModelAndView("login", "error", "用户名或密码错误。");
        }
        else
        {
            user.setLastip(request.getLocalAddr());
            user.setLastvisit(new Date());
            userService.loginSucess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }
}
