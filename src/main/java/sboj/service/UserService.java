package sboj.service;

import sboj.domein.models.entities.User;
import sboj.domein.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel createUser(UserServiceModel userServiceModel);

    UserServiceModel getUserById(String id);

    UserServiceModel getUserByUsername(String username);
}
