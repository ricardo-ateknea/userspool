package com.ateknea.user.userspool.repository;

import com.ateknea.user.userspool.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void initialize() {
        User user = new User();
        user.setEmail("philiph.fry@test.com");
        user.setName("Philip J.");
        user.setLastname("Fry");
        user.setStatus(true);
        User genericEntity = userRepository.save(user);

        user = new User();
        user.setEmail("turanga.leela@test.com");
        user.setName("Turanga");
        user.setLastname("Leela");
        user.setStatus(true);
        genericEntity = userRepository.save(user);

        user = new User();
        user.setEmail("bender.rodriguez@test.com");
        user.setName("Bender B.");
        user.setLastname("Rodriguez");
        user.setStatus(false);
        genericEntity = userRepository.save(user);

        user = new User();
        user.setEmail("amy.wong@test.com");
        user.setName("Amy");
        user.setLastname("Wong");
        user.setStatus(true);
        genericEntity = userRepository.save(user);
    }

    @After
    public void removeDB() {
        userRepository.deleteAll();
    }

    @Test
    public void givenGenericEntityRepository_listAll_thenOK() {
        List<User> foundEntities = userRepository.findAll();

        assertNotNull(foundEntities);
        assertEquals(foundEntities.size(), userRepository.count());
    }

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity() {
        User user = new User();
        user.setEmail("hermes.conrad@test.com");
        user.setName("Hermes");
        user.setLastname("Conrad");
        user.setStatus(true);
        User genericEntity = userRepository.save(user);
        User foundEntity = userRepository.findOne(genericEntity.getId());

        assertNotNull(foundEntity);
        assertEquals(genericEntity.getEmail(), foundEntity.getEmail());
    }
}
