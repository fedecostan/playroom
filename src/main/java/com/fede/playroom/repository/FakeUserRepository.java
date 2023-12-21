package com.fede.playroom.repository;

import com.fede.playroom.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FakeUserRepository {

    public boolean saveUser(User user) {
        return user != null;
    }
}
