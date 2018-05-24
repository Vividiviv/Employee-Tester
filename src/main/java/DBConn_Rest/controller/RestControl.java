package DBConn_Rest.controller;

import DBConn_Rest.model.Employee;
import DBConn_Rest.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


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
        Boolean result = employeeRepos.exists(eid);
        if(!result) {
            employeeRepos.save(employee);
            String response = "The Request for Addition of:\nEname " + ename + "\nSalary " + salary + "\nPosition " + position + "\n is successfully processed";
            return response;
        }
        else
            return "The value cannot be inserted in the database e: Reason Duplicate Primary Key";
    }

    @RequestMapping(value = "/EmployeeDetails/{EmpId}", method = RequestMethod.GET)
    public String getDetails(@PathVariable("EmpId") int eid) {
        Employee result;
        result = employeeRepos.findOne(eid);
        return "The details of the Employee are:\nNAME->" + ((Employee) result).getEname() + "\nSALARY->" + ((Employee) result).getSalary() + "\nDESIGNATION->" + ((Employee) result).getPosition();
        //return result.toString();
    }

    @RequestMapping(value="/EmployeeDel/{EmpId}", method = RequestMethod.GET)
    public String delEmployee(@PathVariable("EmpId") int eid){
        Boolean result = employeeRepos.exists(eid);
        if(!result)
            return "The entry with given Empid is not present in the database";
        employeeRepos.delete(eid);
        return "The entry with given EmpId:"+eid+" is deleted from the database";
    }

    @RequestMapping(value="/EmployeeAllDetails", method = RequestMethod.GET)
    public List<String> getAllDetails()
    {
        List<String> result= new ArrayList<String>();
        List<Employee> response= new ArrayList<Employee>();
        response = (List<Employee>)employeeRepos.findAll();
        for( Employee e: response)
        {
            String part="Employee ID : "+e.getEid()+" Employee Name : "+e.getEname()+" Salary: "+e.getSalary()+" Position"+e.getPosition();
            result.add(part);
        }
        return result;
    }
}
