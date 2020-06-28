package cn.mrhan.study.demo.demos;

import cn.mrhan.study.utils.JavaUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo08 {
    public static void main(String[] args) {
        //获取连接
        Connection conn = JavaUtils.getConnection();
        try {
            String sql ="select * from emp where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,"1");
            ResultSet rs = stmt.executeQuery() ;
            while(rs.next()){
                String name = rs.getString("name") ;
                String age = rs.getString("age") ;
                System.out.println(name+":"+age);
            }
            //关闭资源
            JavaUtils.jdbcColse(rs,conn,stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
