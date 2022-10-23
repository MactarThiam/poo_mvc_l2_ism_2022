package ism.inscription.entities;

public class Inscription {



        private String annee;
        private Etat etat;
    
    
        
        public Inscription(String annee, Etat etat) {
            this.annee = annee;
            this.etat = etat;
        }
    
        public Inscription() {
        }
        
        public String getAnnee() {
            return annee;
        }
        public void setAnnee(String annee) {
            this.annee = annee;
        }
        public Etat getEtat() {
            return etat;
        }
        public void setEtat(Etat etat) {
            this.etat = etat;
        }
    }
    