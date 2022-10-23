package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Professeur;

public interface IProfesseurRepository {
    public List<Professeur> findAll();
    public Professeur insert (Professeur professeur);
    public Professeur findById(int id);
    public Professeur insertClassProf(Professeur professeur,Classe classe);
    public List<Classe> selectClasseProfessuer(int id);
    public Professeur selectByName(String nomComplet);
  
    
}
