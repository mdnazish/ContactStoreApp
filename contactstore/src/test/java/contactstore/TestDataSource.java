package contactstore;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mn.contactstore.config.SpringRootConfig;

/**
 * @author Md Nazish
 *
 */
public class TestDataSource {

	public static void main(String[] args) {
		
		//create IOC container and load the configuration
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		//load dataSource obj from IOC container
		DataSource dataSource = context.getBean(DataSource.class);
		
		// create jdbcTemplate obj
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		// insert a record into DB
		String sqlQeury = "INSERT INTO user(`name`, `phone`, `email`, `address`, `login_name`, `password`) VALUES(?,?,?,?,?,?)";
		Object[] param = new Object[] {"rashid","8769876098","rashid@gmail.com","H No 1-11-50/9 Begumpet, Hyderabad","rashid kalal","rashid123"};
		jdbcTemplate.update(sqlQeury, param);
		System.out.println("----------------Record Inserted Successfully------------------");
	}
}
