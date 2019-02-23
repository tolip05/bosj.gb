package sboj.web.beans;

import org.modelmapper.ModelMapper;
import sboj.domein.models.binding.JobApplicationCreateBindingModel;
import sboj.domein.models.service.JobApplicationServiceModel;
import sboj.service.JobApplicationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JobApplicationCreateBean extends BaseBean {
    private JobApplicationCreateBindingModel jobApplicationModel;
    private JobApplicationService jobApplicationService;
    private ModelMapper modelMapper;

    public JobApplicationCreateBean() {
    }

    @Inject
    public JobApplicationCreateBean(JobApplicationService jobApplicationService,ModelMapper modelMapper) {
        this.jobApplicationService = jobApplicationService;
        this.modelMapper = modelMapper;
    }
    @PostConstruct
    public void init(){
        this.jobApplicationModel = new JobApplicationCreateBindingModel();
    }

    public JobApplicationCreateBindingModel getJobApplicationModel() {
        return this.jobApplicationModel;
    }

    public void setJobApplicationModel(JobApplicationCreateBindingModel jobApplicationModel) {
        this.jobApplicationModel = jobApplicationModel;
    }

    public void createJobApplication(){
        this.jobApplicationService.createJob(this.modelMapper
                .map(this.jobApplicationModel, JobApplicationServiceModel.class));


        this.redirect("/home");
    }
}
