package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Sensor;

public class BaseDAO {

	private static String bdDriver = "com.mysql.cj.jdbc.Driver";
    private static String bdUrl = "jdbc:mysql://localhost:3306/gsfibertrail?serverTimezone=GMT&autoReconnect=true";
    private static String bdName = "root";
    private static String bdpwd = "123456";
    private static Connection conn = null;
    
    private BaseDAO(){
        try{
            Class.forName(bdDriver);
            conn = DriverManager.getConnection(bdUrl,bdName,bdpwd);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
 
    public static Connection getConn(){
        if(conn == null)
            new BaseDAO();
        return conn;
    }
 
    public static void ColseAll(ResultSet rs,Statement stat){
       try{
            if(rs != null)
                rs.close();
            if(stat != null)
                stat.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
	
}
