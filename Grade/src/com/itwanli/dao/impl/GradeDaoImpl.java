package com.itwanli.dao.impl;

import com.itwanli.bean.Grade;
import com.itwanli.dao.GradeDao;
import com.itwanli.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    @Override
    public int doInsG(Grade grade) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "insert into grade(sname,cname,grade) values(?,?,?)";

        int flag = 0;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,grade.getSname());
            pstm.setString(2,grade.getCname());
            pstm.setString(3,grade.getGrade());


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
    public int doDelG(int gid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "delete from grade where gid=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,gid);
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
    public Grade doLoadG(int gid) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from grade where gid=?";

        Grade g = new Grade();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,gid);
            rs = pstm.executeQuery();


            while(rs.next()){
                g = new Grade();
                g.setGid(rs.getInt("gid"));
                g.setSname(rs.getString("sname"));
                g.setCname(rs.getString("cname"));
                g.setGrade(rs.getString("grade"));
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

        return g;
    }

    @Override
    public int doUpdG(Grade grade) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "update grade set sname='"+grade.getSname()+"',cname='"+grade.getCname()+"',grade='"+grade.getGrade()+"' where gid=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,grade.getGid());

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
    public List<Grade> findByPageNum(int startIndex) {
        List<Grade> gpmList = new ArrayList<>();

        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from grade limit ?,3";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,startIndex);
            rs = pstm.executeQuery();

            while(rs.next()){
                Grade g = new Grade();
                g.setGid(rs.getInt("gid"));
                g.setSname(rs.getString("sname"));
                g.setCname(rs.getString("cname"));
                g.setGrade(rs.getString("grade"));

                gpmList.add(g);
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

        return gpmList;
    }

    @Override
    public int getRecordsNum() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select count(*) as num from grade";
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
    public List<Grade> doSelByLikeG(String sname) {
        List<Grade> gmpList=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        String sql="select * from grade where sname like '%"+sname+"%'";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                Grade g=new Grade();
                g.setGid(rs.getInt("gid"));
                g.setSname(rs.getString("sname"));
                g.setCname(rs.getString("cname"));
                g.setGrade(rs.getString("grade"));

                gmpList.add(g);
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
        return gmpList;
    }
}
