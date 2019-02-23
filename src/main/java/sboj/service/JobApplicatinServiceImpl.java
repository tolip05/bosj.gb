package sboj.service;

import org.modelmapper.ModelMapper;
import sboj.domein.models.entities.JobApplication;
import sboj.domein.models.service.JobApplicationServiceModel;
import sboj.repository.JobApplicationRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobApplicatinServiceImpl implements JobApplicationService {

    private final JobApplicationRepository repository;
    private final ModelMapper modelMapper;

    @Inject
    public JobApplicatinServiceImpl(JobApplicationRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JobApplicationServiceModel createJob(JobApplicationServiceModel job) {
        return this.modelMapper
                .map(this.repository.save(this.modelMapper.map(job, JobApplication.class))
                ,JobApplicationServiceModel.class);
    }

    @Override
    public JobApplicationServiceModel getJobById(String id) {
        return this.modelMapper
                .map(this.repository.findById(id),JobApplicationServiceModel.class);
    }

    @Override
    public List<JobApplicationServiceModel> getAllJobs() {
        return this.repository.findAll()
                .stream()
                .map(x -> this.modelMapper.map(x,JobApplicationServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJob(String id) {
      this.repository.delete(id);
    }
}
