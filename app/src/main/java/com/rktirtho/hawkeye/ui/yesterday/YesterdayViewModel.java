package com.rktirtho.hawkeye.ui.yesterday;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YesterdayViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YesterdayViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Yesterday fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}