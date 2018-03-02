package com.jandoblelim.androidchallengejanlim.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by devskywalker on 03/1/18.
 */

public class Daily extends RealmObject {

    public long id;

    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("data")
    private RealmList<DailyData> data = null;


    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("data")
    public RealmList<DailyData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(RealmList<DailyData> data) {
        this.data = data;
    }


}
