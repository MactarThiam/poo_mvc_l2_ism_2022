package ism.inscription.services;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.User;

public interface IInscriptionService {
    public List<Classe> listerClasse();

    public Classe creerClasse(Classe classe);

    public Classe affecterClasseProfesseur(Professeur professeur,Classe classe);

    public Professeur ajouterProfesseur(Professeur professeur);

    public List<Professeur> listerProfesseur();

    public Classe filterClasseUnProfesseur(int id);

    public Etudiant inscrireEtudiant(Inscription inscription,Classe classe,Etudiant etudiant);

    public Etudiant reinscrireEtudiant(Inscription inscription,Classe classe,Etudiant etudiant);

    public List<Etudiant> listerEtudiant();

    public Etudiant ajouterEtudiant(Etudiant etudiant);

    public List<Etudiant> filtrerEtudiantInscritParClasse(Classe classe);

    public  Inscription filterEtudiantParClasse(int id);

    public Classe findClasseByLibelle(String libelle);

    public Professeur findProfesseurByName(String nomComplet);

    public Etudiant findByName(String nomComplet);
    
    public List<Classe> listerClasseProfesseur(Professeur professeur);

    public List<Etudiant> listerEtudiantInscritAnnee(String annee);
    
    public User seConnecter(String login,String password);

  

    
   
    
}
