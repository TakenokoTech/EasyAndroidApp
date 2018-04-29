package tech.takenoko.easyandroidapp.model.ormadb;

import com.github.gfx.android.orma.Relation;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by takenoko on 2018/04/29.
 */
@Singleton
public class LogDao {

    OrmaDatabase orma;

    @Inject
    LogDao(OrmaDatabase orma) {
        this.orma = orma;
    }

    private Relation<LogDto, LogDto_Relation> relation() {
        return orma.relationOfLogDto();
    }

    public void insertAll(List<LogDto> list) {
        relation().inserter().executeAll(list);
    }

    public List<LogDto> findAll(){
        return relation().selector().toList();
    }

    public Integer deleteAll() {
        return relation().deleter().execute();
    }
}
