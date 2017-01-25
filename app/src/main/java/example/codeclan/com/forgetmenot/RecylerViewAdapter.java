package example.codeclan.com.forgetmenot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

import static example.codeclan.com.forgetmenot.R.id.checkBox;

/**
 * Created by user on 24/01/2017.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    ArrayList<Task> tasks = new ArrayList<>();

    public RecylerViewAdapter(Context context, ArrayList<Task> tasks) {
        inflater = LayoutInflater.from(context);
        this.tasks = tasks;
        this.context = context;
    }

    private void delete(int position) {
        Log.d(getClass().toString(), ""+position);

        notifyItemRemoved(position);

        SharedPreferences sharedPreferences = context.getSharedPreferences("tasks", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(tasks.get(position).getSpKey()).apply();
        tasks.remove(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);


        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Task current = tasks.get(position);
        holder.taskDesc.setText(current.getTaskDesc());

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView taskDesc;
        ImageView image;
        CheckBox checkBox;
        Button deleteButton;

        public MyViewHolder(View view) {
            super(view);



            taskDesc = (TextView) itemView.findViewById(R.id.customRowText);
            image = (ImageView) itemView.findViewById(R.id.customRowImage);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            deleteButton = (Button) itemView.findViewById(R.id.deleteButton);


            deleteButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    delete(getAdapterPosition());
                    Toast.makeText(context, "task deleted", Toast.LENGTH_LONG).show();
                }
            });

            image.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    Intent intent = new Intent(context, FullDetailsActivity.class);
                    int position = getAdapterPosition();
                    //intent.putExtra("Tasks", tasks.get(position).getTaskDesc());
                    intent.putExtra("Position", tasks.get(position).getSpKey());

                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
