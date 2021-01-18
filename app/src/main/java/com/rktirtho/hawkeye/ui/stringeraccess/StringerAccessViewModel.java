package com.rktirtho.hawkeye.ui.stringeraccess;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StringerAccessViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StringerAccessViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is stringer access fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}