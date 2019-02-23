package sboj.repository;

import sboj.domein.models.entities.JobApplication;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobApplicationRepositoryImpl extends BaseRepository implements JobApplicationRepository {


    @Inject
    public JobApplicationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

//    @Override
//    public void delete(String id) {
//         this.executeTransaction(em->{
//            return em.createQuery
//                    ("DELETE FROM job_applications j WHERE j.id =: id",JobApplication.class)
//                    .setParameter("id",id).executeUpdate();
//
//         });
//    }
@Override
public void delete(String id) {
    this.executeTransaction((em) -> {
        em.createNativeQuery("DELETE FROM job_applications WHERE id='" + id + "'").executeUpdate();
        return null;
    });
}


    @Override
    public JobApplication save(JobApplication jobApplication) {
        return this.executeTransaction(em ->{
            em.persist(jobApplication);
            return jobApplication;
        });
    }

    @Override
    public List<JobApplication> findAll() {
        return this.executeTransaction(em -> {
            return em.createQuery("SELECT u FROM job_applications u", JobApplication.class)
                    .getResultList();
        });
    }

    @Override
    public JobApplication findById(String id) {
        return this.executeTransaction(em -> {
            return em.createQuery("SELECT u FROM job_applications u WHERE u.id =: id", JobApplication.class)
                    .setParameter("id", id)
                    .getSingleResult();
        });
    }
}
