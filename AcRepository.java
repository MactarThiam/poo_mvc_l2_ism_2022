package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.AC;
import ism.inscription.entities.Role;
import ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IAcRepository;

public class AcRepository extends MysqlDb implements IAcRepository {
    private final String SQL_INSERT="INSERT INTO `user` ( `role`, `login`, `password`, `nomComplet`) VALUES (?,?,?,?)";
    private final String SQL_SELECT_BY_ID="INSERT * FROM `user` WHERE `id` LIKE ?";


    @Override
    public AC insert(AC ac){
        this.ouvirConnexionBD();
        try {
                ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, ac.getRole().name());
                ps.setString(2, ac.getLogin());
                ps.setString(3, ac.getPassword());
                ps.setString(4, ac.getNomComplet());
                ps.executeUpdate();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    ac.setId(rs.getInt(1));
                }

            
            } catch (SQLException e) {
                // TODO: handle exception
            }{

             
             this.fermerConnexionBD();
    
           return ac;
            }
        
        
    }

    

    @Override
    public AC findById(int id) {
            AC ac= null;
            this.ouvirConnexionBD();
            try {
               ps=conn.prepareStatement(SQL_SELECT_BY_ID);
               ps.setInt(1, id);
               ResultSet rs=ps.executeQuery();
               if(rs.next()){
                 ac=new AC(rs.getInt("id"), 
                                   rs.getString("role").compareTo("ROLE_AC")==0? Role.RP:Role.AC,
                                   rs.getString("login"),
                                   rs.getString("password"),
                                   rs.getString("nomComplet"));        
               }
     
     
            } catch (SQLException e) {
             // TODO: handle exception
            }
            this.fermerConnexionBD();
        return ac;
    }



    @Override
    public List<AC> findAll() {
        List<AC> ach = new ArrayList<>();
        this.ouvirConnexionBD();
        try {
                      Statement stm=conn.createStatement();
                     ResultSet rs=stm.executeQuery("select * from user");
                     while(rs.next()){
                        AC ac=new AC(rs.getInt("id"),
                                    rs.getString("role").compareTo("ROLE_AC")==0? Role.RP:Role.AC,
                                    rs.getString("login"),
                                    rs.getString("password"),
                                    rs.getString("nomComplet"));
                                            
                        ach.add(ac);      
                }
        
            } catch (SQLException e) {
                // TODO: handle exception
            }{
        this.fermerConnexionBD();        

       
        return ach;
    }
    }

    
    
}




