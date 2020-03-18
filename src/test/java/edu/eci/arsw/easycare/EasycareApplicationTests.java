package edu.eci.arsw.easycare;

import edu.eci.arsw.easycare.service.EasyCareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;


@SpringBootTest()
class EasycareApplicationTests {

    @Autowired
    @Qualifier("test")
    EasyCareService service;



    @Test
    public void deberiaAutenticar(){

    }

}
