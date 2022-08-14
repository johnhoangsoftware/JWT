package uet.s1mple.userservice.service;

import uet.s1mple.userservice.domain.Role;
import uet.s1mple.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
