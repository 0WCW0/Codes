package com.itwanli.dao.impl;

import com.itwanli.bean.User;
import com.itwanli.dao.UserDao;
import com.itwanli.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 实现用户登录
     * @param currentUser
     * @return
     */

    @Override
    public int doLogin(User currentUser) {
        Connection conn = DBUtil.getConn();
        int count = 0;
        String sql = "select count(*) as num from user where username=? and password=?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,currentUser.getUsername());
            pstm.setString(2,currentUser.getPassword());
//            pstm.setInt(3,currentUser.getType());
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                count = rs.getInt("num");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public User getAdminInfo(String username, String password) {
        // TODO Auto-generated method stub
        User u = new User();
        Connection conn = DBUtil.getConn();
        String sql = "select * from user where username='"+username+"' AND password='"+password+"'";
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
    public List<User> findAll() {
        List<User> upmList = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from user";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));

                upmList.add(u);
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

        return upmList;
    }

    @Override
    public int doInsU(User user) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "insert into user(username,password,type) values(?,?,?)";

        int flag = 0;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            pstm.setInt(3,user.getType());

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
    public int doDelU(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "delete from user where id=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
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
    public User doLoadU(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from user where id=?";

        User u = new User();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();


            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));
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

        return u;
    }

    @Override
    public User doLoadSM(int id) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from user where id=?";

        User u = new User();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();


            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));
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

        return u;
    }

    @Override
    public int doUpdU(User user) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "update user set username='"+user.getUsername()+"',password='"+user.getPassword()+"',type=? where id=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,user.getType());
            pstm.setInt(2,user.getId());

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
    public int doUpdM(User user) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "update user set username='"+user.getUsername()+"',password='"+user.getPassword()+"' where id=?";

        int flag = 0;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,user.getId());

            flag = pstm.executeUpdate();
            System.out.println("更新成功!");

            return flag;
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
    public List<User> doSelByLikeU(String username) {
        List<User> umpList=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        String sql="select * from user where username like '%"+username+"%'";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));

                umpList.add(u);
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
        return umpList;
    }

    @Override
    public List<User> findByPageNum(int startIndex) {
//        int begin = (page.getPageNum()-1)*page.getPageSize();   // 当前页码数据从第几条开始
        List<User> upmList = new ArrayList<>();

        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from user limit ?,3";


        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,startIndex);
            rs = pstm.executeQuery();

            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getInt("type"));

                upmList.add(u);
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

        return upmList;
    }

    @Override
    public int getRecordsNum() {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select count(*) as num from user";
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
}
