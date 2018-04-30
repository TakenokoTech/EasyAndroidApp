package tech.takenoko.easyandroidapp.model;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.model.api.Api;
import tech.takenoko.easyandroidapp.model.api.io.ApiHandler;
import tech.takenoko.easyandroidapp.model.api.model.ApiModel;
import tech.takenoko.easyandroidapp.model.ormadb.LogDao;
import tech.takenoko.easyandroidapp.model.ormadb.dto.LogDto;
import tech.takenoko.easyandroidapp.utility.ApiException;
import tech.takenoko.easyandroidapp.utility.CLog;

@Singleton
public class CacheRepository extends BaseRepository {

    private static final String tag = CacheRepository.class.toString();

    /** DAO */
    @Inject LogDao logDao;

    /** API */
    @Inject Api api;

    /**
     * constructor
     */
    @Inject
    CacheRepository(App app) {
        super(app);
    }

    /**
     *
     */
    public void getLetest() {
        api.getLetest(new ApiHandler<ApiModel>() {
            @Override public void success(ApiModel model) {
                CLog.info(tag, "success. " + model.toString());
                EventBus.getDefault().post(model);
            }
            @Override public void failure() {
                CLog.error(tag, "failed.");
                EventBus.getDefault().post(new ApiException());
            }
        });
    }

    public void add() {
        List<LogDto> list = new ArrayList<>();
        LogDto log1 = new LogDto();
        log1.setLog1("aaaaa");
        log1.setLog2("bbbbb");
        list.add(log1);
        logDao.insertAll(list);
        CLog.debug(tag, logDao.findAll().toString());
    }
}
