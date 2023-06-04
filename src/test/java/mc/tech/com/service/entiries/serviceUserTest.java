package mc.tech.com.service.entiries;

import lombok.extern.slf4j.Slf4j;
import mc.tech.com.domain.user;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class serviceUserTest {

    @Autowired
    private serviceUser service;
    user user1=new user("dray","dray@gmail.com","0814783125","2345654","ROSE ROAD");
    user user2=new user("Franck","franck@gmail.com","0876543123","56789","ROSE ROAD");
    @Test
    void save() {
        this.service.save(user1);
        this.service.save(user2);
    }
}