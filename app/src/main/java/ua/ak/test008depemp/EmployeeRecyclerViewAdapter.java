package ua.ak.test008depemp;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ua.ak.test008depemp.Model.Employee;

/**
 * Created by София on 07.03.2018.
 */

public class EmployeeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    List<Employee> employees;
   Context mContext;


    public EmployeeRecyclerViewAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employeelist_item, parent, false);
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        holder.bindData(employees.get(position));
        holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display option menu

                PopupMenu popupMenu = new PopupMenu ( v.getContext(), holder.txtOptionDigit);
                popupMenu.inflate(R.menu.option_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

//                        switch (item.getItemId()) {
//                            case R.id.opmenu_item_edit:
//                                Toast.makeText(context , "Edit", Toast.LENGTH_LONG).show();
//                                break;
//                            case R.id.opmenu_item_del:
//                                //Delete item
//
//                                Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show();
//                                break;
//                            default:
//                                break;
//                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
