package cn.gaohank.idea.j2ee.jpa.dao;

import cn.gaohank.idea.j2ee.jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-dev.properties")
public class PlayersDaoTest {
    @Autowired
    private PlayersDao playersDao;

    @Test
    public void getName() {
        String name = playersDao.getName(83);
        assertEquals("Hope", name);
    }
}