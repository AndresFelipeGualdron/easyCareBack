package edu.eci.arsw.easycare.config;


import edu.eci.arsw.data.dao.*;
import edu.eci.arsw.data.dao.mybatis.*;
import edu.eci.arsw.data.dao.mybatis.mappers.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.inject.Named;

@Configuration
@MapperScan( basePackages = "edu.eci.arsw.data.dao.mybatis.mappers")
public class MyBatisConfiguration {



    private static final String PRINCIPAL_SESSION_FACTORY = "principalSessionFactory";


    @Bean(name = PRINCIPAL_SESSION_FACTORY, destroyMethod = "")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactoryPrimary(@Named(ConfigurationDB.PRIMARY_DATASOURCE) final DataSource principalDataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(principalDataSource);
        SqlSessionFactory sqlSessionFactory;
        sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(ClienteMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(MascotaMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseadorMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseoMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(SubastaMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(RutaMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(UbicacionMapper.class);
        sqlSessionFactory.getConfiguration().addMapper(PaseoEnCursoMapper.class);
        // Various other SqlSessionFactory settings
        return sqlSessionFactoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<ClienteMapper> clienteMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<ClienteMapper> factoryBean = new MapperFactoryBean<>(ClienteMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<MascotaMapper> mascotaMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<MascotaMapper> factoryBean = new MapperFactoryBean<>(MascotaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<PaseadorMapper> paseadorMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseadorMapper> factoryBean = new MapperFactoryBean<>(PaseadorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<PaseoMapper> paseoMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseoMapper> factoryBean = new MapperFactoryBean<>(PaseoMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<SubastaMapper> subastaMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<SubastaMapper> factoryBean = new MapperFactoryBean<>(SubastaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<RutaMapper> rutaMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<RutaMapper> factoryBean = new MapperFactoryBean<>(RutaMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<UbicacionMapper> ubicacionMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<UbicacionMapper> factoryBean = new MapperFactoryBean<>(UbicacionMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<PaseoEnCursoMapper> paseoEnCursoMapper(@Named(PRINCIPAL_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<PaseoEnCursoMapper> factoryBean = new MapperFactoryBean<>(PaseoEnCursoMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean
    @Primary
    public ClienteDAO clienteDAO(){
        return new MyBatisClienteDAO();
    }

    @Bean
    @Primary
    public MascotaDAO mascotaDAO(){
        return new MyBatisMascotaDAO();
    }

    @Bean
    @Primary
    public PaseadorDAO paseadorDAO(){
        return new MyBatisPaseadorDAO();
    }

    @Bean
    @Primary
    public PaseoDAO paseoDAO(){
        return new MyBatisPaseoDAO();
    }

    @Bean
    @Primary
    public SubastaDAO subastaDAO(){
        return new MyBatisSubastaDAO();
    }

    @Bean
    @Primary
    public RutaDAO rutaDAO(){
        return new MyBatisRutaDAO();
    }

    @Bean
    @Primary
    public UbicacionDAO ubicacionDAO(){
        return new MyBatisUbicacionDAO();
    }

    @Bean
    @Primary
    public PaseoEnCursoDAO paseoEnCursoDAO(){
        return new MyBatisPaseoEnCursoDAO();
    }


}
