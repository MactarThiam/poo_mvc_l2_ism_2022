package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.RP;

public interface IRpRepository {
    public List<RP> findAll();
    public RP insert (RP rp);
    public RP findById(int id);
}

    

