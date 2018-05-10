package com.fosun.beauty.config;

import com.fosun.beauty.common.config.FosunConstants;
import com.fosun.beauty.common.config.h2.H2ConfigurationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

@Configuration
@EnableJpaRepositories("com.fosun.beauty.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class DatabaseConfiguration {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    private final Environment env;

    public DatabaseConfiguration(Environment env) {
        this.env = env;
    }

    /**
     * Open the TCP port for the H2 database, so it is available remotely.
     *
     * @return the H2 database TCP server
     * @throws SQLException if the server failed to start
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile(FosunConstants.SPRING_PROFILE_DEVELOPMENT)
    public Object h2TCPServer() throws SQLException {
        return H2ConfigurationHelper.createServer();
    }

//    @Bean
//    public SpringLiquibase liquibase(@Qualifier("taskExecutor") TaskExecutor taskExecutor,
//            DataSource dataSource, LiquibaseProperties liquibaseProperties) {
//
//        // Use liquibase.integration.spring.SpringLiquibase if you don't want Liquibase to start asynchronously
//        SpringLiquibase liquibase = new AsyncSpringLiquibase(taskExecutor, env);
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
//        liquibase.setContexts(liquibaseProperties.getContexts());
//        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
//        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
//        if (env.acceptsProfiles(FosunConstants.SPRING_PROFILE_NO_LIQUIBASE)) {
//            liquibase.setShouldRun(false);
//        } else {
//            liquibase.setShouldRun(liquibaseProperties.isEnabled());
//            log.debug("Configuring Liquibase");
//        }
//        return liquibase;
//    }
}
