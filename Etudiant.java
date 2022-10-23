package ism.inscription.entities;



public class Etudiant  {
    private int id;
    private String matricule;
    private String nomComplet;
    private String tuteur;






    
    public Etudiant(int id, String matricule, String nomComplet, String tuteur) {
        this.id = id;
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        
    }


    public Etudiant(String matricule, String nomComplet, String tuteur) {
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
    }


    public Etudiant() {
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }


    @Override
    public String toString() {
        return "Etudiant [id=" + id + ", matricule=" + matricule + ", nomComplet=" + nomComplet + ", tuteur=" + tuteur
                + "]";
    }

    
}
