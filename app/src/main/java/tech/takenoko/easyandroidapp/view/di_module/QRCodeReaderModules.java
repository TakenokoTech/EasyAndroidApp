package tech.takenoko.easyandroidapp.view.di_module;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import tech.takenoko.easyandroidapp.view.MainActivity;
import tech.takenoko.easyandroidapp.view.QRCodeReaderActivity;

/**
 * Created by takenoko on 2018/04/28.
 */

public interface QRCodeReaderModules {

    /**
     * Activity
     */
    @Subcomponent
    interface RouteActivitySubcomp extends AndroidInjector<QRCodeReaderActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<QRCodeReaderActivity>{}
    }

    /**
     * Activity
     */
    @Module(subcomponents = {RouteActivitySubcomp.class})
    abstract class RouteActivityModule {
        @Binds @IntoMap @ActivityKey(QRCodeReaderActivity.class)
        abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(RouteActivitySubcomp.Builder builder);
    }

}
