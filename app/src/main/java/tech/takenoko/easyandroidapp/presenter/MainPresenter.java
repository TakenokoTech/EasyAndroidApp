package tech.takenoko.easyandroidapp.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.model.api.Api;
import tech.takenoko.easyandroidapp.model.api.ApiModel;
import tech.takenoko.easyandroidapp.model.ormadb.LogDao;
import tech.takenoko.easyandroidapp.model.ormadb.LogDto;
import tech.takenoko.easyandroidapp.utility.CLog;
import tech.takenoko.easyandroidapp.view.io.MainViewable;
import tech.takenoko.easyandroidapp.viewmodel.CommonViewModel;

/**
 * Created by takenoko on 2018/04/28.
 */
public class MainPresenter extends BasePresenter {

    private final String tag = this.toString();

    /** Activity Interface */
    private MainViewable viewable;

    /** View Model */
    @Getter private CommonViewModel commonVM = new CommonViewModel();

    /** Dao */
    @Inject LogDao logDao;

    @Inject
    Api api;

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
        viewable.render();
    }

    /**
     * Usecase.
     */
    public void setupCamera() {
        List<LogDto> list = new ArrayList<>();
        api.getLetest(new Api.ApiCallback() {
            @Override public void success(ApiModel model) {
                CLog.info(tag, "success. " + model.toString());
            }
            @Override public void failure() {
                CLog.error(tag, "failed.");
            }
        });
        LogDto log1 = new LogDto();
        log1.setLog1("aaaaa");
        log1.setLog2("bbbbb");
        list.add(log1);
        logDao.insertAll(list);
//        viewable.transtionExtentionCapture();
    }
}
