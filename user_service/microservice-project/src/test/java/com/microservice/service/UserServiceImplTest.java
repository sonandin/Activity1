package com.microservice.service;
import com.microservice.exception.UserAlreadyExistsException;
import com.microservice.exception.UserNotFoundException;
import com.microservice.model.User;
import com.microservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
       MockitoAnnotations.openMocks(userRepository);
    }

    @Test
    void testAddUser() {
        User user = new User(1L, "Nandhini", "Raju", "IT",35);
        when(userRepository.findById(user.getUserId())).thenReturn(Optional.empty());

        User addedUser = userService.add(user);
        assertEquals(user, addedUser);
    }

    @Test
    void testAddUserAlreadyExists() {
        User existingUser = new User(1L, "Nandhini", "Raju", "IT",35);
        when(userRepository.findById(existingUser.getUserId())).thenReturn(Optional.of(existingUser));

        assertThrows(UserAlreadyExistsException.class, () -> userService.add(existingUser));
    }

    @Test
    void testFindAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Nandhini", "Raju", "IT",39));
        users.add(new User(2L, "Jamuna", "Smrithi", "HR",40));
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();

        assertEquals(users.size(), result.size());
        assertEquals(users, result);
    }

    @Test
    void testUpdateUser() {
        Long userIdToUpdate = 1L;
        User updatedUser = new User(userIdToUpdate, "Nagarjuna", "King", "Finance",45);
        when(userRepository.findById(userIdToUpdate)).thenReturn(Optional.of(updatedUser));

        User result = userService.update(userIdToUpdate, updatedUser);
        
        assertEquals(updatedUser, result);
    }

    @Test
    void testUpdateUserNotFound() {
        Long userIdToUpdate = 1L;
        User updatedUser = new User(userIdToUpdate, "Nagarjuna", "King", "Finance",26);
        when(userRepository.findById(userIdToUpdate)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.update(userIdToUpdate, updatedUser));
    }

    @Test
    void testDeleteUser() {
        Long userIdToDelete = 1L;
        User userToDelete = new User(userIdToDelete, "Nandhini", "Raju", "IT",32);
        when(userRepository.findById(userIdToDelete)).thenReturn(Optional.of(userToDelete));

        User result = userService.delete(userIdToDelete);

        verify(userRepository, times(1)).deleteById(userIdToDelete);
        assertEquals(userToDelete, result);
    }

    @Test
    void testDeleteUserNotFound() {
        Long userIdToDelete = 1L;
        when(userRepository.findById(userIdToDelete)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.delete(userIdToDelete));
    }
}
