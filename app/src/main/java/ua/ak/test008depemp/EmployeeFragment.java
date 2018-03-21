package ua.ak.test008depemp;


import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.ak.test008depemp.Model.Department;
import ua.ak.test008depemp.Model.Employee;

import static android.widget.AdapterView.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeFragment extends Fragment {

    View rootView;
    private EditText eTxtName, eTxtDpt;
    Spinner spDep;
    TextView tvTxt;
    private String txtSpinnerDep;


    private ArrayAdapter adapter;

    public EmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        eTxtName = rootView.findViewById(R.id.txtName);
//        eTxtDpt = rootView.findViewById(R.id.txtDep);
         tvTxt = rootView.findViewById(R.id.tvTxt);
// SPINNER
        spDep= rootView.findViewById(R.id.spDep);

        ArrayList<String> a =  retrieve();
//        a.add("sdw");
//        a.add("dwad");




        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,a );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDep.setAdapter(adapter);



        // обраточик нажатия


//        spDep.setOnItemClickListener( new OnItemSelectedListener(){

//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                txtSpinnerDep = spDep.getSelectedItem().toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });





        Button addToBD = rootView.findViewById(R.id.btnAdd);

        addToBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSpinnerDep = spDep.getSelectedItem().toString();

                saveToDB(eTxtName.getText().toString().trim(), txtSpinnerDep);
                Keyboard.hide(v);
//                eTxtName.setText("");
//                eTxtDpt.setText("");
            }
        });

        return rootView;
    }
//

    private void saveToDB(String name, String dep) {
        int id;
        try {
            id = Realm.getDefaultInstance().where(Employee.class).max("id").intValue();
        } catch (NullPointerException e) {
            id = 0;
        }


//        RealmResults<Department> resultsDep = Realm.getDefaultInstance().where(Department.class).findAll();


        final Employee employee = Employee.getNewEmployee(++id, name, dep);
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(employee);
                eTxtName.setText("");
//                eTxtDpt.setText("");
                System.out.println("Name:" + name +" "+ "Dep:" + dep);
                realm.close();
            }


        });
    }

    public ArrayList<String> retrieve(){

        ArrayList<String> departmenName = new ArrayList<>();
        RealmResults<Department> departments =  Realm.getDefaultInstance().where(Department.class).findAll();
//        System.out.println( departments.size());

        for(int k=0;k < departments.size(); k++) //Department s: departments
        {
            departmenName.add(departments.get(k).getDep());
//            System.out.println(departments.get(k).getDep());

        }

        return departmenName;

    }

}
