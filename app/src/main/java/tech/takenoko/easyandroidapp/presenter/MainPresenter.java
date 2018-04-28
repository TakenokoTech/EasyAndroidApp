package tech.takenoko.easyandroidapp.presenter;

import android.content.Context;

import javax.inject.Inject;

import lombok.Getter;
import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.model.DataRepository;
import tech.takenoko.easyandroidapp.model.localdb.BarcodeDBHelper;
import tech.takenoko.easyandroidapp.view.io.MainViewable;
import tech.takenoko.easyandroidapp.viewmodel.CommonViewModel;

/**
 * Created by takenoko on 2018/04/28.
 */
public class MainPresenter extends BasePresenter {

    /** Activity Interface */
    private MainViewable viewable;
    private Context context;

    /** Model */
    private DataRepository dataRepository;

    /** View Model */
    @Getter private CommonViewModel commonVM = new CommonViewModel();

    /**
     * Constracter
     */
    @Inject
    public MainPresenter(MainViewable viewable) {
        this.viewable = viewable;
    }

    /**
     *
     */
    public void loadView() {
        viewable.render();
    }

    /**
     *
     */
    public void setupCamera() {
        viewable.transtionExtentionCapture();
    }
}
