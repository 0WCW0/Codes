package cn.itwanli.controller;

import cn.itwanli.pojo.Page;
import cn.itwanli.pojo.User;
import cn.itwanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/tologin")
    public String tologin(Model model){
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model, User user){
        User u = this.userService.login(user);

        if (u!=null){
            if (u.getType() == 0){
                model.addAttribute("user",u);
                model.addAttribute("msg","欢迎登录");
                return "admAll";
            }else if (u.getType()== 1){
                model.addAttribute("user",u);
                model.addAttribute("msg","欢迎登录");
                return "touserAll";
            }
        }else {
            model.addAttribute("msg","输入有误");
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        return "login";
    }

    @RequestMapping("/touserAll")
    public String touserAll(Model model){
        return "userAll";
    }

    @RequestMapping("/back")
    public String back(Model model){
        return "admAll";
    }

    @RequestMapping("/toregister")
    public String toregister(Model model){
        return "register";
    }

    @RequestMapping("/register")
    public String register(Model model,User user){
        user.setType(1);

        int r = this.userService.register(user);

        if (r>0){
                model.addAttribute("msg","注册成功");
                return "redirect:/user/tologin";
        }else {
            model.addAttribute("msg","输入有误！");
        }
        return "register";
    }


    @RequestMapping("/toforUser")
    public String toforUser(Model model,String pageNum){
        Page page = new Page();
        int pagenum,pagesize=5,startIndex,pageTital,recordsNum;

        if (pageNum==null || pageNum==""){
            pagenum =1;
        }else {
            pagenum =Integer.parseInt(pageNum);
        }
        startIndex = (pagenum-1)*pagesize;

        List<User> showlist = this.userService.showlist(startIndex);
        recordsNum =this.userService.pagecount();
        page.setRecordsNum(recordsNum);

        if (recordsNum%pagesize>0){
            pageTital=recordsNum/pagesize +1;
        }else {
            pageTital=recordsNum/pagesize;
        }
        page.setPageTitle(pageTital);
        page.setPageNum(pagenum);
        model.addAttribute("page",page);
        model.addAttribute("uList",showlist);

        return "forUser";
    }

    @RequestMapping("/toaddUser")
    public String toaddUser(Model model){
        return "addU";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model, User user){
        int u = this.userService.doAddU(user);
        return "redirect:/user/toforUser";
    }

    @RequestMapping("/toUpdUser")
    public String toUpdUser(Model model,int id){
        User user = this.userService.selByIdU(id);
        model.addAttribute("user",user);
        return "updUser";
    }

    @RequestMapping("/updUser")
    public String updUser(Model model, User user){
        int u = this.userService.doUpdU(user);
        return "redirect:/user/toforUser";
    }

    @RequestMapping("/delUser")
    public String delUser(Model model,int id){
        int u = this.userService.doDelU(id);
        return "redirect:/user/toforUser";
    }

    @RequestMapping("/selByLikeU")
    public String selByLikeU(Model model,String search){
        List<User> users = this.userService.selByLikeU(search);
        model.addAttribute("uList",users);
        return "forUser";
    }


}
