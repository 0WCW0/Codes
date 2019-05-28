package com.itwanli.servlet;

import com.itwanli.bean.Page;
import com.itwanli.bean.Teacher;
import com.itwanli.dao.impl.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/insT.do","/mainT.do","/listT.do","/delT.do","/loadT.do","/updT.do","/searchT.do","/searchTT.do","/listTT.do","/mainTTT.do"})
public class TServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        TeacherDaoImpl dao = new TeacherDaoImpl();
        //获取当前传递过来的是哪个Servlet
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));//截取位置


        //mainT.do
        if (action.equals("mainT")){
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

            List<Teacher> tpmlist = dao.findByPageNum(startIndex);

            session.setAttribute("tpmList",tpmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainT.jsp").forward(request,response);


            //listT.do
        }else if(action.equals("listT")){
            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<Teacher> tpmlist = dao.findByPageNum(startIndex);

            recordsNum = dao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("tpmList",tpmlist);
            request.setAttribute("page",page);

            request.getRequestDispatcher("mainT.jsp").forward(request,response);


            //insT.do
        }else if(action.equals("insT")){
            Teacher t = new Teacher();
            t.setTname(request.getParameter("tname"));
            t.setTage(request.getParameter("tage"));

            int count = dao.doInsT(t);
            if(count>0){
                System.out.println("新增成功!");
            }else{
                System.out.println("新增失败!");
            }

//            response.sendRedirect("listT.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainT.jsp").forward(request,response);


            //delT.do
        }else if(action.equals("delT")){
            int tid = Integer.parseInt(request.getParameter("tid"));
            int count = dao.doDelT(tid);
            if(count>0){
                System.out.println("删除成功!");
            }else{
                System.out.println("删除失败!");
            }
//            response.sendRedirect("listT.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainT.jsp").forward(request,response);


            //loadT.do
        } else if(action.equals("loadT")){
            int tid = Integer.parseInt(request.getParameter("tid"));
            Teacher t = dao.doLoadT(tid);
            request.setAttribute("t",t);

            request.getRequestDispatcher("updT.jsp").forward(request,response);


            //updT.do
        }else if(action.equals("updT")){
            Teacher t = new Teacher();
            t.setTid(Integer.parseInt(request.getParameter("tid")));
            t.setTname(request.getParameter("tname"));
            t.setTage(request.getParameter("tage"));

            int count = dao.doUpdT(t);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

//            response.sendRedirect("listT.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainT.jsp").forward(request,response);


            //searchT.do
        }else if (action.equals("searchT")){
            String tname=request.getParameter("searchT");
            List<Teacher> tpmList=dao.doSelByLikeT(tname);
            request.setAttribute("tpmList",tpmList);

            request.getRequestDispatcher("mainT.jsp").forward(request,response);

            //searchTT.do
        }else if (action.equals("searchTT")){
            String ttname=request.getParameter("searchTT");
            List<Teacher> tttpmList = dao.doSelByLikeT(ttname);
            request.setAttribute("tttpmList",tttpmList);

            request.getRequestDispatcher("mainTTT.jsp").forward(request,response);


            //mainTTT
        }else if(action.equals("mainTTT")){
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

            List<Teacher> tttpmlist = dao.findByPageNum(startIndex);

            session.setAttribute("tttpmList",tttpmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainTTT.jsp").forward(request,response);


            //listTT.do
        }else if(action.equals("listTT")){
            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<Teacher> tttpmlist = dao.findByPageNum(startIndex);

            recordsNum = dao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("tttpmList",tttpmlist);
            request.setAttribute("page",page);

            request.getRequestDispatcher("mainTTT.jsp").forward(request,response);



        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);

    }
}
