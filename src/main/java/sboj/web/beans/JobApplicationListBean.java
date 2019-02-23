package sboj.web.beans;

import org.modelmapper.ModelMapper;
import sboj.domein.models.binding.JobApplicationCreateBindingModel;
import sboj.domein.models.service.JobApplicationServiceModel;
import sboj.service.JobApplicationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class JobApplicationListBean extends BaseBean {
    private JobApplicationService jobApplicationsService;

    private List<JobApplicationServiceModel> jobApplications;

    public JobApplicationListBean() {
    }

    @Inject
    public JobApplicationListBean(JobApplicationService jobApplicationsService) {
        this.jobApplicationsService = jobApplicationsService;
    }

    @PostConstruct
    public void init() {
        this.setJobApplications(this.jobApplicationsService.getAllJobs());
        this.getJobApplications().forEach(x -> x.setSector(x.getSector().toLowerCase()));
    }

    public List<JobApplicationServiceModel> getJobApplications() {
        return this.jobApplications;
    }

    public void setJobApplications(List<JobApplicationServiceModel> jobApplications) {
        this.jobApplications = jobApplications;
    }

}
