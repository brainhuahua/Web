package Mysql;


import java.sql.*;

public class sql {
    Connection con; // 声明Connection对象
    public static String database;
    public static String user;
    public static String password;
    public static String dburl;

    public Connection getConnection() { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        user = "root";//数据库登录名
        password = "124406623";//密码
        database = "web";
        dburl = "jdbc:mysql://localhost:3306/" + database + "?useUnicode=true&characterEncoding=utf-8";
        try { // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection(dburl, user, password);
            //System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con; // 按方法要求返回一个Connection对象
    }

    public sql() {
        getConnection();

    }

    public boolean login(String username, String password) {
        try {
            Statement statement = con.createStatement();
            String sql = "select * from web_user_tables where username = '" + username + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getString("userpass").equals(password)) {
                    return true;
                }
            }
            return false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String forgotpass(String username, String email) {
        try {
            Statement statement = con.createStatement();
            String sql = "select * from web_user_tables where username = '" + username + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("userpass"));
                if (resultSet.getString("email").equals(email)) {
                    return resultSet.getString("userpass");
                }
            }
            return "-1";


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean register(String email, String username, String password) {
        try {
            Statement statement = con.createStatement();
            String sql = "INSERT INTO web_user_tables VALUES('" + email + "','" + username + "','" + password + "');";
            System.out.println(sql);

            int num =  statement.executeUpdate(sql);

            if(num==1){
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("出错了");
            e.printStackTrace();

        }
        return false;
//
    }

    public ResultSet select(String email) {
        try {
            Statement statement = con.createStatement();
            String sql = "select * from information;";
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet select1() {
        try {
            Statement statement = con.createStatement();
            String sql = "select * from resource_me;";
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean change_line(String email,String name,String toward ,String address , String birth, String tel ){

        try {
            Statement statement = con.createStatement();
            String sql = "UPDATE information SET name='" + name + "',toward='" + toward + "',address='" + address + "',birth='" +
                    birth + "',email='" +
                    email + "',tel='" + tel +"';";
            int num =  statement.executeUpdate(sql);
            if(num>=1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


}


    public boolean change_photo(String photourl ){

        try {
            Statement statement = con.createStatement();
            String sql = "UPDATE information SET photourl='" + photourl + "';";
            int num =  statement.executeUpdate(sql);
            if(num>=1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public boolean change_resource(String oldresource, String newresource,int opreate ){//0增加，1改，2删

        try {
            Statement statement = con.createStatement();
            String table = "resource_me";
            String sql = "";
            int num = -1;
            if(opreate==0){
                sql = "INSERT INTO resource_me VALUES('" + newresource + "');";
                num =  statement.executeUpdate(sql);
            }else if(opreate==1){
                sql = "UPDATE resource_me SET detail = '" +newresource +"' WHERE detail = '" +oldresource +"';";
                num =  statement.executeUpdate(sql);
            }else {
                sql = " DELETE FROM resource_me WHERE detail = '" + oldresource + "';";
                num =  statement.executeUpdate(sql);
            }
            if(num>=1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




//public static void main(String[] args) { // 主方法，测试连接
//    sql c = new sql(); // 创建本类对象
//    String email= "bdh@csu.edu.cn";
//    String name = "卜德华";
//    String toward = "阿里";
//    String address = "123";
//    String birth = "213";
//    String tel = "213";
//    c.change_line(email,name,toward,address,birth,tel);
//    c.change_resource("","我是卜德华",0);
//    c.change_resource("我是卜德华","我是大帅哥",1);
//    c.change_resource("我是大帅哥","",2);
//    }


}