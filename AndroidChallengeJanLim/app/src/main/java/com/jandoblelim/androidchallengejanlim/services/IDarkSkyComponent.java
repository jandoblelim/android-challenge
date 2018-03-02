package com.jandoblelim.androidchallengejanlim.services;

import com.jandoblelim.androidchallengejanlim.app.ActivityScope;
import com.jandoblelim.androidchallengejanlim.app.IAppComponent;

import dagger.Component;

/**
 * Created by devskywalker on 1/3/18.
 */

@ActivityScope
@Component(
        dependencies = IAppComponent.class
)
public interface IDarkSkyComponent {

    void inject(DarkSkyService darkSkyService);
}
