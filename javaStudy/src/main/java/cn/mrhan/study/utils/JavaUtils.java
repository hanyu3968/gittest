package cn.mrhan.study.utils;

import java.sql.*;

public class JavaUtils {

    /**
     * 获取jdbc连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        /**
         * 加载jdbc驱动程序，将driver类的实例注册到drivermanager类中
         */
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
        String username ="root";
        String password="root";
        String url = "jdbc:mysql://localhost:3306/hanyu" ;

        try {
            conn = DriverManager.getConnection(url , username , password );
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭jdbc对象资源
     */
    public static <T> void jdbcColse(ResultSet rs, Connection con,T t){
        if(rs !=null){   // 关闭记录集
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(t !=null){   // 关闭声明
            try {
                if(t instanceof Statement){
                    ((Statement) t).close();
                }
                if(t instanceof  PreparedStatement){
                    ((PreparedStatement) t).close();
                }
                if(t instanceof CallableStatement){
                    ((CallableStatement) t).close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con !=null){  // 关闭连接对象
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
