package tech.takenoko.easyandroidapp.presenter;

import tech.takenoko.easyandroidapp.view.io.MainViewable;
import tech.takenoko.easyandroidapp.view.io.QRCodeReaderViewable;

/**
 * Created by takenoko on 2018/04/28.
 */

public class QRCodeReaderPresenter extends BasePresenter {

    /** Activity Interface */
    private QRCodeReaderViewable viewable;

    /**
     * Constracter
     * @param viewable Activity Interface.
     */
    public QRCodeReaderPresenter(QRCodeReaderViewable viewable) {
        this.viewable = viewable;
    }

    @Override void loadView() {

    }
}
