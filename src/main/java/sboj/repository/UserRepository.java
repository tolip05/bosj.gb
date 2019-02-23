package sboj.repository;

import sboj.domein.models.entities.User;

public interface UserRepository extends GenericRepository<User,String> {

    User findByUsername(String username);
}
