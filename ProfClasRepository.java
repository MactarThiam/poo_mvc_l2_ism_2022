package ism.inscription.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IProfClasRepository;

public class ProfClasRepository extends MysqlDb implements IProfClasRepository {
     private final String SQL_AFFECTER_CLASSE_PROFESSEUR="INSERT INTO `prof_classe` (`prof_id`,`classe_id`) VALUES (?,?)";
     private final String SQL_FIND_BY_ALL_CLASSE="select * from `prof_classe` where prof_id = ? ";

    IClasseRepository classeRepository;
    public ProfClasRepository(IClasseRepository classeRepository){
        this.classeRepository=classeRepository;

    } 


    @Override
    public  List<Classe> listerClasseProfesseur(Professeur professeur) {
        List<Classe> classes=new ArrayList<>();
        this.ouvirConnexionBD();
           try {
                    ps= conn.prepareStatement(SQL_FIND_BY_ALL_CLASSE);
                    ps.setInt(1,professeur.getId());
                    ResultSet rs= ps.executeQuery();
                    while (rs.next()) {
                   classes.add(classeRepository.findById(rs.getInt("classe_id")));                  
                  }
         } catch (SQLException e) {
              e.printStackTrace();
         }finally{
              this.fermerConnexionBD();
         }
       return classes;


        


        
        
    }

    @Override
    public Classe affecterClasseProfesseur(Classe classe, Professeur professeur) {
        this.ouvirConnexionBD();
        this.prepareRequete(SQL_AFFECTER_CLASSE_PROFESSEUR);

            try {
                 ps= conn.prepareStatement(SQL_AFFECTER_CLASSE_PROFESSEUR);
                 ps.setInt(1,professeur.getId());
                 ps.setInt(2,classe.getId());

                 ps.executeUpdate();
       

    }catch (SQLException e) {

         e.printStackTrace();

  } finally{

       this.fermerConnexionBD();
    }
    return classe;
}

}
