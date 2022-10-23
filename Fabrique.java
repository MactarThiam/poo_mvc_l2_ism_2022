package ism.inscription.entities.core;

import ism.inscription.repositories.IClasseRepository;
import ism.inscription.repositories.IEtudiantRepository;
import ism.inscription.repositories.IInscriptionRepository;
import ism.inscription.repositories.IProfClasRepository;
import ism.inscription.repositories.IProfesseurRepository;
import ism.inscription.repositories.IUserRepository;
import ism.inscription.repositories.bd.ClasseRepository;
import ism.inscription.repositories.bd.EtudiantRepository;
import ism.inscription.repositories.bd.InscriptionRepository;
import ism.inscription.repositories.bd.ProfClasRepository;
import ism.inscription.repositories.bd.ProfesseurRepository;
import ism.inscription.repositories.bd.UserRepository;
import ism.inscription.services.IInscriptionService;
import ism.inscription.services.InscriptionService;

public class Fabrique {
   
    public static IInscriptionService getService(){
        IClasseRepository classeRepository= new ClasseRepository();
        IProfesseurRepository professeurRepository= new ProfesseurRepository();
        IEtudiantRepository etudiantRepository= new EtudiantRepository();
        IInscriptionRepository inscriptionRepository= new InscriptionRepository(etudiantRepository);
        IProfClasRepository profClasRepository= new ProfClasRepository(classeRepository);
        IUserRepository userRepository=new UserRepository();
        return new InscriptionService (classeRepository,
         etudiantRepository,professeurRepository,inscriptionRepository,userRepository,profClasRepository);
        
          }
    }



