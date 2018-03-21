package ua.ak.test008depemp;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
//private Realm realm;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    DepartmentFragment dFrag = new DepartmentFragment();
    EmployeeFragment sFrag =  new EmployeeFragment();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        fragmentTransaction.add(R.id.container,dFrag);
        fragmentTransaction.commit();
    }

//
}
