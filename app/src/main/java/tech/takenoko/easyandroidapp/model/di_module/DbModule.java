package tech.takenoko.easyandroidapp.model.di_module;

import com.github.gfx.android.orma.AccessThreadConstraint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.model.ormadb.OrmaDatabase;

/**
 * Created by takenoko on 2018/04/29.
 */
@Module
public class DbModule {

    @Singleton
    @Provides
    OrmaDatabase provideDatabase(App app) {
        return OrmaDatabase.builder(app.getApplicationContext())
                .readOnMainThread(AccessThreadConstraint.NONE)
                .writeOnMainThread(AccessThreadConstraint.NONE)
                .build();
    }
}
