package sboj.web.beans;

import sboj.domein.models.service.JobApplicationServiceModel;
import sboj.service.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class JobApplicationDetailBean extends BaseBean {
    private JobApplicationService jobApplicationService;

    public JobApplicationDetailBean() {
    }

    @Inject
    public JobApplicationDetailBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public JobApplicationServiceModel getJobApplication(String id){
//        String id = ((HttpServletRequest)FacesContext.getCurrentInstance()
//                .getExternalContext()
//                .getRequest()).getParameter("id");

        return this.jobApplicationService.getJobById(id);
    }
}
