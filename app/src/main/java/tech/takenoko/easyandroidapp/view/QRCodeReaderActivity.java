package tech.takenoko.easyandroidapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import tech.takenoko.easyandroidapp.R;
import tech.takenoko.easyandroidapp.databinding.ActivityScanBinding;
import tech.takenoko.easyandroidapp.presenter.QRCodeReaderPresenter;
import tech.takenoko.easyandroidapp.utility.CLog;
import tech.takenoko.easyandroidapp.view.io.QRCodeReaderViewable;

/**
 * Created by takenoko on 2018/04/28.
 */

public class QRCodeReaderActivity extends CaptureActivity implements QRCodeReaderViewable, View.OnClickListener {

    private final String tag = this.toString();
    private CompoundBarcodeView barcodeView;

    @Inject
    QRCodeReaderPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Injection
        AndroidInjection.inject(this);
        presenter.setViewable(this);

        // databinding
        ActivityScanBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_scan);
        binding.setOnOkClick(this);

        // setup camera.
        barcodeView = findViewById(R.id.barcode_view);
        barcodeView.decodeSingle(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                CLog.info(tag, "result = " + result.getText());
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
                for (ResultPoint point: resultPoints) {
                    CLog.info(tag, "resultPoints = " + resultPoints.toString());
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        barcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }

    @Override
    public void onClick(View view) {

    }
}
