package example.codeclan.com.forgetmenot;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 22/01/2017.
 */



    public class FragmentAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private Fragment[] fragments = {
            new NewTask(),
            new TaskList(),
            new PriorityTask()
    };

    public FragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments[position];
        return fragment;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "New task";
            case 1:
                return "All Tasks";
            default:
                return "Priority Tasks";
        }
    }

}

