package com.fede.playroom.service;

import com.fede.playroom.model.User;
import com.fede.playroom.repository.FakeUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final FakeUserRepository fakeUserRepository;

    public boolean saveUser(String name, String lastname) {
        return fakeUserRepository.saveUser(User.builder()
                .name(name)
                .lastname(lastname)
                .build());
    }
}
