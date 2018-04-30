package tech.takenoko.easyandroidapp.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import lombok.Getter;
import tech.takenoko.easyandroidapp.R;
import tech.takenoko.easyandroidapp.databinding.ActivityMainBinding;
import tech.takenoko.easyandroidapp.model.api.model.ApiModel;
import tech.takenoko.easyandroidapp.presenter.MainPresenter;
import tech.takenoko.easyandroidapp.utility.CLog;
import tech.takenoko.easyandroidapp.view.io.MainViewable;
import tech.takenoko.easyandroidapp.viewmodel.CommonViewModel;

public class MainActivity extends BaseActivity implements View.OnClickListener, MainViewable {

    private final String tag = this.toString();

    /** Presenter */
    @Inject public MainPresenter presenter;

    /** View Model */
    private CommonViewModel commonVM = new CommonViewModel();

    /** Lifecycle */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setViewable(this);

        /// data binding.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(commonVM);
        binding.setOnOkClick(this);

        // rendering.
        presenter.loadView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        CLog.info(tag, "onClick. " + view.getId());
        switch (view.getId()) {
            case R.id.super_button: presenter.setupCamera();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ApiModel event) {
        CLog.info(tag, "onMessageEvent. " + event.toString());
        commonVM.buttonText.set(event.getBase());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            CLog.info(tag, "onActivityResult. " + scanResult.getContents());
        }
    }
}
