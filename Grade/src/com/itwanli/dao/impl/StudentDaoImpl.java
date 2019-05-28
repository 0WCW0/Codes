package com.itwanli.dao.impl;

import com.itwanli.bean.Student;
import com.itwanli.bean.User;
import com.itwanli.dao.StudentDao;
import com.itwanli.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    @Override
    public List<Student> findByPageNum(int startIndex) {
//        int begin = (page.getPageNum()-1)*page.getPageSize();   // 当前页码数据从第几条开始
        List<Student> spmList = new ArrayList<>();

        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from student limit ?,3";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,startIndex);
            rs = pstm.executeQuery();

            while(rs.next()){
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSage(rs.getString("sage"));
                s.setCl(rs.getString("cl"));

                spmList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return spmList;
    }

    @Override
    public List<Student> findAll() {
        List<Student> spmList = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from student";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSage(rs.getString("sage"));
                s.setCl(rs.getString("cl"));

                spmList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return spmList;
    }

    @Override
    public int doInsS(Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "insert into student(sname,sage,cl) values(?,?,?)";

        int flag = 0;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,student.getSname());
            pstm.setString(2,student.getSage());
            pstm.setString(3,student.getCl());


            flag = pstm.executeUpdate();
            System.out.println("新增成功!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }


    @Override
    public int doDelS(int sid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "delete from student where sid=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,sid);
            flag = pstm.executeUpdate();
            System.out.println("删除成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flag;
    }

    @Override
    public int selByName(Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select count(*) from student where sname='"+student.getSname()+"' and cl='"+student.getCl()+"'";

        int i=0;
        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();


            if (rs.next()){
               i=rs.getInt("count(*)");
               return i;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public Student doLoadS(int sid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from student where sid=?";

        Student s = new Student();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,sid);
            rs = pstm.executeQuery();


            while(rs.next()){
                s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSage(rs.getString("sage"));
                s.setCl(rs.getString("cl"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return s;
    }

    @Override
    public int doUpdS(Student student) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "update student set sname='"+student.getSname()+"',sage='"+student.getSage()+"',cl='"+student.getCl()+"' where sid=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,student.getSid());

            flag = pstm.executeUpdate();
            System.out.println("更新成功!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return flag;
    }


    @Override
    public int getRecordsNum() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select count(*) as num from student";
        int num = 0;

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                num = rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public List<Student> doSelByLikeS(String sname) {
        List<Student> smpList=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        String sql="select * from student where sname like '%"+sname+"%'";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                Student s=new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSage(rs.getString("sage"));
                s.setCl(rs.getString("cl"));

                smpList.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return smpList;
    }

    public User get_AidInfo2(String id){
        User u = new User();
        Connection conn = DBUtil.getConn();
        String sql = "select * from user where id='"+id+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                DBUtil.closeConn(rs, stm, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public void doUpdSU(int id,String username, String password) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "update user set username=?,passwprd=? where id=?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.setInt(3,id);

            pstm.executeUpdate();
            System.out.println("更新成功!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.closeConn(rs,pstm,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
