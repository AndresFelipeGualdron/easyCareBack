package edu.eci.arsw.easycare.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

@Configuration
public class ConfigurationDB {

    public static final String PRIMARY_DATASOURCE = "PrincipalDS";
    public static final String SECONDARY_DATASOURCE = "TestDS";

    @Bean(name = PRIMARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "datasources.principal")
    @Primary
    public DataSource dataSourceOne (){
        return new HikariDataSource();
    }


    @Bean(name = SECONDARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "datasources.test")
    public DataSource dataSourceTest(){
        return new HikariDataSource();
    }
}

