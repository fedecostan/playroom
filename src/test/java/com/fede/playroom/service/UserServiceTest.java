package com.fede.playroom.service;

import com.fede.playroom.model.User;
import com.fede.playroom.repository.FakeUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private FakeUserRepository fakeUserRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    void test_object() {
        final String NAME = "Federico";
        final String LASTNAME = "Costantino";

        when(fakeUserRepository.saveUser(eq(User.builder().name(NAME).lastname(LASTNAME).build()))).thenReturn(true);

        boolean response = userService.saveUser(NAME, LASTNAME);

        assertTrue(response);
    }

    @Test
    void test_any() {
        when(fakeUserRepository.saveUser(any(User.class))).thenReturn(true);

        boolean response = userService.saveUser("Federico", "Costantino");

        assertTrue(response);
    }

    @Test
    void test_captor() {
        when(fakeUserRepository.saveUser(userCaptor.capture())).thenReturn(true);

        boolean response = userService.saveUser("Federico", "Costantino");

        assertTrue(response);
        User userSaved = userCaptor.getValue();
        Assertions.assertEquals("Federico", userSaved.getName());
        Assertions.assertEquals("Costantino", userSaved.getLastname());
    }

}