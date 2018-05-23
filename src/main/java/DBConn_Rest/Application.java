package DBConn_Rest;
import DBConn_Rest.model.Employee;
import DBConn_Rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
@SpringBootApplication
@ComponentScan
public class Application implements CommandLineRunner {
    @Autowired
    EmployeeService employeeService;

    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }

    //@Override
    //Doubt here
    public void run(String arg[]) throws Exception {
        //employeeService.addEmployee( 1, "Divyanshu Mishra", 10000000, "Owner");
        //Employee result = employeeService.getDetails(4);
        //System.out.println("The details of the Employee are:\nNAME->"+((Employee) result).getEname()+"\nSALARY->"+((Employee) result).getSalary()+"\nDESIGNATION->"+((Employee) result).getPosition());
    }
}
