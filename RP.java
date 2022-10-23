package ism.inscription.entities;

public class RP extends User {

    public RP(int id, Role role, String login, String password, String nomComplet) {
        super(id, role, login, password, nomComplet);
    }

    public RP( String login, String password, String nomComplet) {
        super( login, password, nomComplet);
        role=Role.RP;
    }

    public RP() {
        role=Role.RP;
    }

    
}
