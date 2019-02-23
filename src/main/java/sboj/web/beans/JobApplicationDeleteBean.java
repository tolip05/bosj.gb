package sboj.web.beans;

import sboj.domein.models.service.JobApplicationServiceModel;
import sboj.service.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class JobApplicationDeleteBean extends BaseBean{
    private JobApplicationService jobApplicationService;


    public JobApplicationDeleteBean() {
    }

    @Inject
    public JobApplicationDeleteBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public JobApplicationServiceModel getJobApplication(String id){

        JobApplicationServiceModel result = this.jobApplicationService.getJobById(id);
        return result;
    }



    public JobApplicationService getJobApplicationService() {
        return this.jobApplicationService;
    }

    public void setJobApplicationService(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public void delete(){
        String id = ((HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest()).getParameter("id");
     this.jobApplicationService.deleteJob(id);
     this.redirect("/home");
    }
}
