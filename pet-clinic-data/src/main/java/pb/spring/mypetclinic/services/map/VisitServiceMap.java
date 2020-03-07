package pb.spring.mypetclinic.services.map;

import pb.spring.mypetclinic.model.Visit;
import pb.spring.mypetclinic.repositories.VisitRepository;
import pb.spring.mypetclinic.services.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceMap(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();

    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if(
        visit.getPet() == null || visit.getPet().getOwner() == null||
        visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null)
        {
        throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
