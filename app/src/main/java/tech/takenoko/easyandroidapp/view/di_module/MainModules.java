package tech.takenoko.easyandroidapp.view.di_module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import tech.takenoko.easyandroidapp.view.MainActivity;

/**
 * Created by takenoko on 2018/04/28.
 */

public interface MainModules {

    /**
     * Activity
     */
    @Subcomponent
    interface RouteActivitySubcomp extends AndroidInjector<MainActivity> {

        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
    }

    /**
     * Activity
     */
    @Module(subcomponents = {RouteActivitySubcomp.class})
    abstract class RouteActivityModule {

        @Binds @IntoMap @ActivityKey(MainActivity.class)
        abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(RouteActivitySubcomp.Builder builder);
    }

}
