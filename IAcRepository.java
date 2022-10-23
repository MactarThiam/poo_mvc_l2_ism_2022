package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.AC;

public interface IAcRepository {

    public List<AC> findAll();
    public AC insert (AC ac);
    public AC findById(int id);
}


