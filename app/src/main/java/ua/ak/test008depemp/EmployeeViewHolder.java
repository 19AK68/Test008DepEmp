package ua.ak.test008depemp;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ua.ak.test008depemp.Model.Employee;

/**
 *
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    public TextView id;
    public TextView content;
    public TextView nameDep;
    public TextView txtOptionDigit;
    Context context;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        this.context = context;
        id = itemView.findViewById(R.id.id);
        content = itemView.findViewById(R.id.content);
        nameDep = itemView.findViewById(R.id.nameDep);
        txtOptionDigit =itemView.findViewById(R.id.txtOptionDigit);


    }

    public void bindData(Employee employee) {
        id.setText(String.valueOf(employee.getId()));
        content.setText(employee.getName());
        nameDep.setText(employee.getDep());



    }
}
