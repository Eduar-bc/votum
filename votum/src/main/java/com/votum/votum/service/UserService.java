package com.votum.votum.service;

import com.votum.votum.model.Role;
import com.votum.votum.model.User;
import com.votum.votum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User becomeCreator(User u){
        Set<Role> roles = u.getRoles();
        if (!roles.contains(Role.ROLE_ELECTION_ADMIN)){
            roles.add(Role.ROLE_ELECTION_ADMIN);
            u.setRoles(roles);
            userRepository.save(u);
        }
        return u;
    }
}
