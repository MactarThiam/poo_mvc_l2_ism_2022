package ism.inscription.entities;

public class Classe {

    private int id;
    private String libelle;



    private Professeur professeur;
    

    public Classe(int id) {
        this.id = id;
    }

    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Classe(String libelle) {
        this.libelle = libelle;
    }

    public Classe() {
    }

    

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Classe [id=" + id + ", libelle=" + libelle + "]";
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}

    

