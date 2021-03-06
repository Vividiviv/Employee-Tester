package DBConn_Rest.service;
import DBConn_Rest.model.Employee;

import java.util.List;

public interface EmployeeService {
    //Functions that we need our programs to execute
    public String addEmployee(int eid,String ename,double salary,String position);
    public String getDetails(int eid);
    public String delEmployee(int eid);
    public List<String> getAllDetails();
    }
