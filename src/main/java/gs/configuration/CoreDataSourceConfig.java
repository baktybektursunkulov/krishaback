package gs.configuration;

import com.zaxxer.hikari.HikariDataSource;
import model.core.dbtables.C_Bin_File_Body;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "gs.repositories.core.dbtables",
  entityManagerFactoryRef = "coreEntityManagerFactory",
  transactionManagerRef = "coreTransactionManager")
public class CoreDataSourceConfig {

  /**
   * Here it will get url, username, password and driver-class-name which we
   * have defined in application properties file for core.
   *
   * @return
   */
  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.core")
  public DataSourceProperties coreDatasourceProperties() {
    return new DataSourceProperties();
  }

  /**
   * Create the datasource using coreDatasourceProperties
   *
   * @return
   */
  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.core.configuration")
  public DataSource coreDataSource() {
    return coreDatasourceProperties().initializeDataSourceBuilder()
      .type(HikariDataSource.class).build();
  }

  /**
   * EntityManager will find Entity classes inside this company package (i.e
   * com.techgeeknext.entities.core.Employee).
   *
   * @param builder
   * @return
   */
  @Primary
  @Bean(name = "coreEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean coreEntityManagerFactory(EntityManagerFactoryBuilder builder) {
    return builder
      .dataSource(coreDataSource())
      // for specifying package .packages("com.techgeeknext.entities.core.type")
      .packages(C_Bin_File_Body.class)
      .build();
  }

  @Primary
  @Bean
  public PlatformTransactionManager coreTransactionManager(final @Qualifier("coreEntityManagerFactory") LocalContainerEntityManagerFactoryBean coreEntityManagerFactory) {
    return new JpaTransactionManager(coreEntityManagerFactory.getObject());
  }
}
