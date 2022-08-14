package uet.s1mple.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uet.s1mple.userservice.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
