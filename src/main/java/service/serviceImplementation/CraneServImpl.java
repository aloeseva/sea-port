package service.serviceImplementation;

import domain.entities.Crane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CraneRepo;
import service.CraneServ;

import java.util.List;

@Service
public class CraneServImpl implements CraneServ {
    private final CraneRepo craneRepo;

    @Autowired
    public CraneServImpl(CraneRepo craneRepo) {
        this.craneRepo = craneRepo;
    }

    @Override
    public void saveCrane(Crane crane) {
        craneRepo.save(crane);
    }

    @Override
    public List<Crane> getAllCranes() {
        return craneRepo.findAll();
    }
}
