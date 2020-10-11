package com.crave.food.delivery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.adapters.FoodListAdapter;
import com.crave.food.delivery.listeners.OnFoodClick;
import com.crave.food.delivery.models.Foods;

import java.util.ArrayList;

public class CartFragment extends Fragment implements View.OnClickListener
{

    private Context context;
    private FragmentManager manager;
    private Button btnCheckOut;
    private ImageView navigation_drawer_icon;
    private RecyclerView cartRecyclerView;

    public CartFragment(Context context, FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cart_main,container,false);
        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);

        ArrayList<Foods> list = new ArrayList<>();

        Foods foods = new Foods();
        foods.setTxtVwFoodName("Bakery");
        foods.setTxtVwPriceCart("Rs. 150.00");
        foods.setImageId(context.getResources().getDrawable(R.drawable.bakery));
        foods.setTxtVwFoodName("Chicken Burger");
        foods.setTxtVwPriceCart("Rs.490.00");
        foods.setImageId(context.getResources().getDrawable(R.drawable.burger ));


        list.add(foods);
        FoodListAdapter adapter = new FoodListAdapter(context, list, new OnFoodClick() {
            @Override
            public void onChange(Foods foods)
            {

            }
        });

        cartRecyclerView.setAdapter(adapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(context));


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
