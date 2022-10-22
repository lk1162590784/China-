package Dao;

import bean.Bar;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;

public class BarDao {
    public String query() {
        ArrayList<Bar> barArr = new ArrayList<Bar>();
        try {
            //JDBC方式连接MySQL数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yiqing?characterEncoding=utf8", "root", "123456");
            PreparedStatement stmt = conn.prepareStatement("SELECT pv,SUM(nowConfirm) AS num FROM `data` GROUP BY pv");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Bar bar = new Bar();
//                bar.setPc(rs.getString("pv"));
//                bar.setDingdong(rs.getInt("num"));
                barArr.add(bar);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson =new Gson();
        String str=gson.toJson(barArr);

        return str;
    }
    public String dayssql() {
        ArrayList<Bar> barArr = new ArrayList<Bar>();
        try {
            //JDBC方式连接MySQL数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jingdong?characterEncoding=utf8", "root", "123456");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dayssql");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Bar bar = new Bar();
//                bar.setPc(rs.getString("day"));
//                bar.setDingdong(rs.getInt("days"));
                barArr.add(bar);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson =new Gson();
        String str=gson.toJson(barArr);

        return str;
    }
    public String uservip() {
        ArrayList<Bar> barArr = new ArrayList<Bar>();
        try {
            //JDBC方式连接MySQL数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jingdong?characterEncoding=utf8", "root", "123456");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM userlevelname_out");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Bar bar = new Bar();
//                bar.setPc(rs.getString("name"));
//                bar.setDingdong(rs.getInt("value"));
                barArr.add(bar);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson =new Gson();
        String str=gson.toJson(barArr);

        return str;
    }

    public String time_out() {
        ArrayList<Bar> barArr = new ArrayList<Bar>();
        try {
            //JDBC方式连接MySQL数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jingdong?characterEncoding=utf8", "root", "123456");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM creationtime_out");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
//                Bar bar = new Bar();
//                bar.setPc(rs.getString("day"));
//                bar.setDingdong(rs.getInt("num"));
//                barArr.add(bar);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson =new Gson();
        String str=gson.toJson(barArr);

        return str;
    }
    public String time() {
        ArrayList<Bar> barArr = new ArrayList<Bar>();
        try {
            //JDBC方式连接MySQL数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jingdong?characterEncoding=utf8", "root", "123456");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM count_comment");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
//                Bar bar = new Bar();
//                bar.setPc(rs.getString("time"));
////                bar.setDingdong(rs.getInt("count"));
//                barArr.add(bar);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson =new Gson();
        String str=gson.toJson(barArr);

        return str;
    }
    public void update(String name,Integer num) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jingdong?characterEncoding=utf8", "root", "123456");
            PreparedStatement stmt = conn.prepareStatement("update ismobilehive set days='"+num+"' where day='"+name+"'");
            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
