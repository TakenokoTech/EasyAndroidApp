package tech.takenoko.easyandroidapp.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import javax.inject.Inject;

import dagger.Provides;
import dagger.android.AndroidInjection;
import tech.takenoko.easyandroidapp.R;
import tech.takenoko.easyandroidapp.databinding.ActivityMainBinding;
import tech.takenoko.easyandroidapp.presenter.MainPresenter;
import tech.takenoko.easyandroidapp.utility.CLog;
import tech.takenoko.easyandroidapp.view.io.MainViewable;

public class MainActivity extends BaseActivity implements View.OnClickListener, MainViewable {

    private final String tag = this.toString();
    private MainPresenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(presenter.getCommonVM());
        binding.setOnOkClick(this);

        // rendering
        presenter.loadView();
        int permissionCheck = ContextCompat.checkSelfPermission(this,  Manifest.permission.CAMERA);
    }

    @Override
    public void render() {

    }

    @Override
    public void onClick(View view) {
        CLog.info(tag, "onClick. " + view.getId());
        switch (view.getId()) {
            case R.id.super_button: presenter.setupCamera();
        }
    }

    @Override
    public void transtionExtentionCapture() {
        Intent intent = new Intent(this, QRCodeReaderActivity.class);
        startActivity(intent);
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
