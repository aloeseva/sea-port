package app;

import app.service.SimulationServ;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SeaPortApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SeaPortApplication.class);
        SimulationServ simulationService = context.getBean(SimulationServ.class);
        simulationService.start();
    }
}
