package com.pucmm.csti.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pucmm.csti.databinding.FragmentProfileBinding;
import com.pucmm.csti.model.Userr;
import com.pucmm.csti.utils.UserSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProfileFragment extends Fragment {
    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

    //to get user session data
    private UserSession session;
    private Userr user;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve session values and display
        retrieveSession();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);


        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView fullnameTextView = binding.fullnameTextValue;
        final TextView emailTextView = binding.emailTextValue;
        final TextView birthdayTextView = binding.birthdayTextValue;
        profileViewModel.getFullnameText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fullnameTextView.setText(s);
            }
        });
        profileViewModel.getEmailText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                emailTextView.setText(s);
            }
        });
        profileViewModel.getBirthdayText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                birthdayTextView.setText(s);
            }
        });

        profileViewModel.setFullnameText(user.getFirstName() + " " + user.getLastName());
        profileViewModel.setEmailText(user.getEmail());
        final DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        profileViewModel.setBirthdayText(dateFormat.format(Double.parseDouble(user.getBirthday())));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void retrieveSession() {
        //create new session object by passing application context
        session = new UserSession(getContext());
        //get User details if logged in
        user = session.getUserSession();
    }
}
