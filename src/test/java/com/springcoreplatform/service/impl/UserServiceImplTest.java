package com.springcoreplatform.service.impl;

import com.springcoreplatform.io.entity.UserEntity;
import com.springcoreplatform.io.repositories.UserRepository;
import com.springcoreplatform.shared.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUser_UserEntityNull() {

        Mockito.when(userRepository.findByEmail(anyString()))
                .thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.getUser("abc@abc.abc"));
    }

    @Test
    void getUser_UserEntityNotNull() {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("654");
        userEntity.setEmail("a@a.a");
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
        userEntity.setEncryptedPassword("123");

        Mockito.when(userRepository.findByEmail(anyString()))
                .thenReturn(userEntity);

        UserDto userDto = userServiceImpl.getUser("a@a.a");

        assertNotNull(userDto);
        assertEquals(userEntity.getUserId(), userDto.getUserId());
    }
}