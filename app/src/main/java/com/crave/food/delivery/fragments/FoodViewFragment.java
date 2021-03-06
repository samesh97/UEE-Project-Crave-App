package com.crave.food.delivery.fragments;

import android.content.Context;
import  android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;

public class FoodViewFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private FragmentManager manager;
    private RecyclerView foodRecyclerView;
    private FrameLayout home_sub_frame_layout;
    private ImageView navigation_drawer_icon;
    private EditText editText;

    public FoodViewFragment(Context context, FragmentManager manager) {
        this.context = context;
        this.manager = manager;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_view, container, false);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        navigation_drawer_icon.setOnClickListener(this);
    }

    private void initViews(View view)
    {
        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
    }

    public void onClick(View view)
    {
        if(view == navigation_drawer_icon)
        {
            showNavigationDialog();
        }

        else if(view == foodRecyclerView){
            showNavigationDialog();
        }
    }

    private void showNavigationDialog()
    {
        if(context instanceof MainActivity)
        {
            MainActivity activity = (MainActivity) context;
            activity.showNavigationDialog();
        }
    }
}