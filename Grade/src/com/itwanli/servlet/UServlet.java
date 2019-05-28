package com.itwanli.servlet;

import com.itwanli.bean.Page;
import com.itwanli.bean.User;
import com.itwanli.dao.impl.UserDaoImpl;
import com.itwanli.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns =
        {"/TMload.do","/TMM.do","/SMload.do","/SMM.do","/login.do","/logout.do","/insU.do","/mainU.do","/listU.do","/delU.do","/loadU.do","/updU.do","/searchU.do","/infoU.do"})
public class UServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        UserDaoImpl dao = new UserDaoImpl();

        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));//截取位置

        //login.do
        if (action.equals("login")) {

            //获取用户填写的信息
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //表单验证
            User currentUser = new User();
            currentUser.setUsername(username);
            currentUser.setPassword(password);

            UserServiceImpl usi = new UserServiceImpl();
            HttpSession session = request.getSession();

            int c = usi.login(currentUser);

            if (c > 0) {    // 代表登录成功,跳转页面

                User u = new User();
                UserDaoImpl ad = new UserDaoImpl();
                //更加账号和密码查找出读者的信息
                u = ad.getAdminInfo(username,password);
                //将id存入session中
               session.setAttribute("currentUser", u);

                //设置session的失效时间
//                session.setMaxInactiveInterval(6000);

                if(u.getType() == 0){
                    request.getRequestDispatcher("xuan.jsp").forward(request,response);   // 页面重定向
                }else if(u.getType() == 1){
                    request.getRequestDispatcher("mainSS.jsp").forward(request,response);// 页面重定向
                }else if(u.getType() == 2){
                    request.getRequestDispatcher("mainTT.jsp").forward(request,response);   // 页面重定向
                }

            } else {          // 登录失败,跳转到登录,请求转发
                String msg = "用户名或者密码输入有误,请检查";
                session.setAttribute("msg", msg);

                request.getRequestDispatcher("login.jsp").forward(request, response);    // 请求转发
            }

            //logout.do
            }else if (action.equals("logout")) {
                // 清除当前用户的session
                request.getSession().invalidate();  // 清除数据
                response.sendRedirect("login.jsp"); // 安全退出重定向到登录

            //mainU.do
            }else if (action.equals("mainU")){
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

            List<User> upmlist = dao.findByPageNum(startIndex);

            session.setAttribute("upmList",upmlist);//列表
            session.setAttribute("page",page);//页面

            request.getRequestDispatcher("mainU.jsp").forward(request,response);


            //listU.do
        }else if(action.equals("listU")){
            Page page = new Page();
            int pagenum,pagesize=3,startIndex,pageTital,recordsNum;

            String pageNum = request.getParameter("pageNum");
            if(pageNum == null || pageNum==""){
                page.setPageNum(1); // 设置当前页默认为第1页
            }else{
                page.setPageNum(Integer.parseInt(pageNum)); // 设置为你传递的页码
            }
            startIndex = (page.getPageNum()-1)*pagesize;

            List<User> upmlist = dao.findByPageNum(startIndex);

            recordsNum = dao.getRecordsNum();
            page.setRecordsNum(recordsNum);

            if(recordsNum%pagesize>0){
                pageTital=recordsNum/pagesize+1;
            }else {
                pageTital=recordsNum/pagesize;
            }
            page.setPageTitle(pageTital);
            page.setPageNum(Integer.parseInt(pageNum));

            request.setAttribute("page",page);
            request.setAttribute("upmList",upmlist);

            request.getRequestDispatcher("mainU.jsp").forward(request,response);


            //insU.do
        }else if(action.equals("insU")){
            User u = new User();
            u.setUsername(request.getParameter("username"));
            u.setPassword(request.getParameter("password"));
            u.setType(Integer.parseInt(request.getParameter("type")));

            int count = dao.doInsU(u);
            if(count>0){
                System.out.println("新增成功!");
            }else{
                System.out.println("新增失败!");
            }

//            response.sendRedirect("listU.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainU.jsp").forward(request,response);



            //delU.do
        }else if(action.equals("delU")){
            HttpSession session = request.getSession();

            //获取所要删除的id
            int did = Integer.parseInt(request.getParameter("id"));
            User u = (User) session.getAttribute("currentUser");

            //获取存到session的id
            int Uid =u.getId();

            if (Uid == did){
                System.out.println("删除失败!");
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }else {
                int count = dao.doDelU(did);
                if(count>0){
                    System.out.println("删除成功!");
                }else{
                    System.out.println("删除失败!");
                }

            }
//            response.sendRedirect("listU.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainU.jsp").forward(request,response);



            //loadU.do
        } else if(action.equals("loadU")){
            int id = Integer.parseInt(request.getParameter("id"));
            User u = dao.doLoadU(id);
            request.setAttribute("u",u);

            request.getRequestDispatcher("updU.jsp").forward(request,response);


            //SMload.do
        }else if (action.equals("SMload")){
            int id = Integer.parseInt(request.getParameter("id"));
            User u = dao.doLoadSM(id);
            request.setAttribute("u",u);

            request.getRequestDispatcher("SMM.jsp").forward(request,response);

            //TMload.do
        }else if (action.equals("TMload")){
            int id = Integer.parseInt(request.getParameter("id"));
            User u = dao.doLoadU(id);
            request.setAttribute("u",u);

            request.getRequestDispatcher("TMM.jsp").forward(request,response);


        }
        //updU.do
        else if(action.equals("updU")){
            User u = new User();
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setUsername(request.getParameter("username"));
            u.setPassword(request.getParameter("password"));
            u.setType(Integer.parseInt(request.getParameter("type")));

            int count = dao.doUpdU(u);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

//            response.sendRedirect("listU.do");   // 重定向到列表页面
            request.getRequestDispatcher("mainU.jsp").forward(request,response);


            //SMM.do
        }else if (action.equals("SMM")){
            User u = new User();
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setUsername(request.getParameter("username"));
            u.setPassword(request.getParameter("password"));

            int count = dao.doUpdM(u);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

//            response.sendRedirect("mainSS.jsp");   // 重定向到列表页面
            request.getRequestDispatcher("mainSS.jsp").forward(request,response);

            //TMM.do
        }else if (action.equals("TMM")){
            User u = new User();
            u.setId(Integer.parseInt(request.getParameter("id")));
            u.setUsername(request.getParameter("username"));
            u.setPassword(request.getParameter("password"));

            int count = dao.doUpdM(u);
            if(count>0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

//            response.sendRedirect("mainTTT.jsp");   // 重定向到列表页面
            request.getRequestDispatcher("mainTTT.jsp").forward(request,response);


        }
        //searchU.do
        else if (action.equals("searchU")){
            String username=request.getParameter("searchU");
            List<User> upmList=dao.doSelByLikeU(username);
            request.setAttribute("upmList",upmList);

            request.getRequestDispatcher("mainU.jsp").forward(request,response);


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            this.doPost(request, response);
        }
}
