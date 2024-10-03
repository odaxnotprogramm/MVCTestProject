package org.sab1maru.web.mvctestproject.service;

import org.sab1maru.web.mvctestproject.dto.RegistrationDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(RegistrationDto registrationDto);
}
