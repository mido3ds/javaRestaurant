package com.javarestaurant.server;

import com.google.common.util.concurrent.UncheckedExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.SQLException;
import java.util.Objects;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"io.swagger", "com.javarestaurant.server.api", "com.javarestaurant.server.configuration"})
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	Environment env;
	@Value("classpath:sqlite_schema.sql")
	private Resource sqliteSchemaResource;
	@Value("classpath:populate_db.sql")
	private Resource populateDBResource;

	public static void main(String[] args) throws Exception {
		new SpringApplication(Application.class).run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}

		createDB();

		if (Objects.equals(env.getProperty("POPULATE_DB"), "TRUE")) {
			populateDB();
		}
	}

	public void createDB() {
		log.info("Creating tables");

		try {
			ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), sqliteSchemaResource);
		} catch (SQLException e) {
			throw new UncheckedExecutionException(e);
		}
	}

	public void populateDB() {
		log.info("Populating DB with test data");

		try {
			ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), populateDBResource);
		} catch (SQLException e) {
			throw new UncheckedExecutionException(e);
		}
	}

	static class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}
	}
}
