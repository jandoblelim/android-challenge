package com.jandoblelim.androidchallengejanlim.app.main;

import com.jandoblelim.androidchallengejanlim.app.ActivityScope;
import com.jandoblelim.androidchallengejanlim.app.IAppComponent;
import dagger.Component;


/**
 * Created by devskywalker on 03/1/18.
 */

@ActivityScope
@Component(
        dependencies = IAppComponent.class,
        modules = MainModule.class
)
public interface IMainComponent {
    void inject(MainActivity mainActivity);
}
