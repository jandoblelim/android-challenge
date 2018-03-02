package com.jandoblelim.androidchallengejanlim.database.realm;

import android.content.Context;
import com.jandoblelim.androidchallengejanlim.database.model.DailyData;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;

/**
 * Created by devskywalker on 03/1/18.
 */

public class RealmDailyDataRepository {

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

    public static void add(DailyData dailyData) {
        Realm realm = Realm.getDefaultInstance();
        try {
            //commit to db
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(dailyData);
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    public static void addAll(List<DailyData> dailyDatas) {
        Realm realm = Realm.getDefaultInstance();
        try {
            // Commit to Database
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(dailyDatas);
            realm.commitTransaction();
        } finally {
            // Remember to close
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
}
