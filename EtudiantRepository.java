package ism.inscription.repositories.bd;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.core.MysqlDb;

import ism.inscription.repositories.IEtudiantRepository;

public class EtudiantRepository extends MysqlDb implements IEtudiantRepository {
    private final String SQL_SELECT="SELECT * FROM etudiant";
    private final String SQL_INSERT="INSERT INTO `etudiant` ( `nomComplet`, `matricule`, `tuteur`) VALUES (?,?,?)";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `etudiant` WHERE `id` LIKE ?";
    private final String SQL_SELECT_ETU_AN="SELECT * FROM etudiant e ,inscription i WHERE e.id=i.etudiant_id AND annee LIKE ?";
    private final String SQL_SELECT_ETU_NAME="SELECT * FROM etudiant WHERE nom_complet LIKE ?";
    private final String SQL_SELECT_ETU_CLA="SELECT * FROM etudiant e ,inscription i WHERE e.id=i.etudiant_id AND classe_id = ?";

    @Override
        public List<Etudiant> findAll() {
          List<Etudiant> etudiants = new ArrayList<>();
          ResultSet rs=null;
             this.ouvirConnexionBD();
             this.prepareRequete(SQL_SELECT);
             rs=this.executeSelect();
             try {
                while (rs.next()) {
                     etudiants.add(new Etudiant(rs.getInt("id"),
                                            rs.getString("matricule"),
                                            rs.getString("nomComplet"),
                                            rs.getString("tuteur")));
                    }
           } catch (SQLException e) {
                e.printStackTrace();
           }finally{
                this.fermerConnexionBD();
           }
         return etudiants;
        }
        @Override
        public Etudiant insert(Etudiant etudiant) {
            this.ouvirConnexionBD();
            try {

                ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, etudiant.getMatricule());
                ps.setString(2, etudiant.getNomComplet());
                ps.setString(3, etudiant.getTuteur());
                
    
    
                ps.executeUpdate();

            ResultSet  rs=ps.getGeneratedKeys();
                if (rs.next()){
                    etudiant.setId(rs.getInt(1));
                }
                
    
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.fermerConnexionBD();
           return etudiant;
        }
            

  
                
    
        @Override
        public Etudiant findById(int id) {
            ResultSet rs=null;
            Etudiant etudiant= null;
            this.ouvirConnexionBD();
            this.prepareRequete(SQL_SELECT_BY_ID);
            rs=this.executeSelect();
            try {
                this.getPs().setInt(1, id);
                rs=this.executeSelect();
                             if (rs.next()) {
                etudiant=new Etudiant(rs.getInt("id"),
                                    rs.getString("matricule"),
                                    rs.getString("nomComplet"),
                                    rs.getString("tuteur"));
                   }
          } catch (SQLException e) {
               e.printStackTrace();
          }finally{
               this.fermerConnexionBD();
          }
        return etudiant;
 
         }
     @Override
     public List<Etudiant> selectAllByAnnee(String annee) {
          List<Etudiant> etudiants=new ArrayList<>();

          this.ouvirConnexionBD();
          try {
              ps=conn.prepareStatement(SQL_SELECT_ETU_AN);
              ps.setString(1, annee);
              ResultSet rs= ps.executeQuery();
              while (rs.next()) {
                  Etudiant etudiant=new Etudiant(rs.getInt("id"), 
                                                  rs.getString("matricule"), 
                                                  rs.getString("nomComplet"), 
                                                  rs.getString("tuteur"));
                  etudiants.add(etudiant);                                
              }
              
  
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          this.fermerConnexionBD();
  
  
          return etudiants;
     }
     @Override
     public List<Etudiant> selectAllByClasse(Classe classe) {
          List<Etudiant> etudiants=new ArrayList<>();

          this.ouvirConnexionBD();
          try {
              ps=conn.prepareStatement(SQL_SELECT_ETU_CLA);
              ps.setInt(1, classe.getId());
              ResultSet rs= ps.executeQuery();
              while (rs.next()) {
                  Etudiant etudiant=new Etudiant(rs.getInt("id"), 
                                                  rs.getString("matricule"), 
                                                  rs.getString("nomComplet"), 
                                                  rs.getString("tuteur"));
                  etudiants.add(etudiant);                                
              }
              
  
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          this.fermerConnexionBD();
  
  
          return etudiants;
     }
     @Override
     public Etudiant selectAllByName(String nomComplet) {
          Etudiant etudiant=null;
            
            this.ouvirConnexionBD();
            try {
                ps=conn.prepareStatement(SQL_SELECT_ETU_NAME);
                ps.setString(1, nomComplet);
                ResultSet rs=ps.executeQuery();
                if (rs.next()) {
                     etudiant=new Etudiant(rs.getInt("id"),
                                                    rs.getString("matricule"), 
                                                    rs.getString("nom_complet"), 
                                                    rs.getString("tuteur"));
                                                
                }
                
    
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.fermerConnexionBD();
    
    
            return etudiant;
     }
     

        

}
