package com.pucmm.csti.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> fullnameText;
    private MutableLiveData<String> emailText;
    private MutableLiveData<String> birthdayText;

    public ProfileViewModel() {
        fullnameText = new MutableLiveData<>();
        emailText = new MutableLiveData<>();
        birthdayText = new MutableLiveData<>();

        fullnameText.setValue("Testing");
        emailText.setValue("test@mail.com");
        birthdayText.setValue("07-12-92");
    }

    public LiveData<String> getFullnameText() { return fullnameText; }
    public LiveData<String> getEmailText() { return emailText; }
    public LiveData<String> getBirthdayText() { return birthdayText; }

    public void setFullnameText(String s) { fullnameText.setValue(s); }

    public void setEmailText(String s) { emailText.setValue(s); }

    public void setBirthdayText(String s) { birthdayText.setValue(s); }
}
