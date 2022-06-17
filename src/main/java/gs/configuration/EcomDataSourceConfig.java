
package gs.configuration;


import com.zaxxer.hikari.HikariDataSource;
import model.ecom.dbtables.Bin_File_Body;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "gs.repositories.ecom.dbtables",
        entityManagerFactoryRef = "ecomEntityManagerFactory",
        transactionManagerRef = "ecomTransactionManager")
public class EcomDataSourceConfig {

    /**
     * Here it will get url, username, password and driver-class-name
     * which we have defined in application properties file for ecom.
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.ecom")
    public DataSourceProperties ecomDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Create the datasource using ecomDataSourceProperties
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.ecom.configuration")
    public DataSource ecomDataSource() {
        return ecomDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    /**
     * EntityManager will find Entity classes inside this ecom package
     * (i.e com.techgeeknext.entities.ecom.Company).
     * @param builder
     * @return
     */
    @Bean(name = "ecomEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ecomEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ecomDataSource())
                .packages(Bin_File_Body.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager ecomTransactionManager(
            final @Qualifier("ecomEntityManagerFactory") LocalContainerEntityManagerFactoryBean ecomEntityManagerFactory) {
        return new JpaTransactionManager(ecomEntityManagerFactory.getObject());
    }

}