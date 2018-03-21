package ua.ak.test008depemp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.ak.test008depemp.Model.Employee;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListEmployeeFragment extends Fragment {

    View rootView;
    private TextView tvListEmp;
    private RecyclerView recyclerView;


    public ListEmployeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list_employee, container, false);

//        tvListEmp = rootView.findViewById(R.id.tvListEmp);
        recyclerView = rootView.findViewById(R.id.employeeRV);

//        tvListEmp.setVisibility(View.GONE);

        ViewListEmployee();

        return rootView;




    }



    private void ViewListEmployee() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

//        Employee employee1 = new Employee();
//        employee1.setId(1L);
//        employee1.setName("Name1");
//        Employee employee2 = new Employee();
//        employee2.setId(2L);
//        employee2.setName("Name2");
//        Employee employee3 = new Employee();
//        employee3.setId(3L);
//        employee3.setName("Name3");
        List<Employee> results = Realm.getDefaultInstance().where(Employee.class).findAll();

//        List<Employee> employees = new ArrayList<>();
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);
        EmployeeRecyclerViewAdapter adapter = new EmployeeRecyclerViewAdapter(results);
        recyclerView.setAdapter(adapter);


//        String outText = "";
//
//        for (Employee employee: results) {
//            outText += employee.toString();
//
//        }
//        tvListEmp.setText( outText);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // TODO Add your menu entries here
        inflater.inflate(R.menu.mymenu_add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                Toast.makeText(getContext(), "ADD ITEM", Toast.LENGTH_LONG).show();
                break;


        }
        return true;

    }


}
