package tech.takenoko.easyandroidapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import lombok.Data;

/**
 * Created by takenoko on 2018/04/28.
 */
public class CommonViewModel {

    public ObservableField<String> buttonText = new ObservableField<String>("Tap");
}
