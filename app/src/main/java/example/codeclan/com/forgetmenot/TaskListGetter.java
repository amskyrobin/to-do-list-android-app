//package example.codeclan.com.forgetmenot;
//
//import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.Map;
//
///**
// * Created by user on 24/01/2017.
// */
//
//public class TaskListGetter extends AppCompatActivity
//
//        public TaskListGetter() {
//        }
//
//
//
//        public ArrayList<Task> getTaskList(){ //Previously void return type
//
//
//
//            Map<String, ?> allTasks = getSharedPreferences("tasks", Context.MODE_PRIVATE).getAll();
//            ArrayList<Task> tasks;
//            tasks = new ArrayList<Task>();
//            for (Map.Entry<String, ?> entry : allTasks.entrySet()) {
//                if (entry.getValue() instanceof String) {
////                textValue += (String)entry.getValue();
//                    tasks.add(Task.fromJson(entry.getValue().toString()));
//                }
//            }
////        taskList.setText(tasks.toString());
//            return tasks;
//        }
//}
