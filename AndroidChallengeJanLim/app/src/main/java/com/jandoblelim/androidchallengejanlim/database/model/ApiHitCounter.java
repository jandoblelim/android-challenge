package com.jandoblelim.androidchallengejanlim.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by devskywalker on 2/3/18.
 */

public class ApiHitCounter extends RealmObject {

    @PrimaryKey
    public Long id;

    public Integer counter;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
