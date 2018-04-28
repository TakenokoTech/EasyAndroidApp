package tech.takenoko.easyandroidapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.takenoko.easyandroidapp.R;
import tech.takenoko.easyandroidapp.databinding.ActivityMainBinding;
import tech.takenoko.easyandroidapp.presenter.MainPresenter;
import tech.takenoko.easyandroidapp.viewmodel.CommonViewModel;

public class MainActivity extends AppCompatActivity implements MainViewable {

    private MainPresenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(presenter.getCommonVM());

        // rendering
        presenter.loadView();
    }

    @Override
    public void render() {

    }
}
