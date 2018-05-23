package DBConn_Rest.repository;

import DBConn_Rest.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface EmployeeRepos extends CrudRepository<Employee,Integer> {
    //Crud Repository has functions like findOne, findAll and many more functions defined so
    //by extending Crud Repos we inherit those function in Client Repos
}
