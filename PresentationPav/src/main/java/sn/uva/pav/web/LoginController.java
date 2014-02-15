package sn.uva.pav.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class LoginController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginForm(HttpServletRequest request, ModelMap modelMap)
    {
        if (request.getAttribute("shiroLoginFailure") != null)
        {
            String exception = (String) request.getAttribute("shiroLoginFailure");
            if (exception.endsWith("UnknownAccountException") || exception.endsWith("IncorrectCredentialsException"))
            {
                modelMap.put("userNotFound", true);
            }
            else if (exception.endsWith("LockedAccountException"))
            {
                modelMap.put("userLocked", true);
            }
            else
            {
                modelMap.put("error", true);
            }
        }
        Subject currentSubject = SecurityUtils.getSubject();

        return "login";
    }
    
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(){
        Subject currentSubject = SecurityUtils.getSubject();

        if(currentSubject.isAuthenticated() || currentSubject.isRemembered()){
            //logger.info(String.format("User [%s] is logging out from the app.", currentSubject.getPrincipal()));
            currentSubject.logout();
        }
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/nonautorise", method = RequestMethod.GET)
    public ModelAndView unauthorized(){
        //return new ModelAndView("error403");
        return new ModelAndView("redirect:/#!erreur");
    	//return new ModelAndView("redirect:/nonautorise");
    }
}
