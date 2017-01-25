package example.codeclan.com.forgetmenot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

/**
 * Created by user on 24/01/2017.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {

    private  Context context;
    private LayoutInflater inflater;
    ArrayList<Task> tasks = new ArrayList<>();

    public RecylerViewAdapter(Context context, ArrayList<Task> tasks){
        inflater = LayoutInflater.from(context);
        this.tasks = tasks;
        this.context = context;
    }

    public void delete(int position){
        tasks.remove(position);
        notifyItemRemoved(position);
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

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView taskDesc;
//        ImageView image;
//        CheckBox checkBox;
        Button delete;

        public MyViewHolder(View itemView) {
            super(itemView);
            taskDesc = (TextView) itemView.findViewById(R.id.customRowText);
//            image = (ImageView) itemView.findViewById(R.id.customRowImage);
//            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
//            delete = (Button) itemView.findViewById(R.id.checkBox);


            taskDesc.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            delete(getAdapterPosition());
            Toast.makeText(context, "task has been clicked" + getPosition(), Toast.LENGTH_LONG).show();

        }
    }
}
