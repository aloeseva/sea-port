package service;

import domain.entities.Crane;

import java.util.List;

public interface CraneServ {
    void saveCrane(Crane crane);

    List<Crane> getAllCranes();
}
