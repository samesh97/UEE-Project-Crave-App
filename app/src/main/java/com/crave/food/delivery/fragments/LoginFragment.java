package com.crave.food.delivery.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import com.crave.food.delivery.activities.MainActivity;
import com.crave.food.delivery.R;
import com.crave.food.delivery.activities.NotLoggedActivity;
import com.crave.food.delivery.config.SharedPrefManager;
import com.crave.food.delivery.models.User;

public class LoginFragment extends Fragment implements View.OnClickListener
{
    private Context context;
    private FragmentManager manager;
    private LottieAnimationView login_animation;
//    private ImageView navigation_drawer_icon;

    private EditText username_et,password_et;
    private Button login_btn;

    public LoginFragment(Context context, FragmentManager manager)
    {
        this.context = context;
        this.manager = manager;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_login,null,false);
        initViews(view);
        setData();
        return view;
    }

    private void setData()
    {
        login_animation.setRepeatCount(LottieDrawable.INFINITE);
//        login_animation.setAnimation(R.raw.login_vector);
//        login_animation.setRenderMode(RenderMode.SOFTWARE);
//        login_animation.playAnimation();

//        navigation_drawer_icon.setOnClickListener(this);
        login_btn.setOnClickListener(this);


    }

    private void initViews(View view)
    {
        login_animation = view.findViewById(R.id.login_animation);
//        navigation_drawer_icon = view.findViewById(R.id.navigation_drawer_icon);
        username_et = view.findViewById(R.id.username_et);
        password_et = view.findViewById(R.id.password_et);
        login_btn = view.findViewById(R.id.login_btn);
    }
    @Override
    public void onClick(View view)
    {
//        if(view == navigation_drawer_icon)
//        {
//            showNavigationDialog();
//        }
        if(view == login_btn)
        {
            String userName = username_et.getText().toString().trim();
            String password = password_et.getText().toString().trim();

            if (userName.isEmpty())
            {
                Toast.makeText(context, "Please enter Username", Toast.LENGTH_SHORT).show();
            }
            else if (password.isEmpty())
            {
                Toast.makeText(context, "Please enter Password", Toast.LENGTH_SHORT).show();
            }
            else
            {
                User user = SharedPrefManager.getUser(context);

                if(user.getUserName() != null && user.getUserName().equals(userName))
                {
                    if(user.getPassword() != null && user.getPassword().equals(password))
                    {
                        Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
                        SharedPrefManager.setUserLoggedIn(context,true);

                        if(context instanceof NotLoggedActivity)
                        {
                            ((NotLoggedActivity) context).GoToMainActivity();
                        }
                    }
                    else
                    {
                        Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show();
                }

            }
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
