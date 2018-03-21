package ua.ak.test008depemp;

import android.support.annotation.NonNull;

/**
 * Created by София on 07.03.2018.
 */

public class EmployeeViewModel {

    private  String employeeText;

    public  EmployeeViewModel(@NonNull final String employeeText){

        setEmployeeText(employeeText);
    }

    @NonNull
    public String getEmployeeText() {
        return employeeText;
    }

    public void setEmployeeText(@NonNull final String employeeText) {
        this.employeeText = employeeText;
    }
}
