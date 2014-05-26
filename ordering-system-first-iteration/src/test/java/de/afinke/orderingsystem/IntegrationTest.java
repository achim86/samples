package de.afinke.orderingsystem;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.jdbc.JdbcTestUtils;

@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public abstract class IntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final String deleteScript = "src/test/resources/sql/cleanup.sql";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void deleteAllDomainEntities() {
        JdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(deleteScript), false);
    }

}
