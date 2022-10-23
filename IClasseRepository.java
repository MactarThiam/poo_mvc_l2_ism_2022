package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;

public interface IClasseRepository {

    public List<Classe> findAll();
    public Classe insert (Classe classe);
    public Classe findById(int id);
    public Classe selectClasseByLibelle(String libelle);
    
    
}
