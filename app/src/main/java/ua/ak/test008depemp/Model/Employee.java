package ua.ak.test008depemp.Model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by София on 02.03.2018.
 */

public class Employee extends RealmObject {

//    private long employeesCount = Realm.getDefaultInstance().where(Employee.class).count();

    @PrimaryKey
    private Integer id;
    private String Name;
    private String Dep;

    public static Employee getNewEmployee(int id, String name, String dep) {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setDep(dep);
        return employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }





    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String dep) {
        Dep = dep;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Dep='" + Dep + '\'' +
                '}';
    }

}
