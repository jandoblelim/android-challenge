package com.jandoblelim.androidchallengejanlim.api.model.response;

/**
 * Created by devskywalker on 03/1/18.
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jandoblelim.androidchallengejanlim.database.model.Currently;
import com.jandoblelim.androidchallengejanlim.database.model.Daily;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "latitude",
        "longitude",
        "timezone",
        "currently",
        "minutely",
        "hourly",
        "daily",
        "alerts",
        "flags",
        "offset"
})
public class ForecastResponse {

    public ForecastResponse() {

    }

    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("currently")
    private Currently currently;
    @JsonProperty("minutely")
    private Minutely minutely;
    @JsonProperty("hourly")
    private Hourly hourly;
    @JsonProperty("daily")
    private Daily daily;
    @JsonProperty("alerts")
    private List<Alert> alerts = null;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("offset")
    private Integer offset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("currently")
    public Currently getCurrently() {
        return currently;
    }

    @JsonProperty("currently")
    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    @JsonProperty("minutely")
    public Minutely getMinutely() {
        return minutely;
    }

    @JsonProperty("minutely")
    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    @JsonProperty("hourly")
    public Hourly getHourly() {
        return hourly;
    }

    @JsonProperty("hourly")
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    @JsonProperty("daily")
    public Daily getDaily() {
        return daily;
    }

    @JsonProperty("daily")
    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    @JsonProperty("alerts")
    public List<Alert> getAlerts() {
        return alerts;
    }

    @JsonProperty("alerts")
    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @JsonProperty("flags")
    public Flags getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "title",
            "regions",
            "severity",
            "time",
            "expires",
            "description",
            "uri"
    })
    public static class Alert {

        public Alert() {

        }

        @JsonProperty("title")
        private String title;
        @JsonProperty("regions")
        private List<String> regions = null;
        @JsonProperty("severity")
        private String severity;
        @JsonProperty("time")
        private Integer time;
        @JsonProperty("expires")
        private Integer expires;
        @JsonProperty("description")
        private String description;
        @JsonProperty("uri")
        private String uri;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("regions")
        public List<String> getRegions() {
            return regions;
        }

        @JsonProperty("regions")
        public void setRegions(List<String> regions) {
            this.regions = regions;
        }

        @JsonProperty("severity")
        public String getSeverity() {
            return severity;
        }

        @JsonProperty("severity")
        public void setSeverity(String severity) {
            this.severity = severity;
        }

        @JsonProperty("time")
        public Integer getTime() {
            return time;
        }

        @JsonProperty("time")
        public void setTime(Integer time) {
            this.time = time;
        }

        @JsonProperty("expires")
        public Integer getExpires() {
            return expires;
        }

        @JsonProperty("expires")
        public void setExpires(Integer expires) {
            this.expires = expires;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("uri")
        public String getUri() {
            return uri;
        }

        @JsonProperty("uri")
        public void setUri(String uri) {
            this.uri = uri;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }





    //datum
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "time",
            "precipIntensity",
            "precipProbability"
    })
    public static class Datum {

        public Datum() {

        }

        @JsonProperty("time")
        private Integer time;
        @JsonProperty("precipIntensity")
        private Integer precipIntensity;
        @JsonProperty("precipProbability")
        private Integer precipProbability;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("time")
        public Integer getTime() {
            return time;
        }

        @JsonProperty("time")
        public void setTime(Integer time) {
            this.time = time;
        }

        @JsonProperty("precipIntensity")
        public Integer getPrecipIntensity() {
            return precipIntensity;
        }

        @JsonProperty("precipIntensity")
        public void setPrecipIntensity(Integer precipIntensity) {
            this.precipIntensity = precipIntensity;
        }

        @JsonProperty("precipProbability")
        public Integer getPrecipProbability() {
            return precipProbability;
        }

        @JsonProperty("precipProbability")
        public void setPrecipProbability(Integer precipProbability) {
            this.precipProbability = precipProbability;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    //Datum_
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "time",
            "summary",
            "icon",
            "precipIntensity",
            "precipProbability",
            "temperature",
            "apparentTemperature",
            "dewPoint",
            "humidity",
            "pressure",
            "windSpeed",
            "windGust",
            "windBearing",
            "cloudCover",
            "uvIndex",
            "visibility",
            "ozone",
            "precipType"
    })
    public static class Datum_ {


        public Datum_() {

        }
        @JsonProperty("time")
        private Integer time;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("icon")
        private String icon;
        @JsonProperty("precipIntensity")
        private Double precipIntensity;
        @JsonProperty("precipProbability")
        private Double precipProbability;
        @JsonProperty("temperature")
        private Double temperature;
        @JsonProperty("apparentTemperature")
        private Double apparentTemperature;
        @JsonProperty("dewPoint")
        private Double dewPoint;
        @JsonProperty("humidity")
        private Double humidity;
        @JsonProperty("pressure")
        private Double pressure;
        @JsonProperty("windSpeed")
        private Double windSpeed;
        @JsonProperty("windGust")
        private Double windGust;
        @JsonProperty("windBearing")
        private Integer windBearing;
        @JsonProperty("cloudCover")
        private Double cloudCover;
        @JsonProperty("uvIndex")
        private Integer uvIndex;
        @JsonProperty("visibility")
        private Integer visibility;
        @JsonProperty("ozone")
        private Double ozone;
        @JsonProperty("precipType")
        private String precipType;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("time")
        public Integer getTime() {
            return time;
        }

        @JsonProperty("time")
        public void setTime(Integer time) {
            this.time = time;
        }

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

        @JsonProperty("precipIntensity")
        public Double getPrecipIntensity() {
            return precipIntensity;
        }

        @JsonProperty("precipIntensity")
        public void setPrecipIntensity(Double precipIntensity) {
            this.precipIntensity = precipIntensity;
        }

        @JsonProperty("precipProbability")
        public Double getPrecipProbability() {
            return precipProbability;
        }

        @JsonProperty("precipProbability")
        public void setPrecipProbability(Double precipProbability) {
            this.precipProbability = precipProbability;
        }

        @JsonProperty("temperature")
        public Double getTemperature() {
            return temperature;
        }

        @JsonProperty("temperature")
        public void setTemperature(Double temperature) {
            this.temperature = temperature;
        }

        @JsonProperty("apparentTemperature")
        public Double getApparentTemperature() {
            return apparentTemperature;
        }

        @JsonProperty("apparentTemperature")
        public void setApparentTemperature(Double apparentTemperature) {
            this.apparentTemperature = apparentTemperature;
        }

        @JsonProperty("dewPoint")
        public Double getDewPoint() {
            return dewPoint;
        }

        @JsonProperty("dewPoint")
        public void setDewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
        }

        @JsonProperty("humidity")
        public Double getHumidity() {
            return humidity;
        }

        @JsonProperty("humidity")
        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }

        @JsonProperty("pressure")
        public Double getPressure() {
            return pressure;
        }

        @JsonProperty("pressure")
        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        @JsonProperty("windSpeed")
        public Double getWindSpeed() {
            return windSpeed;
        }

        @JsonProperty("windSpeed")
        public void setWindSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
        }

        @JsonProperty("windGust")
        public Double getWindGust() {
            return windGust;
        }

        @JsonProperty("windGust")
        public void setWindGust(Double windGust) {
            this.windGust = windGust;
        }

        @JsonProperty("windBearing")
        public Integer getWindBearing() {
            return windBearing;
        }

        @JsonProperty("windBearing")
        public void setWindBearing(Integer windBearing) {
            this.windBearing = windBearing;
        }

        @JsonProperty("cloudCover")
        public Double getCloudCover() {
            return cloudCover;
        }

        @JsonProperty("cloudCover")
        public void setCloudCover(Double cloudCover) {
            this.cloudCover = cloudCover;
        }

        @JsonProperty("uvIndex")
        public Integer getUvIndex() {
            return uvIndex;
        }

        @JsonProperty("uvIndex")
        public void setUvIndex(Integer uvIndex) {
            this.uvIndex = uvIndex;
        }

        @JsonProperty("visibility")
        public Integer getVisibility() {
            return visibility;
        }

        @JsonProperty("visibility")
        public void setVisibility(Integer visibility) {
            this.visibility = visibility;
        }

        @JsonProperty("ozone")
        public Double getOzone() {
            return ozone;
        }

        @JsonProperty("ozone")
        public void setOzone(Double ozone) {
            this.ozone = ozone;
        }

        @JsonProperty("precipType")
        public String getPrecipType() {
            return precipType;
        }

        @JsonProperty("precipType")
        public void setPrecipType(String precipType) {
            this.precipType = precipType;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    //Flags
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "sources",
            "isd-stations",
            "units"
    })
    public static class Flags {

        public Flags() {

        }

        @JsonProperty("sources")
        private List<String> sources = null;
        @JsonProperty("isd-stations")
        private List<String> isdStations = null;
        @JsonProperty("units")
        private String units;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("sources")
        public List<String> getSources() {
            return sources;
        }

        @JsonProperty("sources")
        public void setSources(List<String> sources) {
            this.sources = sources;
        }

        @JsonProperty("isd-stations")
        public List<String> getIsdStations() {
            return isdStations;
        }

        @JsonProperty("isd-stations")
        public void setIsdStations(List<String> isdStations) {
            this.isdStations = isdStations;
        }

        @JsonProperty("units")
        public String getUnits() {
            return units;
        }

        @JsonProperty("units")
        public void setUnits(String units) {
            this.units = units;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    //Hourly
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "summary",
            "icon",
            "data"
    })
    public static class Hourly {

        @JsonProperty("summary")
        private String summary;
        @JsonProperty("icon")
        private String icon;
        @JsonProperty("data")
        private List<Datum_> data = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
        public List<Datum_> getData() {
            return data;
        }

        @JsonProperty("data")
        public void setData(List<Datum_> data) {
            this.data = data;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    //Minutely
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "summary",
            "icon",
            "data"
    })
    public static class Minutely {

        public Minutely() {

        }

        @JsonProperty("summary")
        private String summary;
        @JsonProperty("icon")
        private String icon;
        @JsonProperty("data")
        private List<Datum> data = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
        public List<Datum> getData() {
            return data;
        }

        @JsonProperty("data")
        public void setData(List<Datum> data) {
            this.data = data;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}
