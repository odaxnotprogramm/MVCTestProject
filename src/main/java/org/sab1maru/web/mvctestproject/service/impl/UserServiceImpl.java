package org.sab1maru.web.mvctestproject.service.impl;

import org.sab1maru.web.mvctestproject.dto.RegistrationDto;
import org.sab1maru.web.mvctestproject.models.UserEntity;
import org.sab1maru.web.mvctestproject.repository.RoleRepository;
import org.sab1maru.web.mvctestproject.repository.UserRepository;
import org.sab1maru.web.mvctestproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sab1maru.web.mvctestproject.models.Role;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
