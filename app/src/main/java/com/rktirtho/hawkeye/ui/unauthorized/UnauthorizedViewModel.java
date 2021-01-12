package com.rktirtho.hawkeye.ui.unauthorized;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UnauthorizedViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UnauthorizedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is About fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}