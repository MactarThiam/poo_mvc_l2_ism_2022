package ism.inscription.repositories.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import ism.inscription.entities.Classe;
import ism.inscription.entities.Role;
import ism.inscription.entities.User;
import ism.inscription.entities.core.MysqlDb;
import ism.inscription.repositories.IUserRepository;

public class UserRepository extends MysqlDb implements IUserRepository {

        private final String SQL_CONNECT = "SELECT * FROM `user` WHERE `login` LIKE ? and `password` LIKE ?";
    
        public User findUserByLoginAndPassword(String login,String password){
    
            User user = null;
            ResultSet rs=null;
    
            this.ouvirConnexionBD();
            this.prepareRequete(SQL_CONNECT);
            rs=this.executeSelect();
            try {
                this.getPs().setString(1, login);
                this.getPs().setString(2, password);
                rs=this.executeSelect();
                             if (rs.next()) {
                user=new User(rs.getInt("id"),
                            rs.getString("role").compareTo("AC")==0? Role.AC : Role.RP,
                            rs.getString("login"),
                            rs.getString("password"),
                            rs.getString("nomcomplet")); 
                            
                    
                   }
            
    
            } catch (SQLException e) {
    
                e.printStackTrace();
    
            }
    
            this.fermerConnexionBD();
    
            return user;
            
        }
        
    }

