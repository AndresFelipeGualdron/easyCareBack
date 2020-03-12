package edu.eci.arsw.easycare.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.eci.arsw.data.dao.*;
import edu.eci.arsw.data.dao.mybatis.*;
import edu.eci.arsw.data.dao.mybatis.mappers.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
@MapperScan( basePackages = "edu.eci.arsw.data.dao.mybatis.mappers")
public class MyBatisConfigurationTest {

    private static final String TEST_SESSION_FACTORY = "testSessionFactory";



    @Bean(name = TEST_SESSION_FACTORY, destroyMethod = "")
    public SqlSessionFactoryBean testSqlSessionFactory(@Named(ConfigurationDB.SECONDARY_DATASOURCE) final DataSource dataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(ClienteMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(MascotaMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseadorMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseoMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(SubastaMapper.class);
        // Various other SqlSessionFactory settings
        return sqlSessionFactoryBean;
    }

    @Bean(name = "clientMapperTest")
    public MapperFactoryBean<ClienteMapper> clienteMapper(@Named(TEST_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<ClienteMapper> factoryBean = new MapperFactoryBean<>(ClienteMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean(name = "mascotaMapperTest")
    public MapperFactoryBean<MascotaMapper> mascotaMapper(@Named(TEST_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<MascotaMapper> factoryBean = new MapperFactoryBean<>(MascotaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean(name = "paseadorMapperTest")
    public MapperFactoryBean<PaseadorMapper> paseadorMapper(@Named(TEST_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseadorMapper> factoryBean = new MapperFactoryBean<>(PaseadorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean(name = "paseoMapperTest")
    public MapperFactoryBean<PaseoMapper> paseoMapper(@Named(TEST_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseoMapper> factoryBean = new MapperFactoryBean<>(PaseoMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean(name = "subastaMapperTest")
    public MapperFactoryBean<SubastaMapper> subastaMapper(@Named(TEST_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<SubastaMapper> factoryBean = new MapperFactoryBean<>(SubastaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean(name = "clienteDAOTest")
    public ClienteDAO clienteDAO(){
        return new MyBatisClienteDAOTest();
    }

    @Bean("mascotaDAOTest")
    public MascotaDAO mascotaDAO(){
        return new MyBatisMascotaDAO();
    }

    @Bean("paseadorDAOTest")
    public PaseadorDAO paseadorDAO(){
        return new MyBatisPaseadorDAO();
    }

    @Bean("paseoDAOTest")
    public PaseoDAO paseoDAO(){
        return new MyBatisPaseoDAO();
    }

    @Bean("subastaDAOTest")
    public SubastaDAO subastaDAO(){
        return new MyBatisSubastaDAO();
    }


}
