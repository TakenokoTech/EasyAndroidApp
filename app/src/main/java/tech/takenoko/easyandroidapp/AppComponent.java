package tech.takenoko.easyandroidapp;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import tech.takenoko.easyandroidapp.view.di_module.MainModules;

/**
 * Created by takenoko on 2018/04/28.
 */
@Singleton
@Component(modules = {MainModules.RouteActivityModule.class, AndroidInjectionModule.class})
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(App application);
        AppComponent build();
    }
}
