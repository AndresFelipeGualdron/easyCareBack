package edu.eci.arsw.easycare;

import edu.eci.arsw.data.dao.mybatis.PersistenceException;
import edu.eci.arsw.easycare.config.ConfigurationDB;
import edu.eci.arsw.easycare.config.MyBatisConfiguration;
import edu.eci.arsw.easycare.config.MyBatisConfigurationTest;
import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import edu.eci.arsw.easycare.service.impl.EasyCareServiceImpl;
import edu.eci.arsw.easycare.service.impl.EasyCareServiceImplTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.Context;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SpringBootTest()
class EasycareApplicationTests {

    @Autowired
    @Qualifier("test")
    EasyCareService service;


    @Test
    public void probando(){
        try {
            List<Cliente> clientes = service.getAllClintes();
            System.out.println(clientes.size());
            fail("se esperaba una excepcion, ya que no se ha agregado ningun cliente");
            assertTrue(false);
        } catch (ExceptionServiciosEasyCare e) {
            System.out.println("sisas");
        }

    }

}
