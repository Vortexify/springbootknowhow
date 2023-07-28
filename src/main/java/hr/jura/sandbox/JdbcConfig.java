package hr.jura.sandbox;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("primaryDS")
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource primaryHikariDataSource() {
        HikariDataSource ds = primaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
        ds.setConnectionInitSql("alter session set nls_sort=GENERIC_M_CI");
        return ds;
    }

    @Bean("primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDS") DataSource ds) {
        JdbcTemplate template = new JdbcTemplate(ds);
        template.setQueryTimeout(120);
        return template;
    }

    @Bean("namedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("primaryDS") DataSource ds) {
        JdbcTemplate template = new JdbcTemplate(ds);
        template.setQueryTimeout(120);
        return new NamedParameterJdbcTemplate(template);

    }

}
