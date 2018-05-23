package DBConn_Rest.controller;

import DBConn_Rest.model.Employee;
import DBConn_Rest.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RestControl {
    private EmployeeRepos employeeRepos;

    @Autowired
    public RestControl(EmployeeRepos employeeRepos) {
        this.employeeRepos = employeeRepos;
    }

    @RequestMapping(value = "/EmployeeAdd/{EmpId}/{Ename}/{Salary}/{Position}", method = RequestMethod.GET)
    public String addEmployee(@PathVariable("EmpId") int eid, @PathVariable("Ename") String ename, @PathVariable("Salary") double salary, @PathVariable("Position") String position) {
        Employee employee = new Employee();
        employee.setEid(eid);
        employee.setEname(ename);
        employee.setSalary(salary);
        employee.setPosition(position);
        employeeRepos.save(employee);
        String response = "The Request for Addition of:\n Eid " + eid + "\nEname " + ename + "\nSalary " + salary + "\nPosition " + position + "\n is successfully processed";
        return response;
    }

    @RequestMapping(value = "/EmployeeDetails/{EmpId}", method = RequestMethod.GET)
    public String getDetails(@PathVariable("EmpId") int eid) {
        Employee result;
        result = employeeRepos.findOne(eid);
        return "The details of the Employee are:\nNAME->" + ((Employee) result).getEname() + "\nSALARY->" + ((Employee) result).getSalary() + "\nDESIGNATION->" + ((Employee) result).getPosition();
        //return result.toString();
    }
}