package com.sachida.barter.service;

import com.sachida.barter.datasource.model.User;
import com.sachida.barter.datasource.repository.UserRepository;
import com.sachida.barter.rest.api.user.NewPassRequestDTO;
import com.sachida.barter.rest.api.user.UserDTO;
import com.sachida.barter.rest.api.user.UserRequestDTO;
import com.sachida.barter.rest.api.exception.BarterNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.sachida.barter.asserts.ThrowableAssertion.assertThrown;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User savedUser = new User();

    @Before
    public void setUp() {
        initMocks(this);

        savedUser.setName("Federico");
        savedUser.setPass("UnaPassQueTenga4Cosas!");
        savedUser.setId("34");
        savedUser.setMail("mail@mail");
        savedUser.setDni(1234L);
    }


    @Test
    public void createUser() {
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserRequestDTO request = new UserRequestDTO("Federico","UnaPassQueTenga4Cosas!", "mail@mail", 1234L);

        UserDTO user = userService.createUser(request);

        assertEquals("34", user.getId());
        assertEquals("UnaPassQueTenga4Cosas!", user.getPass());
        assertEquals("Federico", user.getName());
        assertEquals("mail@mail", user.getMail());
        assertEquals(Long.valueOf(1234), user.getDni());
        verify(userRepository, times(1)).save(any());
        verify(userRepository, times(1)).findByMail(any());
        verify(userRepository, times(1)).findByDni(any());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void deleteUser_nonExist() {
        when(userRepository.findById("34")).thenReturn(Optional.empty());

        assertThrown(() -> userService.deleteUser("34"))
                .isInstanceOf(BarterNotFoundException.class)
                .hasMessage("34 is not a user id");
        verify(userRepository).findById(any());
        verify(userRepository, times(0)).deleteById(any());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void deleteUser_ok() {
        when(userRepository.findById("34")).thenReturn(Optional.of(savedUser));

        userService.deleteUser("34");

        verify(userRepository).findById(any());
        verify(userRepository).deleteById(any());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void getUser() {
        when(userRepository.findById("34")).thenReturn(Optional.of(savedUser));

        UserDTO user = userService.getUser("34");

        assertEquals("34", user.getId());
        assertEquals("UnaPassQueTenga4Cosas!", user.getPass());
        assertEquals("Federico", user.getName());
        verify(userRepository, times(1)).findById(any());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void modifyPass() {
        when(userRepository.findById("34")).thenReturn(Optional.of(savedUser));

        User modifiedUser = new User();
        modifiedUser.setName("Federico");
        modifiedUser.setPass("NuevaPassQueTiene4Cosas!");
        modifiedUser.setId("34");
        modifiedUser.setDni(1234L);
        modifiedUser.setMail("mail@mail");

        when(userRepository.save(any())).thenReturn(modifiedUser);

        NewPassRequestDTO modifyPass = new NewPassRequestDTO("UnaPassQueTenga4Cosas!", "NuevaPassQueTiene4Cosas!");
        UserDTO userDTO = userService.modifyPass("34", modifyPass);

        assertEquals("34", userDTO.getId());
        assertEquals("NuevaPassQueTiene4Cosas!", userDTO.getPass());
        assertEquals("Federico", userDTO.getName());
        assertEquals("mail@mail", userDTO.getMail());
        assertEquals(Long.valueOf(1234), userDTO.getDni());
    }
}
