package cn.mrhan.study.demo.demos;


import java.sql.*;

public class Demo07 {
    public static void main(String[] args)  {
        /**
         *   1.加载JDBC驱动程序：在连接数据库之前，首先要加载想要连接的数据库的驱动到JVM（Java虚拟机），
         *   这通过java.lang.Class类的静态方法forName(String  className)实现
         *   成功加载后，会将Driver类的实例注册到DriverManager类中。
         */

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }

        String username = "root" ;
        String password = "root" ;
        String url = "jdbc:mysql://localhost:3306/hanyu" ;
        Connection con = null;
        try {
            con = DriverManager.getConnection(url , username , password );
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        /**
         * 3、创建一个preparedStatement
         *
         *     •要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3 种类型：
         *       1、执行静态SQL语句。通常通过Statement实例实现。
         *       2、执行动态SQL语句。通常通过PreparedStatement实例实现。
         *       3、执行数据库存储过程。通常通过CallableStatement实例实现。
         */
        Statement stmt =null;
        //String sql = "select * from emp where id=?";
       // PreparedStatement pstmt=null;
        try {
            stmt = con.createStatement() ;
           // pstmt = con.prepareStatement(sql) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //CallableStatement cstmt = con.prepareCall("{CALL demoSp(? , ?)}") ;
        /**
         * Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate和execute
         *     1、ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句，返回一个结果集（ResultSet）对象。
         *     2、int executeUpdate(String sqlString)：用于执行INSERT、UPDATE或 DELETE语句以及SQL DDL语句，如：CREATE TABLE和DROP TABLE等
         *     3、execute(sqlString):用于执行返回多个结果集、多个更新计数或二者组合的语句。
         */
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMP") ;
            /**
             * 遍历结果集
             *
             *     两种情况：
             *      1、执行更新返回的是本次操作影响到的记录数。
             *      2、执行查询返回的结果是一个ResultSet对象。
             *     • ResultSet包含符合SQL语句中条件的所有行，并且它通过一套get方法提供了对这些
             *       行中数据的访问。
             *     • 使用结果集（ResultSet）对象的访问方法获取数据：
             */
            while(rs.next()){
                String name = rs.getString("name") ;
                String age = rs.getString("age") ; // 此方法比较高效
                System.out.println(name+":"+age);
            }

            /**
             * 处理异常，关闭JDBC对象资源
             *
             *      •操作完成以后要把所有使用的JDBC对象全都关闭，以释放JDBC资源，关闭顺序和声 明顺序相反：
             *      1、先关闭requestSet
             *      2、再关闭preparedStatement
             *      3、最后关闭连接对象connection
             */

            if(rs !=null){   // 关闭记录集
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt !=null){   // 关闭声明
                try {
                    stmt.close();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
