package cn.itwanli.controller;

import cn.itwanli.pojo.Boy;
import cn.itwanli.pojo.Page;
import cn.itwanli.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boy")
public class BoyController {
    @Autowired
    private BoyService boyService;

    public void setBoyService(BoyService boyService) {
        this.boyService = boyService;
    }

    @RequestMapping("/toforBoy")
    public String toforBoy(Model model,String pageNum){
        Page page = new Page();
        int pagenum,pagesize=5,startIndex,pageTital,recordsNum;

        if (pageNum==null || pageNum==""){
            pagenum =1;
        }else {
            pagenum =Integer.parseInt(pageNum);
        }
        startIndex = (pagenum-1)*pagesize;

        List<Boy> showlist = this.boyService.showlist(startIndex);
        recordsNum = this.boyService.pagecount();
        page.setRecordsNum(recordsNum);

        if (recordsNum%pagesize>0){
            pageTital=recordsNum/pagesize+1;
        }else {
            pageTital=recordsNum/pagesize;
        }
        page.setPageTitle(pageTital);
        page.setPageNum(pagenum);
        model.addAttribute("page",page);
        model.addAttribute("bList",showlist);

        return "forBoy";
    }

    @RequestMapping("/uforBoy")
    public String uforBoy(Model model,String pageNum){
        Page page = new Page();
        int pagenum,pagesize=5,startIndex,pageTital,recordsNum;

        if (pageNum==null || pageNum==""){
            pagenum =1;
        }else {
            pagenum =Integer.parseInt(pageNum);
        }
        startIndex = (pagenum-1)*pagesize;

        List<Boy> showlist = this.boyService.showlist(startIndex);
        recordsNum = this.boyService.pagecount();
        page.setRecordsNum(recordsNum);

        if (recordsNum%pagesize>0){
            pageTital=recordsNum/pagesize+1;
        }else {
            pageTital=recordsNum/pagesize;
        }
        page.setPageTitle(pageTital);
        page.setPageNum(pagenum);
        model.addAttribute("page",page);
        model.addAttribute("bList",showlist);

        return "toBoy";
    }

    @RequestMapping("/back")
    public String back(Model model){
        return "touserAll";
    }

    @RequestMapping("/toaddBoy")
    public String toaddBoy(Model model){
        return "addB";
    }
    @RequestMapping("/addBoy")
    public String addBoy(Model model, Boy boy){
        int b = this.boyService.doAddB(boy);
        return "redirect:/boy/toforBoy";
    }

    @RequestMapping("/toUpdBoy")
    public String toUpdBoy(Model model,int bid){
        Boy boy = this.boyService.selByIdB(bid);
        model.addAttribute("boy",boy);
        return "updBoy";
    }

    @RequestMapping("/updBoy")
    public  String updBoy(Model model, Boy boy){
        int b = this.boyService.doUpdB(boy);
        return "redirect:/boy/toforBoy";
    }

    @RequestMapping("/delBoy")
    public String delBoy(Model model,int bid){
        int b = this.boyService.doDelB(bid);
        return "redirect:/boy/toforBoy";
    }

    @RequestMapping("/selByLikeB")
    public String selByLikeB(Model model,String search){
        List<Boy> boys = this.boyService.selByLikeB(search);
        model.addAttribute("bList",boys);
        return "forBoy";
    }

    @RequestMapping("/toselByLikeB")
    public String toselByLikeB(Model model,String search){
        List<Boy> boys = this.boyService.selByLikeB(search);
        model.addAttribute("bList",boys);
        return "toBoy";
    }



}
