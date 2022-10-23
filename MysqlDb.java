package ism.inscription.entities.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDb implements IDataBase{
    protected Connection conn;
    protected PreparedStatement ps;
    protected Statement stm;
    String sql;
    @Override
    public void ouvirConnexionBD() {
        try{
               Class.forName("com.mysql.cj.jdbc.Driver");
                 try{
                     conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_inscription","root","");
                }catch(SQLException e){
                    e.printStackTrace();
                }
    }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }       
    }

    @Override
    public void fermerConnexionBD() {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
    }
  }

   
    

    @Override
    public int executeMiseAJour() {
       int nbre=0;
       try {
       
        nbre=ps.executeUpdate();
    } catch (SQLException e) {

        e.printStackTrace();

    }

    return nbre;

}

    @Override
    public ResultSet executeSelect() {
        ResultSet rs=null;
        try {
            rs=ps.executeQuery();

        } catch (SQLException e) {

            e.printStackTrace();
     
        }
     
        return rs;
     
      }
    

   

    public PreparedStatement getPs() {

        return ps;
    }

    @Override
    public void prepareRequete(String sql) {
        try {
  
            ps=conn.prepareStatement(sql);
     
        } catch (SQLException e) {
     
            e.printStackTrace();
     
        }
    }

   
}
     
     


