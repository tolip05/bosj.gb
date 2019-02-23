package sboj.service;

import sboj.domein.models.service.JobApplicationServiceModel;

import java.util.List;

public interface JobApplicationService {
    JobApplicationServiceModel createJob(JobApplicationServiceModel job);

    JobApplicationServiceModel getJobById(String id);

    List<JobApplicationServiceModel> getAllJobs();

    void deleteJob(String id);
}
