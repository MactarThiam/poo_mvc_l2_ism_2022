package ism.inscription.entities;

public class User {
    
    
    
    protected int id;
    protected Role role;
    protected String login;
    protected String password;
    protected String nomComplet;


    protected Classe classe;

    public Classe getClasse() {
        return classe;
    }


    public void setClasse(Classe classe) {
        this.classe = classe;
    }


    public User(int id, Role role, String login, String password, String nomComplet) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
    }

    
    public User(Role role, String login, String password, String nomComplet) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
    }



    public User(int id,  String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }



    public User( String login, String password, String nomComplet) {
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
    }



    public User() {
    }


    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }
}
