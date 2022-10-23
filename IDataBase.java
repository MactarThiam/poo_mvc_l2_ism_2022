package ism.inscription.entities.core;

import java.sql.ResultSet;

public interface IDataBase {
    public void ouvirConnexionBD();
    public void fermerConnexionBD();
    public void prepareRequete(String sql);
    public int executeMiseAJour();
    public ResultSet executeSelect();
}
