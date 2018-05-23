package DBConn_Rest.service;

import DBConn_Rest.model.Employee;
import DBConn_Rest.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    @Autowired
    private EmployeeRepos employeeRepos;

    public String addEmployee(int eid,String ename,double salary,String position) {
        Employee employee = new Employee();
        employee.setEid(eid);
        employee.setEname(ename);
        employee.setSalary(salary);
        employee.setPosition(position);
        employeeRepos.save(employee);
        String response = "The Request for Addition of:\nEname " + ename + "\nSalary " + salary + "\nPosition " + position + "\n is successfully processed";
        return response;
    }

    //@RequestMapping(value = "/EmployeeDetails/{EmpId}", method = RequestMethod.GET)
    public String getDetails(int eid) {
        Employee result;
        result = employeeRepos.findOne(eid);
        System.out.println("The details of the Employee are:\nNAME->" + ((Employee) result).getEname() + "\nSALARY->" + ((Employee) result).getSalary() + "\nDESIGNATION->" + ((Employee) result).getPosition());
        return result.toString();
    }
}
