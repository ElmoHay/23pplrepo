package com.example._23people.demo23ppl.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@EnableJpaRepositories( entityManagerFactoryRef = "_2ndDSCoursesEntityManagerFactory", transactionManagerRef   = "_2ndDSCoursesTransactionManager")
public class _2ndDSconfig {
    /*
    @Bean
    PlatformTransactionManager _2ndDSCoursesTransactionManager()
    {
        return new JpaTransactionManager(_2ndDSCoursesEntityManagerFactory().getObject());
    }
    
    @Bean
    LocalContainerEntityManagerFactoryBean _2ndDSCoursesEntityManagerFactory()
    {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(_2ndDSCoursesDataSource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(_2ndDSconfig.class.getPackage().getName());

		return factoryBean;
	}
    
    @Bean
    DataSource _2ndDSCoursesDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        return dataSourceBuilder.create().build();
        
    }
    */
}