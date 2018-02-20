package com.ateknea.user.userspool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserspoolApplicationTests {
    @Test
    public void contextLoads() {
    }

//    @Test
//    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenWRONG() {
//        User user = new User();
//        user.setEmail("zapp.brannigan@test.com");
//        user.setName("Zapp");
//        user.setLastname("Brannigan");
//        user.setStatus(true);
//        User genericEntity = userRepository.save(user);
//        userRepository = PowerMockito.mock(UserRepository.class);
//        PowerMockito.when(userRepository.save(user)).thenThrow(new DuplicateKeyException("Duplicated"));
//        User foundEntity = userRepository.save(user);
//
//        assertNotNull(foundEntity);
//        assertNotEquals(genericEntity.getEmail(), foundEntity.getEmail());
//    }

}
