package com.xiong.config.dataSource.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryDoublekill",
        transactionManagerRef="transactionManagerDoublekill",
        basePackages= { "com.xiong.dao.doublekill"}) //设置Repository所在位置
public class DoublekillJpaConfig {

    /**
     * 注入 mysql数据源
     */
    @Autowired
    @Qualifier("doublekillDataSource")
    private DataSource DoublekillDataSource;

    /**
     * 注入JPA配置实体
     */
    @Autowired
    private JpaProperties jpaProperties;

    /**
     *  这里其实不需要配置数据库的方言.
     *  像hibernate.hbm2ddl.auto 可以在这里配置.但是我的是在application.properties中配置的.
     */
    private Map<String, Object> getVendorProperties() {
        HibernateSettings hibernateSettings = new HibernateSettings();
        return jpaProperties.getHibernateProperties(hibernateSettings);
    }

    /**
     * 配置EntityManagerFactory实体
     *
     * @param builder
     * @return 实体管理工厂
     * packages     扫描@Entity注释的软件包名称
     * persistenceUnit  持久性单元的名称。 如果只建立一个EntityManagerFactory，你可以省略这个，但是如果在同一个应用程序中有多个，你应该给它们不同的名字
     * properties       标准JPA或供应商特定配置的通用属性。 这些属性覆盖构造函数中提供的任何值。
     */
    @Bean(name = "entityManagerFactoryDoublekill")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDoublekill(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(DoublekillDataSource)
                .properties(getVendorProperties())
                .packages("com.xiong.entity.doublekill")
                .persistenceUnit("DoublekillPersistenceUnit")
                .build();
    }

    /**
     * 配置EntityManager实体
     *
     * @param builder
     * @return 实体管理器
     */
    @Bean(name = "entityManagerDoublekill")
    public EntityManager entityManagerDoublekill(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryDoublekill(builder).getObject().createEntityManager();
    }

    /**
     * 配置事务transactionManager
     *
     * @param builder
     * @return 事务管理器
     */
    @Bean(name = "transactionManagerDoublekill")
    public PlatformTransactionManager transactionManagerDoublekill(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryDoublekill(builder).getObject());
    }

}
