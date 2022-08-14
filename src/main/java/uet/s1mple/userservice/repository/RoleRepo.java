package uet.s1mple.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uet.s1mple.userservice.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
