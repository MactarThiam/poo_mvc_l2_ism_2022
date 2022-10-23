package ism.inscription.repositories.bd;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IProfesseurRepository;

public class ClasseRepository extends MysqlDb implements IClasseRepository {
    
    private final String SQL_INSERT="INSERT INTO `classe` (`libelle`) VALUE (?)";
    private final String SQL_SELECT="SELECT * FROM classe";
    private final String SQL_SELECT_CLASSE_BY_LIBELLE="SELECT * FROM classe WHERE libelle LIKE ?";
    private final String SQL_SELECT_BY_ID=" SELECT * FROM `classe` WHERE `id` LIKE ?";
    
    




    
    
    @Override
    public List<Classe> findAll() {
        List<Classe> classes=new ArrayList<>();
        ResultSet rs=null;
           this.ouvirConnexionBD();
           this.prepareRequete(SQL_SELECT);
           rs=this.executeSelect();
           try {
              while (rs.next()) {
                   classes.add(new Classe(rs.getInt("id"),
                                          rs.getString("libelle")));

                  }
         } catch (SQLException e) {
              e.printStackTrace();
         }finally{
              this.fermerConnexionBD();
         }
       return classes;

        }
    @Override
    public Classe insert(Classe classe) {
        this.ouvirConnexionBD();
        try {

            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, classe.getLibelle());
           
            


            ps.executeUpdate();

        ResultSet  rs=ps.getGeneratedKeys();
            if (rs.next()){
                classe.setId(rs.getInt(1));
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD(); 
       return classe;

    }
        
        

   

    @Override
    public Classe findById(int id) {
     
          Classe classe=null;
          this.ouvirConnexionBD();
          try {
                ps= conn.prepareStatement(SQL_SELECT_BY_ID) ;
                ps.setInt(1, id); 
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                  classe=new Classe(
                      rs.getInt("id"), 
                      rs.getString("libelle")  
                    );
                }
  
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
        return classe;
 
         }
@Override
public Classe selectClasseByLibelle(String libelle) {
     Classe classe=null;

     this.ouvirConnexionBD();
     try {
         ps=conn.prepareStatement(SQL_SELECT_CLASSE_BY_LIBELLE);
         ps.setString(1, libelle);
         ResultSet rs=ps.executeQuery();
         if (rs.next()) {
             classe=new Classe(rs.getInt("id"),
                               rs.getString("libelle"));
             
         }

       
         
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     this.fermerConnexionBD();
     return classe;
}
}


    
    
                
                
                  
       
    
   


  
    

   
   

    
    





