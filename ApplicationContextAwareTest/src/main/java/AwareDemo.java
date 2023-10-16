import moskalev.Car;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "moskalev")
public class AwareDemo {
    public static void main(String[] args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AwareDemo.class);
        Car car = (Car) ctx.getBean("car");
        car.startCar();
    }
}
