package com.itwanli.dao.impl;

import com.itwanli.bean.Teacher;
import com.itwanli.dao.TeacherDao;
import com.itwanli.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    //全查
    @Override
    public List<Teacher> findAll() {
        List<Teacher> tpmList = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from teacher";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                Teacher t = new Teacher();
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                t.setTage(rs.getString("tage"));

                tpmList.add(t);
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

        return tpmList;
    }

    //新增
    @Override
    public int doInsT(Teacher teacher) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "insert into teacher(tname,tage) values(?,?)";

        int flag = 0;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,teacher.getTname());
            pstm.setString(2,teacher.getTage());

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

    //删除
    @Override
    public int doDelT(int tid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "delete from teacher where tid=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,tid);
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

    //实现加载
    @Override
    public Teacher doLoadT(int tid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from teacher where tid=?";

        Teacher t = new Teacher();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,tid);
            rs = pstm.executeQuery();


            while(rs.next()){
                t = new Teacher();
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                t.setTage(rs.getString("tage"));
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

        return t;
    }

    //更新
    @Override
    public int doUpdT(Teacher teacher) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "update teacher set tname='"+teacher.getTname()+"',tage='"+teacher.getTage()+"' where tid=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,teacher.getTid());

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
        String sql = "select count(*) as num from teacher";
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

    //模糊查询
    @Override
    public List<Teacher> doSelByLikeT(String tname) {
        List<Teacher> empList=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        String sql="select * from teacher where tname like '%"+tname+"%'";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                Teacher t=new Teacher();
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                t.setTage(rs.getString("tage"));

                empList.add(t);
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
        return empList;
    }

    @Override
    public List<Teacher> findByPageNum(int startIndex) {
//        int begin = (page.getPageNum()-1)*page.getPageSize();   // 当前页码数据从第几条开始
        List<Teacher> tpmList = new ArrayList<>();

        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from teacher limit ?,3";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,startIndex);
            rs = pstm.executeQuery();

            while(rs.next()){
                Teacher t = new Teacher();
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                t.setTage(rs.getString("tage"));

                tpmList.add(t);
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

        return tpmList;
    }

}
