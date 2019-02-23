package sboj.repository;

import sboj.domein.models.entities.JobApplication;

public interface JobApplicationRepository extends GenericRepository<JobApplication,String>{
    void delete(String id);
}
