package cn.org.xinke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootActuatorApplication implements HealthIndicator {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootActuatorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActuatorApplication.class, args);
		LOGGER.info("My spring-boot project is running...");
	}

	/**
	 * 在/health接口调用的时候，
	 * 返回多一个属性："mySpringBootApplication":{"status":"UP","h-key":"h-value"}
	 */
	@Override
	public Health health() {
		return Health.up().withDetail("h-key", "h-value").build();
	}
}
