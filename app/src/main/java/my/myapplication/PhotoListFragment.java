package my.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 067231 on 2015/12/9.
 */
public class PhotoListFragment extends Fragment {


    public static PhotoListFragment newInstance( ) {
        PhotoListFragment channel = new PhotoListFragment();
        return  channel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.channel_two, container, false);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(R.id.photo_list2, PhotoFragment.newInstance(R.drawable.pic1,"This is a test!"));
        transaction.add(R.id.photo_list2, PhotoFragment.newInstance(R.drawable.pic2,"This is a test!"));
        transaction.add(R.id.photo_list2, PhotoFragment.newInstance(R.drawable.pic3,"This is a test!"));
        transaction.add(R.id.photo_list2, PhotoFragment.newInstance(R.drawable.pic4,"This is a test!"));
        transaction.add(R.id.photo_list2, PhotoFragment.newInstance(R.drawable.pic1,"This is a test!"));
        transaction.add(R.id.photo_list2, PhotoFragment.newInstance(R.drawable.pic2,"This is a test!"));
        transaction.commit();

        return rootView;
    }
}
