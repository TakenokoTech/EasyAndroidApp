package tech.takenoko.easyandroidapp.presenter;

import javax.inject.Inject;

import tech.takenoko.easyandroidapp.App;
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
     * @param app Application
     */
    @Inject QRCodeReaderPresenter(App app) {
        super(app);
    }

    public void setViewable(QRCodeReaderViewable viewable) {
        this.viewable = viewable;
    }

    @Override void loadView() {

    }
}
