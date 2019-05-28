package cn.itwanli.controller;

import cn.itwanli.pojo.Lady;
import cn.itwanli.pojo.Page;
import cn.itwanli.service.LadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lady")
public class LadyController {
    @Autowired
    private LadyService ladyService;

    public void setLadyService(LadyService ladyService) {
        this.ladyService = ladyService;
    }

    @RequestMapping("/toforLady")
    public String toforLady(Model model,String pageNum){
        Page page = new Page();
        int pagenum,pagesize=5,startIndex,pageTital,recordsNum;

        if (pageNum==null || pageNum==""){
            pagenum =1;
        }else {
            pagenum =Integer.parseInt(pageNum);
        }
        startIndex = (pagenum-1)*pagesize;

        List<Lady> showlist = this.ladyService.showlist(startIndex);
        recordsNum = this.ladyService.pagecount();
        page.setRecordsNum(recordsNum);

        if (recordsNum%pagesize>0){
            pageTital=recordsNum/pagesize+1;
        }else {
            pageTital=recordsNum/pagesize;
        }
        page.setPageTitle(pageTital);
        page.setPageNum(pagenum);
        model.addAttribute("page",page);
        model.addAttribute("lList",showlist);

        return "forLady";
    }

    @RequestMapping("/uforLady")
    public String uforLady(Model model,String pageNum){
        Page page = new Page();
        int pagenum,pagesize=5,startIndex,pageTital,recordsNum;

        if (pageNum==null || pageNum==""){
            pagenum =1;
        }else {
            pagenum =Integer.parseInt(pageNum);
        }
        startIndex = (pagenum-1)*pagesize;

        List<Lady> showlist = this.ladyService.showlist(startIndex);
        recordsNum = this.ladyService.pagecount();
        page.setRecordsNum(recordsNum);

        if (recordsNum%pagesize>0){
            pageTital=recordsNum/pagesize+1;
        }else {
            pageTital=recordsNum/pagesize;
        }
        page.setPageTitle(pageTital);
        page.setPageNum(pagenum);
        model.addAttribute("page",page);
        model.addAttribute("lList",showlist);

        return "toLady";
    }

    @RequestMapping("/back")
    public String back(Model model){
        return "touserAll";
    }

    @RequestMapping("/toaddLady")
    public String toaddLady(Model model){
        return "addL";
    }

    @RequestMapping("/addLady")
    public String addLady(Model model, Lady lady){
        int l = this.ladyService.doAddL(lady);
        return "redirect:/lady/toforLady";
    }

    @RequestMapping("/toUpdLady")
    public String toUpdLady(Model model,int lid){
        Lady lady = this.ladyService.selByIdL(lid);
        model.addAttribute("lady",lady);
        return "updLady";
    }

    @RequestMapping("/updLady")
    public  String updLady(Model model, Lady lady){
        int l = this.ladyService.doUpdL(lady);
        return "redirect:/lady/toforLady";
    }

    @RequestMapping("/delLady")
    public String delLady(Model model,int lid){
        int l = this.ladyService.doDelL(lid);
        return "redirect:/lady/toforLady";
    }

    @RequestMapping("/selByLikeL")
    public String selByLikeL(Model model,String search){
        List<Lady> ladies = this.ladyService.selByLikeL(search);
        model.addAttribute("lList",ladies);
        return "forLady";
    }

    @RequestMapping("/toselByLikeL")
    public String toselByLikeL(Model model,String search){
        List<Lady> ladies = this.ladyService.selByLikeL(search);
        model.addAttribute("lList",ladies);
        return "toLady";
    }

}
