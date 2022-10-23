package ism.inscription.repositories.bd;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.Classe;
import  ism.inscription.entities.Professeur;
import  ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IClasseRepository;
import  ism.inscription.repositories.IProfesseurRepository;

public class ProfesseurRepository extends MysqlDb implements IProfesseurRepository {

    

    

    private final String SQL_SELECT="SELECT * FROM professeur";
    private final String SQL_INSERT="INSERT INTO `professeur` ( `nci`, `nomComplet`, `grade`) VALUES (?,?,?)";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `professeur` WHERE `id` LIKE ?";
    private final String SQL_SELECT_BY_NAME="SELECT * FROM professeur WHERE nomComplet LIKE ?";
    
    IClasseRepository classeRepository;

    @Override
    public List<Professeur> findAll() {
          ResultSet rs=null;
          List<Professeur> professeurs = new ArrayList<>();
          this.ouvirConnexionBD();
          this.prepareRequete(SQL_SELECT);
             rs=this.executeSelect();
             try {
                
                while (rs.next()) {
                     professeurs.add(new Professeur(rs.getInt("id"),
                                            rs.getString("nci"),
                                            rs.getString("nomComplet"),
                                            rs.getString("grade")));
                }
       
                } catch (SQLException e) {
                    e.printStackTrace();
               }finally{
                    this.fermerConnexionBD();
               }
            return professeurs ;
        } 
    
    

    @Override
    public Professeur insert(Professeur professeur) {
        
        this.ouvirConnexionBD();
        this.prepareRequete(SQL_INSERT);

        try {
             this.getPs().setString(1, professeur.getNci());
             this.getPs().setString(2, professeur.getNomComplet());
             this.getPs().setString(3, professeur.getGrade());
             
             int nbreLigne=this.executeMiseAJour();

                }catch (SQLException e) {

                    e.printStackTrace();

                } finally{

                this.fermerConnexionBD();

                }
            
            return professeur;
        }
                
    @Override
    public Professeur findById(int id) {
        Professeur professeur= null;
        ResultSet rs=null;
            
            this.ouvirConnexionBD();
            this.prepareRequete(SQL_SELECT_BY_ID);
            rs=this.executeSelect();
            try {
                this.getPs().setInt(1, id);
                rs=this.executeSelect();
                             if (rs.next()) {
                professeur=new Professeur(rs.getInt("id"),
                                    rs.getString("nci"),
                                    rs.getString("nomComplet"),
                                    rs.getString("grade"));
         
                   }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    this.fermerConnexionBD();
                }
            return professeur;
         }



    @Override
    public Professeur insertClassProf(Professeur professeur, Classe classe) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public List<Classe> selectClasseProfessuer(int id) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public Professeur selectByName(String nomComplet) {
        Professeur professeur=null;
        
        this.ouvirConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NAME);
            ps.setString(1, nomComplet);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                professeur=new Professeur(rs.getInt("id"), 
                                                    rs.getString("nci"),
                                                    rs.getString("nomComplet"), 
                                                    rs.getString("grade"));
                                                
            }
           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
        return professeur;
    }
        
    }



    
    



   



    
    
   


    


                
                  
         
                
                   

