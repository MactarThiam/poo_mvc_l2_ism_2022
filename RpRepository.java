package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.RP;
import ism.inscription.entities.Role;
import ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IRpRepository;

public class RpRepository extends MysqlDb implements IRpRepository {

    private final String SQL_INSERT="INSERT INTO `user` ( `role`, `login`, `password`, `nomComplet`) VALUES (?,?,?,?)";
    private final String SQL_SELECT_BY_ID="INSERT * FROM `user` WHERE `id` LIKE ?";


    @Override
    public RP insert(RP rp){
        this.ouvirConnexionBD();
        try {
                ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, rp.getRole().name());
                ps.setString(2, rp.getLogin());
                ps.setString(3, rp.getPassword());
                ps.setString(4, rp.getNomComplet());
                ps.executeUpdate();
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    rp.setId(rs.getInt(1));
                }

            
            } catch (SQLException e) {
                // TODO: handle exception
            }{

             
             this.fermerConnexionBD();
    
           return rp;
            }
        
        
    }

    

    @Override
    public RP findById(int id) {
            RP rp= null;
            this.ouvirConnexionBD();
            try {
               ps=conn.prepareStatement(SQL_SELECT_BY_ID);
               ps.setInt(1, id);
               ResultSet rs=ps.executeQuery();
               if(rs.next()){
                 rp=new RP(rs.getInt("id"), 
                                   rs.getString("role").compareTo("ROLE_RP")==0? Role.RP:Role.AC,
                                   rs.getString("login"),
                                   rs.getString("password"),
                                   rs.getString("nomComplet"));        
               }
     
     
            } catch (SQLException e) {
             // TODO: handle exception
            }
            this.fermerConnexionBD();
        return rp;
    }



    @Override
    public List<RP> findAll() {
        List<RP> rps = new ArrayList<>();
        this.ouvirConnexionBD();
        try {
                      Statement stm=conn.createStatement();
                     ResultSet rs=stm.executeQuery("select * from user");
                     while(rs.next()){
                        RP rp=new RP(rs.getInt("id"),
                                    rs.getString("role").compareTo("ROLE_RP")==0? Role.RP:Role.AC,
                                    rs.getString("login"),
                                    rs.getString("password"),
                                    rs.getString("nomComplet"));
                                            
                        rps.add(rp);      
                }
        
            } catch (SQLException e) {
                // TODO: handle exception
            }{
        this.fermerConnexionBD();        

       
        return rps;
    }
    }

    
    
}




