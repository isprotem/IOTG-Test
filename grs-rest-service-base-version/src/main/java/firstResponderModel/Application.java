package firstResponderModel;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("firstResponderModel, com.intel")
public class Application {

	public static String[] ARGS;
	
	public static  EntityManager em;
    public static void main(String[] args) {
    	
    	ARGS = args;
    	
    	AddRunTimeAnnotation.addAnnotations(ARGS[0]);


    	EntityManagerFactory emf = Persistence.createEntityManagerFactory(ARGS[0]);
        em = emf.createEntityManager();
    	
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

    }

    
}
