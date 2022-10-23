package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;

public interface IInscriptionRepository {
    public List<Inscription> findAll();
    public Etudiant insert(Inscription inscription,Classe classe,Etudiant etudiant);
    
}
