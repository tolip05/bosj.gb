package sboj.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

public abstract class BaseBean {

    protected void redirect(String url){
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/jsf" + url +".jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
