package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(CustmoerRepository repository){
		return(args) -> {
			//save a couple of customers
			repository.save(new Customer("chivas","wan",28));
			repository.save(new Customer("silver", "chao",25));
			repository.save(new Customer("willian", "xu",28));
			
			//fetch all customers
			log.info("customer found with findAll()");
			log.info("-----------------------------");
			for(Customer customer : repository.findAll()){
				log.info(customer.toString());
			}
		log.info("");
		
			//fetch customers by first name
			log.info("customer found with findByFirstName('chivas')");
			log.info("------------------------------------------");
			for(Customer chao : repository.findByFirstName("chivas")){
				log.info(chao.toString());
			}
		log.info("");
		
			//fetch customers by last name
			log.info("customer found with findByLastName('chao')");
			log.info("------------------------------------------");
			for(Customer chao : repository.findByLastName("chao")){
				log.info(chao.toString());
			}
		log.info("");
		
			//fetch customers by age
			log.info("customer found with findByAge(28)");
			log.info("------------------------------------------");
			for(Customer chao : repository.findByAge(28)){
				log.info(chao.toString());
			}
		log.info("");
		};
	}

}
