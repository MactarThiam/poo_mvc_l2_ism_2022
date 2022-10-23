package ism.inscription.repositories.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.repositories.IInscriptionRepository;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;

public class InscriptionRepository extends MysqlDb implements IInscriptionRepository {

    public InscriptionRepository(IEtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    private final String SQL_INSERT ="INSERT INTO `inscription`(`annee`, `etat`, `classe_id`, `etudiant_id`) VALUES (?,?,?,?)";
    IEtudiantRepository etudiantRepository;
    
    @Override
    public Etudiant insert(Inscription inscription,Classe classe,Etudiant etudiant) {
        this.ouvirConnexionBD();
        this.prepareRequete(SQL_INSERT);
        try {

            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getAnnee());
            ps.setString(2, inscription.getEtat().name());
            ps.setInt(3, classe.getId());
            ps.setInt(4, etudiant.getId());


            ps.executeUpdate();
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fermerConnexionBD();
       return etudiant;
    }

    @Override
    public List<Inscription> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

   
}
