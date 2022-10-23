package ism.inscription.repositories;

import ism.inscription.entities.User;

public interface IUserRepository {
    public User  findUserByLoginAndPassword(String login,String password);
}
