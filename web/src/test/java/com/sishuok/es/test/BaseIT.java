package com.sishuok.es.test;

import com.sishuok.es.common.entity.AbstractEntity;
import com.sishuok.es.common.entity.BaseEntity;
import com.sishuok.es.common.service.BaseService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-14 下午4:25
 * <p>Version: 1.0
 */

@ContextConfiguration(locations = {
        "classpath:spring-common.xml",
        "classpath:spring-config.xml",
        "classpath:spring-cache.xml",
        "classpath:spring-shiro.xml"
        })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseIT extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    protected EntityManager entityManager;

    protected String nextRandom() {
        return System.currentTimeMillis() + RandomStringUtils.randomNumeric(5);
    }

    protected void flush() {
        entityManager.flush();
    }
    protected void clear() {
        entityManager.flush();
        entityManager.clear();
    }

    protected void deleteAll(List<?> entityList) {
        for(Object m : entityList) {
            entityManager.remove(m);
        }
    }
}

