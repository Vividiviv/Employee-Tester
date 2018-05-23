package DBConn_Rest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
    //Doubt here
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "employee_Sequence")
    //@SequenceGenerator(name = "employee_Sequence", sequenceName = "EMPLOYEE_SEQ")
    private int eid;
    @Column(name = "ename")
    private String ename;
    @Column(name = "salary")
    private double salary;
    @Column(name = "position")
    private String position;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
