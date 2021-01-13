package com.rktirtho.hawkeye.ui.authorized;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthorizedViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AuthorizedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Authorized fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}