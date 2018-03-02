package com.jandoblelim.androidchallengejanlim.database.realm;

import android.content.Context;
import com.jandoblelim.androidchallengejanlim.database.model.ApiHitCounter;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;

/**
 * Created by devskywalker on 2/3/18.
 */

public class RealmApiHitCounterRepository {

    public static void initialize(Context context) {
        // Initialize Realm once, and don't forget to close() every use
        Realm.init(context);

        // If Schema changed, just remove Database and start anew
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public static void deleteAll() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    public static void add(ApiHitCounter apiHitCounter) {
        Realm realm = Realm.getDefaultInstance();
        try {
            //commit to db
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(apiHitCounter);
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    public static void addChangeListener(RealmChangeListener<Realm> listener) {
        Realm.getDefaultInstance().addChangeListener(listener);
    }

    public static void removeChangeListener(RealmChangeListener<Realm> listener) {
        Realm.getDefaultInstance().removeChangeListener(listener);
    }

    public static void removeAllChangeListeners() {
        // Remove ALL Listeners just to make sure
        Realm.getDefaultInstance().removeAllChangeListeners();
    }

    public static void close() {
        // Close the Realm. Sorry Barb!!
        Realm.getDefaultInstance().close();
    }

    public static ApiHitCounter getApiHitCounterById(long id) {
        Realm realm = Realm.getDefaultInstance();
        ApiHitCounter driver = new ApiHitCounter();

        try {
            driver = realm.copyFromRealm(
                    realm.where(ApiHitCounter.class).equalTo("id", id).findFirst());
        } catch (Exception e) {
            return null;
        }
        finally {
            // Remember to close
            realm.close();
        }
        return driver;
    }
}
