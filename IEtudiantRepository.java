package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;

public interface IEtudiantRepository {
    public List<Etudiant> findAll();
    public Etudiant insert (Etudiant etudiant);
    public Etudiant findById(int id);
    public List<Etudiant> selectAllByAnnee(String annee);
    public List<Etudiant> selectAllByClasse(Classe classe);
    public Etudiant selectAllByName(String nomComplet);
}
