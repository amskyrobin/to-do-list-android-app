package example.codeclan.com.forgetmenot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 24/01/2017.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    ArrayList<Task> tasks = new ArrayList<>();

    public RecylerViewAdapter(Context context, ArrayList<Task> tasks){
        inflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Task current = tasks.get(position);
        holder.taskDesc.setText(current.getTaskDesc());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView taskDesc;
//        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            taskDesc = (TextView) itemView.findViewById(R.id.customRowText);
//            image = (ImageView) itemView.findViewById(R.id.customRowImage);
        }
    }
}
