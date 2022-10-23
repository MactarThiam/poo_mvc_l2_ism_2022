package ism.inscription.services;

import java.util.List;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.User;
import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.repositories.IInscriptionRepository;
import ism.inscription.repositories.IProfClasRepository;
import ism.inscription.repositories.IProfesseurRepository;
import ism.inscription.repositories.IUserRepository;

public class InscriptionService implements IInscriptionService {

    
    IEtudiantRepository etudiantRepository;
    IClasseRepository classeRepository;
    IProfesseurRepository professeurRepository;
    IProfClasRepository profClasRepository;
    IUserRepository userRepository;
    IInscriptionRepository inscriptionRepository;

    public InscriptionService(IClasseRepository classeRepository,IEtudiantRepository etudiantRepository,IProfesseurRepository professeurRepository, IInscriptionRepository inscriptionRepository,IUserRepository userRepository,IProfClasRepository profClasRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.professeurRepository =professeurRepository;
        this.profClasRepository = profClasRepository;
        this.userRepository =userRepository;
    }

    

    @Override
    public List<Classe> listerClasse() {
        return classeRepository.findAll();
    }

    @Override
    public Classe creerClasse(Classe classe) {
        return classeRepository.insert(classe);
    }

    @Override
    public Classe affecterClasseProfesseur(Professeur professeur, Classe classe) {
        return profClasRepository.affecterClasseProfesseur(classe,professeur);
    }

    @Override
    public Professeur ajouterProfesseur(Professeur professeur) {
        return professeurRepository.insert(professeur);
    }

    @Override
    public List<Professeur> listerProfesseur() {
        return professeurRepository.findAll();
    }

    @Override
    public Classe filterClasseUnProfesseur(int id) {
        return null;
    }

    @Override
    public Etudiant inscrireEtudiant(Inscription inscription, Classe classe, Etudiant etudiant) {
        etudiantRepository.insert(etudiant);
        return inscriptionRepository.insert(inscription, classe, etudiant);
    }

    @Override
    public Etudiant reinscrireEtudiant(Inscription inscription, Classe classe, Etudiant etudiant) {
        return inscriptionRepository.insert(inscription, classe, etudiant);
    }

    @Override
    public List<Etudiant> listerEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.insert(etudiant);
    }

    @Override
    public List<Etudiant> filtrerEtudiantInscritParClasse(Classe classe) {
        return etudiantRepository.selectAllByClasse(classe);
    }

    @Override
    public Inscription filterEtudiantParClasse(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Classe findClasseByLibelle(String libelle) {
        return classeRepository.selectClasseByLibelle(libelle);
    }

    @Override
    public Professeur findProfesseurByName(String nomComplet) {
        return professeurRepository.selectByName(nomComplet);
    }

    @Override
    public Etudiant findByName(String nomComplet) {
        return etudiantRepository.selectAllByName(nomComplet);
    }

    @Override
    public List<Classe> listerClasseProfesseur(Professeur professeur) {
       
        return profClasRepository.listerClasseProfesseur(professeur);
    }

    @Override
    public List<Etudiant> listerEtudiantInscritAnnee(String annee) {
        return etudiantRepository.selectAllByAnnee(annee);
    }



    @Override
    public User seConnecter(String login, String password) {
        return userRepository.findUserByLoginAndPassword(login, password);
    }

    
    
}
