package my.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 067231 on 2015/12/9.
 */
public class ChannelOneFragment extends Fragment {


    public static ChannelOneFragment newInstance( ) {
        ChannelOneFragment channel = new ChannelOneFragment();
        return  channel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.channel_one, container, false);
        return rootView;
    }
}
