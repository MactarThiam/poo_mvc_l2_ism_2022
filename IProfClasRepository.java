package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Professeur;

public interface IProfClasRepository {
    public List<Classe> listerClasseProfesseur(Professeur professeur);
    public Classe affecterClasseProfesseur(Classe classe, Professeur professeur);
}
