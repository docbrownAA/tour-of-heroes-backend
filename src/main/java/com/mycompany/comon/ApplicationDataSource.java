package com.mycompany.comon;

import com.jolbox.bonecp.BoneCPDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author gduvinage
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationDataSource {
    @Autowired
    Environment environment;
    
    @Bean
    public DataSource dataSource(){
        BoneCPDataSource dataSource = new BoneCPDataSource();
        
        dataSource.setDriverClass(environment.getRequiredProperty("spring.datasource.driverClassName"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        
        return dataSource;
    }
}
