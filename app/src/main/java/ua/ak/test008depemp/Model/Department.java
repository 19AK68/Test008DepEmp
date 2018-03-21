package ua.ak.test008depemp.Model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ua.ak.test008depemp.DepartmentFragment;

/**
 * Created by София on 06.03.2018.
 */

public class Department extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String Dep;

    public static Department getNewDepartmen (Integer id, String dep) {

        final Department department = new Department();


            department.setId(id);

            department.setDep(dep);
        return department;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", Dep='" + Dep + '\'' +
                '}';
    }

}
