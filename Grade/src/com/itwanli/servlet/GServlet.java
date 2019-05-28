package com.itwanli.servlet;

import com.itwanli.bean.Grade;
import com.itwanli.bean.Page;
import com.itwanli.dao.impl.GradeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns =
        {"/insG.do","/mainG.do","/listG.do","/delG.do","/loadG.do","/updG.do","/searchG.do"})
public class GServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        GradeDaoImpl dao = new GradeDaoImpl();
        //获取当前传递过来的是哪个Servlet
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));//截取位置


        //mainG.do
        if (action.equals("mainG")){
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            Page page = new Page();
            System.out.println(pageNum);
            HttpSession session = request.getSession();

            if (pageNum == null || pageNum=="") {
                page.setPageNum(1);//设置当前页为第一页
            }else {
                page.setPageNum(Integer.parseInt(pageNum));//设置为你传递的页码
            }

            startIndex = (page.getPageNum()-1)*pagesize;

            List<Grade> gpmlist = dao.findByPageNum(startIndex);

            session.setAttribute("gpmList",gpmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainG.jsp").forward(request,response);

        }

        //listG.do
        else if(action.equals("listG")){
            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<Grade> gpmlist = dao.findByPageNum(startIndex);

            recordsNum = dao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("gpmList",gpmlist);
            request.setAttribute("page",page);

            request.getRequestDispatcher("mainG.jsp").forward(request,response);

        }

        //insG.do
        else if(action.equals("insG")){
            Grade g = new Grade();
            g.setSname(request.getParameter("sname"));
            g.setCname(request.getParameter("cname"));
            g.setGrade(request.getParameter("grade"));

                int count = dao.doInsG(g);
                if(count>0){
                    System.out.println("新增成功!");
                }else{
                    System.out.println("新增失败!");
                }

//            response.sendRedirect("listSA.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainG.jsp").forward(request,response);

        }
        //delG.do
        else if(action.equals("delG")){
            int gid = Integer.parseInt(request.getParameter("gid"));
            int count = dao.doDelG(gid);
            if(count>0){
                System.out.println("删除成功!");
            }else{
                System.out.println("删除失败!");
            }
//            response.sendRedirect("listS.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainG.jsp").forward(request,response);

        }
        //loadG.do
        else if(action.equals("loadG")){
            int gid = Integer.parseInt(request.getParameter("gid"));
            Grade g = dao.doLoadG(gid);
            request.setAttribute("g",g);

            request.getRequestDispatcher("updG.jsp").forward(request,response);

        }
        //updG.do
        else if(action.equals("updG")){
            Grade g = new Grade();
            g.setGid(Integer.parseInt(request.getParameter("gid")));
            g.setSname(request.getParameter("sname"));
            g.setCname(request.getParameter("cname"));
            g.setGrade(request.getParameter("grade"));

            int count = dao.doUpdG(g);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

//            response.sendRedirect("listS.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainG.jsp").forward(request,response);

        }
        //searchG.do
        else if (action.equals("searchG")){
            String sname=request.getParameter("searchG");
            List<Grade> gpmList=dao.doSelByLikeG(sname);
            request.setAttribute("gpmList",gpmList);

            request.getRequestDispatcher("mainG.jsp").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
