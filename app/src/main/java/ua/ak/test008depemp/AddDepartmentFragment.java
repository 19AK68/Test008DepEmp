package ua.ak.test008depemp;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import ua.ak.test008depemp.Model.Department;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDepartmentFragment extends Fragment {

    View rootView;
    private EditText eTxtDept;
    boolean isSpot = false;


    public AddDepartmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_add_department, container, false);
        eTxtDept = rootView.findViewById(R.id.txtDepart);
        Button addToDept = rootView.findViewById(R.id.btnAddDep);
        addToDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDept(eTxtDept.getText().toString().trim());
                Keyboard.hide(v);
//                eTxtDept.setText("");
            }
        });

        return rootView;
    }


     private void saveToDept(String dep) {

        int id;
         try {

             id =  Realm.getDefaultInstance().where(Department.class).max("id").intValue();

         } catch (NullPointerException e) {
             id = 0;
         }
        final  Department department = Department.getNewDepartmen(++id, dep);
         Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
             @Override
             public void execute(Realm realm) {

                 if (eTxtDept.length()> 2) {
                     realm.copyToRealmOrUpdate(department);
                     eTxtDept.setText("");

                     realm.close();
                 }
                 else {

                     AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
                     adb.setTitle("INPUT NAME");
                     adb.setMessage("You must enter a name (more than 2 characters)");

                     //button Retry
                     adb.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });

                     adb.create().show();
//                     Toast.makeText(getContext(), "ERRROER", Toast.LENGTH_LONG).show();

                 }


             }

         });






    }
}
