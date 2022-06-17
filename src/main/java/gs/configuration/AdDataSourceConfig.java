
package gs.configuration;


import com.zaxxer.hikari.HikariDataSource;
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
import model.ad.dbtables.Ad_Cat;

@Configuration
@EnableJpaRepositories(basePackages = "gs.repositories.ad.dbtables",
        entityManagerFactoryRef = "adEntityManagerFactory",
        transactionManagerRef = "adTransactionManager")
public class AdDataSourceConfig {

    /**
     * Here it will get url, username, password and driver-class-name
     * which we have defined in application properties file for ca.
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.core")
    public DataSourceProperties adDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * Create the datasource using caDataSourceProperties
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.core.configuration")
    public DataSource adDataSource() {
        return adDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    /**
     * EntityManager will find Entity classes inside this ca package
     * (i.e com.techgeeknext.entities.ca.Company).
     * @param builder
     * @return
     */
    @Bean(name = "adEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean adEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(adDataSource())
                .packages(Ad_Cat.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager adTransactionManager(
            final @Qualifier("adEntityManagerFactory") LocalContainerEntityManagerFactoryBean adEntityManagerFactory) {
        return new JpaTransactionManager(adEntityManagerFactory.getObject());
    }

}