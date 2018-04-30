package tech.takenoko.easyandroidapp.presenter;

import android.content.Intent;

import javax.inject.Inject;

import lombok.Getter;
import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.model.CacheRepository;
import tech.takenoko.easyandroidapp.view.QRCodeReaderActivity;
import tech.takenoko.easyandroidapp.view.io.MainViewable;
import tech.takenoko.easyandroidapp.viewmodel.CommonViewModel;

/**
 * Created by takenoko on 2018/04/28.
 */
public class MainPresenter extends BasePresenter {

    private final String tag = this.toString();

    /** Activity Interface */
    private MainViewable viewable;

    /** */
    @Inject
    CacheRepository cacheRepository;

    /**
     * Constracter
     * @param app Application
     */
    @Inject MainPresenter(App app) {
        super(app);
    }

    /**
     * DI of Activity.
     * @param viewable
     */
    public void setViewable(MainViewable viewable) {
        this.viewable = viewable;
    }

    /**
     * First Rendering.
     */
    public void loadView() {

    }

    /**
     * Usecase.
     */
    public void setupCamera() {
        cacheRepository.getLetest();
        cacheRepository.add();
        Intent intent = new Intent(this.context, QRCodeReaderActivity.class);
//        context.startActivity(intent);
    }
}
