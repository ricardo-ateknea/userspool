package com.ateknea.user.userspool.controller;

import com.ateknea.user.userspool.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserController userController;

    @Test
    public void getAllUsers() throws Exception {
        List<User> allUsers = new ArrayList<>();
        User user = new User();
        user.setEmail("philiph.fry@test.com");
        user.setName("Philip J.");
        user.setLastname("Fry");
        user.setStatus(true);
        allUsers.add(user);
        user = new User();
        user.setEmail("turanga.leela@test.com");
        user.setName("Turanga");
        user.setLastname("Leela");
        user.setStatus(true);
        allUsers.add(user);
        user = new User();
        user.setEmail("bender.rodriguez@test.com");
        user.setName("Bender B.");
        user.setLastname("Rodriguez");
        user.setStatus(false);
        allUsers.add(user);
        user = new User();
        user.setEmail("amy.wong@test.com");
        user.setName("Amy");
        user.setLastname("Wong");
        user.setStatus(true);
        allUsers.add(user);

        given(userController.userList()).willReturn(allUsers);

        mvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(allUsers.size())))
                .andExpect(jsonPath("$[0].name", is("Philip J.")))
                .andExpect(jsonPath("$[1].name", is("Turanga")))
                .andExpect(jsonPath("$[2].name", is("Bender B.")))
                .andExpect(jsonPath("$[3].name", is("Amy")));
    }

    @Test
    public void retrieveUser() throws Exception{
        User user = new User();
        user.setEmail("turanga.leela@test.com");
        user.setName("Turanga");
        user.setLastname("Leela");
        user.setStatus(true);

        given(userController.retrieveUser(2)).willReturn(user);

        mvc.perform(get("/users/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastname", is("Leela")));
    }

    @Test
    public void createUser() throws Exception {

        mvc.perform(post("/users")
                .content("{\"name\":\"Turanga\",\"lastname\":\"Leela\",\"status\":true,\"email\":\"turanga.leela@test.com\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
