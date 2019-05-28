package com.itwanli.servlet;

import com.itwanli.bean.Grade;
import com.itwanli.bean.Page;
import com.itwanli.bean.Student;
import com.itwanli.bean.User;
import com.itwanli.dao.impl.GradeDaoImpl;
import com.itwanli.dao.impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns =
        {"/insSSS.do","/insS.do","/insSA.do","/mainS.do","/mainSS.do","/mainSSS.do","/listSA.do","/listSS.do","/listSSS.do","/delS.do","/loadS.do","/loadSSS.do","/updS.do","/updSSS.do","/searchS.do","/searchSS.do","/searchSSS.do","/gai.do"})
public class SServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        StudentDaoImpl dao = new StudentDaoImpl();
        GradeDaoImpl ddao = new GradeDaoImpl();
        //获取当前传递过来的是哪个Servlet
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));//截取位置


        //mainS.do
        if (action.equals("mainS")){
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

            List<Student> spmlist = dao.findByPageNum(startIndex);

            session.setAttribute("spmList",spmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainS.jsp").forward(request,response);

        }

        //listSA.do
        else if(action.equals("listSA")){
            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<Student> spmlist = dao.findByPageNum(startIndex);

            recordsNum = dao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("spmList",spmlist);
            request.setAttribute("page",page);

            request.getRequestDispatcher("mainS.jsp").forward(request,response);

        }

        //insS.do
        else if(action.equals("insS")){
            Student s = new Student();
            s.setSname(request.getParameter("sname"));
            s.setSage(request.getParameter("sage"));
            s.setCl(request.getParameter("cl"));

            if (dao.selByName(s)>0){
                request.setAttribute("msgg","学生重复");
                request.getRequestDispatcher("insS.jsp").forward(request,response);
            }else {
                int count = dao.doInsS(s);
                if(count>0){
                    System.out.println("新增成功!");
                }else{
                    System.out.println("新增失败!");
                }
            }


//            response.sendRedirect("listSA.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainS.jsp").forward(request,response);

        }

        //insSA.do
        else if(action.equals("insSA")){
            Grade sss = new Grade();
            sss.setSname(request.getParameter("sname"));
            sss.setCname(request.getParameter("cname"));
            sss.setGrade(request.getParameter("grade"));

            int count = ddao.doInsG(sss);
            if(count>0){
                System.out.println("新增成功!");
            }else{
                System.out.println("新增失败!");
            }

//            response.sendRedirect("mainSSS.jsp");   // 重定向到列表页面
            request.getRequestDispatcher("mainSSS.jsp").forward(request,response);

        }

        //delS.do
        else if(action.equals("delS")){
            int sid = Integer.parseInt(request.getParameter("sid"));
            int count = dao.doDelS(sid);
            if(count>0){
                System.out.println("删除成功!");
            }else{
                System.out.println("删除失败!");
            }
//            response.sendRedirect("listS.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainS.jsp").forward(request,response);

        }

        //loadS.do
        else if(action.equals("loadS")){
            int sid = Integer.parseInt(request.getParameter("sid"));
            Student s = dao.doLoadS(sid);
            request.setAttribute("s",s);

            request.getRequestDispatcher("updS.jsp").forward(request,response);

        }

        //loadSSS.do
        else if (action.equals("loadSSS")){
            int sid = Integer.parseInt(request.getParameter("sid"));
            Student sss = dao.doLoadS(sid);
            request.setAttribute("sss",sss);

            request.getRequestDispatcher("updSSS.jsp").forward(request,response);

        }

        //updS.do
        else if(action.equals("updS")){
            Student s = new Student();
            s.setSid(Integer.parseInt(request.getParameter("sid")));
            s.setSname(request.getParameter("sname"));
            s.setSage(request.getParameter("sage"));
            s.setCl(request.getParameter("cl"));

            int count = dao.doUpdS(s);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

//            response.sendRedirect("listS.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainS.jsp").forward(request,response);

        }

        //updSSS.do
        else if (action.equals("updSSS")){
            Student sss = new Student();
            sss.setSid(Integer.parseInt(request.getParameter("sid")));
            sss.setSname(request.getParameter("sname"));
            sss.setSage(request.getParameter("sage"));
            sss.setCl(request.getParameter("cl"));

            int count = dao.doUpdS(sss);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

            response.sendRedirect("listSSS.do");   // 重定向到列表页面

        }

        //searchS.do
        else if (action.equals("searchS")){
            String sname=request.getParameter("searchS");
            List<Student> spmList=dao.doSelByLikeS(sname);
            request.setAttribute("spmList",spmList);

            request.getRequestDispatcher("mainS.jsp").forward(request,response);

        }

        //searchSSS.do
        else if (action.equals("searchSSS")){
            String sssname=request.getParameter("searchSSS");
            List<Grade> ssspmList = ddao.doSelByLikeG(sssname);
            request.setAttribute("ssspmList",ssspmList);

            request.getRequestDispatcher("mainSSS.jsp").forward(request,response);

        }

        //searchSS.do
        else if (action.equals("searchSS")){
            String ssname=request.getParameter("searchSS");
            List<Grade> sspmList = ddao.doSelByLikeG(ssname);
            request.setAttribute("sspmList",sspmList);

            request.getRequestDispatcher("mainSS.jsp").forward(request,response);

        }

        //mainSSS
        else if(action.equals("mainSSS")){
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

            List<Grade> ssspmlist = ddao.findByPageNum(startIndex);

            session.setAttribute("ssspmList",ssspmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainSSS.jsp").forward(request,response);

        }

        //mainSS
        else if(action.equals("mainSS")){
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

            List<Student> sspmlist = dao.findByPageNum(startIndex);

            session.setAttribute("sspmList",sspmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainSS.jsp").forward(request,response);

        }

        //listSSS.do
        else if(action.equals("listSSS")){

            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<Grade> ssspmlist = ddao.findByPageNum(startIndex);

            recordsNum = ddao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("ssspmList",ssspmlist);
            request.setAttribute("page",page);

            request.getRequestDispatcher("mainSSS.jsp").forward(request,response);

        }

        //listSS.do
        else if (action.equals("listSS")){
            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<Grade> sspmlist = ddao.findByPageNum(startIndex);

            recordsNum = dao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("sspmList",sspmlist);
            request.setAttribute("page",page);

            request.getRequestDispatcher("mainSS.jsp").forward(request,response);

        }

        //gai.do
        else if (action.equals("gai.do")){

//            PrintWriter out = response.getWriter();

            //这里为了简单，设置了tip，用来区分是修改密码功能，还是修改个人资料的功能，tip=1为修改密码
            int tip = Integer.parseInt(request.getParameter("tip"));

            HttpSession session = request.getSession();
            User u = new User();
            String id = (String) session.getAttribute("id");

            //通过id获取到登录人员信息
            u = dao.get_AidInfo2(id);
            //修改密码
            if(tip==1){
                //获取到输入的旧密码，新密码
                String password = request.getParameter("password");
                String password2 = request.getParameter("password2");
                //获取读者数据表中的密码
                String old_password = u.getPassword();
                //对旧密码进行比较，如果相同就修改，不相同就直接退出
                if(old_password.equals(password)){
                    dao.doUpdSU(u.getId(),u.getUsername(),password2);
                    response.sendRedirect("mainSS.jsp");
                }else{
                     response.sendRedirect("login.jsp");
                }
            }


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
