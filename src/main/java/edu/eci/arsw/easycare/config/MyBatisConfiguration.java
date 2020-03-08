package edu.eci.arsw.easycare.config;


import edu.eci.arsw.data.dao.mybatis.mappers.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.inject.Named;

@Configuration
public class MyBatisConfiguration {
    private static final String PRINCIPAL_SESSION_FACTORY = "principalSessionFactory";
    private static final String TEST_SESSION_FACTORY = "testSessionFactory";

    @Bean(name = PRINCIPAL_SESSION_FACTORY, destroyMethod = "")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(@Named(ConfigurationDB.PRIMARY_DATASOURCE) final DataSource principalDataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(principalDataSource);
        SqlSessionFactory sqlSessionFactory;
        sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(ClienteMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(MascotaMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseadorMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseoMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(SubastaMapper.class);
        // Various other SqlSessionFactory settings
        return sqlSessionFactoryBean;
    }

    @Bean(name = TEST_SESSION_FACTORY, destroyMethod = "")
    public SqlSessionFactoryBean testSqlSessionFactory(@Named(ConfigurationDB.SECONDARY_DATASOURCE) final DataSource testDataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(testDataSource);
        final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(ClienteMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(MascotaMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseadorMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseoMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(SubastaMapper.class);
        // Various other SqlSessionFactory settings
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperFactoryBean<ClienteMapper> clienteMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<ClienteMapper> factoryBean = new MapperFactoryBean<>(ClienteMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<MascotaMapper> mascotaetrMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<MascotaMapper> factoryBean = new MapperFactoryBean<>(MascotaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<PaseadorMapper> paseadorMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseadorMapper> factoryBean = new MapperFactoryBean<>(PaseadorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<PaseoMapper> paseoMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseoMapper> factoryBean = new MapperFactoryBean<>(PaseoMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<SubastaMapper> subastaMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<SubastaMapper> factoryBean = new MapperFactoryBean<>(SubastaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }


//    TESTS





}
