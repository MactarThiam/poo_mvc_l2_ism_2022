package ism.inscription.entities;

public class AC extends User{

    public AC(int id, Role role, String login, String password, String nomComplet) {
        super(id, role, login, password, nomComplet);
    }

    public AC( String login, String password, String nomComplet) {
        super( login, password, nomComplet);
        role=Role.AC;
    }

    public AC() {
        role=Role.AC;
    }
    
}
