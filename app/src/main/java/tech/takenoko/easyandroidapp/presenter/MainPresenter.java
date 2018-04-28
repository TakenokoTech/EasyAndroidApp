package tech.takenoko.easyandroidapp.presenter;

import android.support.v7.view.menu.BaseMenuPresenter;

import lombok.Getter;
import tech.takenoko.easyandroidapp.model.DataRepository;
import tech.takenoko.easyandroidapp.view.MainViewable;
import tech.takenoko.easyandroidapp.viewmodel.CommonViewModel;

/**
 * Created by takenoko on 2018/04/28.
 */
public class MainPresenter extends BasePresenter {

    /** Activity Interface */
    private MainViewable viewable;

    /** Model */
    private DataRepository dataRepository;

    /** View Model */
    @Getter private CommonViewModel commonVM = new CommonViewModel();

    /**
     * Constracter
     * @param viewable Activity Interface.
     */
    public MainPresenter(MainViewable viewable) {
        this.viewable = viewable;
    }

    /**
     *
     */
    public void loadView() {
        viewable.render();
    }
}
