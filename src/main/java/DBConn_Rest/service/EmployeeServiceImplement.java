package DBConn_Rest.service;

import DBConn_Rest.model.Employee;
import DBConn_Rest.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

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
        Boolean result = employeeRepos.exists(eid);
        if(!result) {
            employeeRepos.save(employee);
            String response = "The Request for Addition of:\nEname " + ename + "\nSalary " + salary + "\nPosition " + position + "\n is successfully processed";
            return response;
        }
        else
            return "The value cannot be inserted in the database : Reason Duplicate Primary Key";
    }

    //@RequestMapping(value = "/EmployeeDetails/{EmpId}", method = RequestMethod.GET)
    public String getDetails(int eid) {
        Employee result;
        result = employeeRepos.findOne(eid);
        System.out.println("The details of the Employee are:\nNAME->" + ((Employee) result).getEname() + "\nSALARY->" + ((Employee) result).getSalary() + "\nDESIGNATION->" + ((Employee) result).getPosition());
        return result.toString();
    }

    public String delEmployee(int eid){
        Boolean result = employeeRepos.exists(eid);
        if(!result)
            return "The entry with given Empid is not present in the database";
        employeeRepos.delete(eid);
        return "The entry with given EmpId:"+eid+" is deleted from the database";
    }
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
