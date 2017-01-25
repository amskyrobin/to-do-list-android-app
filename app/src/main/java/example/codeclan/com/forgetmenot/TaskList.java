package example.codeclan.com.forgetmenot;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by user on 22/01/2017.
 */

public class TaskList extends Fragment {

//    private TextView taskList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

//        taskList = (TextView) view.findViewById(R.id.taskList);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTask);

        recyclerView.setHasFixedSize(true);



        Context context = getActivity();
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        refresh();

        //mAdapter.notifyDataSetChanged();

//        taskList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getTaskList();
//            }
//        });

        return view;
    }

    public void refresh() {
        mAdapter = new RecylerViewAdapter(getActivity(), getTaskList());
        recyclerView.setAdapter(mAdapter);
    }


    public ArrayList<Task> getTaskList(){ //Previously void return type



        Map<String, ?> allTasks = getActivity().getSharedPreferences("tasks", Context.MODE_PRIVATE).getAll();
        ArrayList<Task> tasks;
        tasks = new ArrayList<Task>();
        for (Map.Entry<String, ?> entry : allTasks.entrySet()) {
            if (entry.getValue() instanceof String) {
//                textValue += (String)entry.getValue();
                tasks.add(Task.fromJson(entry.getValue().toString()));
            }
        }
//        taskList.setText(tasks.toString());
        return tasks;
    }
}

