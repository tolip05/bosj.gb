package sboj.web.beans;

import org.modelmapper.ModelMapper;
import sboj.domein.models.binding.UserRegisterBindingModel;
import sboj.domein.models.service.UserServiceModel;
import sboj.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {
    private UserRegisterBindingModel userRegisterBindingModel;

    private UserService userService;

    private ModelMapper modelMapper;

    public RegisterBean() {
    }
    @Inject
    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.userRegisterBindingModel = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return this.userRegisterBindingModel;
    }

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }

    public void register() {
        if(!this.userRegisterBindingModel.getPassword()
                .equals(this.userRegisterBindingModel.getConfirmPassword())) {
            return;
        }

        this.userService.createUser(
                this.modelMapper.map(this.userRegisterBindingModel, UserServiceModel.class));
        this.redirect("/login");
    }

}
