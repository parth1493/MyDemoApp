package com.krishna.mydemoapp.example.webapi;

import android.widget.Button;

import java.util.List;

/**
 * Created by krishna on 2017-08-26.
 */

class Activities {
    private long id;
    private String activity_name;
    private int creator_age;
    private long creator_pk;
    private String creator;
    private String status;
    private String home_nationality;
    private String home_city;
    private long max_users;
    private String activity_time;
    private String activity_end_time;
    private String activity_type;
    private double activity_lon;
    private double activity_lat;
    private String category;
    private String address;
    private String description;
    private String additional_notes;
    private long points;
    private String picture;
    private List<Attending> attending;
    private Boolean is_paid;
    private String event_picture;
    private List<RequestsReceived> requests_received;
    private Boolean is_canceled;
    private String organization_logo;
    private String organization_name;
    private String organization_pk;
    private Boolean is_too_light;

    public Activities(long id, String activity_name, int creator_age, long creator_pk, String creator, String status, String home_nationality, String home_city, long max_users, String activity_time, String activity_end_time, String activity_type, double activity_lon, double activity_lat, String category, String address, String description, String additional_notes, long points, String picture, List<Attending> attending, Boolean is_paid, String event_picture, List<RequestsReceived> requests_received, Boolean is_canceled, String organization_logo, String organization_name, String organization_pk, Boolean is_too_light) {
        this.id = id;
        this.activity_name = activity_name;
        this.creator_age = creator_age;
        this.creator_pk = creator_pk;
        this.creator = creator;
        this.status = status;
        this.home_nationality = home_nationality;
        this.home_city = home_city;
        this.max_users = max_users;
        this.activity_time = activity_time;
        this.activity_end_time = activity_end_time;
        this.activity_type = activity_type;
        this.activity_lon = activity_lon;
        this.activity_lat = activity_lat;
        this.category = category;
        this.address = address;
        this.description = description;
        this.additional_notes = additional_notes;
        this.points = points;
        this.picture = picture;
        this.attending = attending;
        this.is_paid = is_paid;
        this.event_picture = event_picture;
        this.requests_received = requests_received;
        this.is_canceled = is_canceled;
        this.organization_logo = organization_logo;
        this.organization_name = organization_name;
        this.organization_pk = organization_pk;
        this.is_too_light = is_too_light;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public int getCreator_age() {
        return creator_age;
    }

    public void setCreator_age(int creator_age) {
        this.creator_age = creator_age;
    }

    public long getCreator_pk() {
        return creator_pk;
    }

    public void setCreator_pk(long creator_pk) {
        this.creator_pk = creator_pk;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHome_nationality() {
        return home_nationality;
    }

    public void setHome_nationality(String home_nationality) {
        this.home_nationality = home_nationality;
    }

    public String getHome_city() {
        return home_city;
    }

    public void setHome_city(String home_city) {
        this.home_city = home_city;
    }

    public long getMax_users() {
        return max_users;
    }

    public void setMax_users(long max_users) {
        this.max_users = max_users;
    }

    public String getActivity_time() {
        return activity_time;
    }

    public void setActivity_time(String activity_time) {
        this.activity_time = activity_time;
    }

    public String getActivity_end_time() {
        return activity_end_time;
    }

    public void setActivity_end_time(String activity_end_time) {
        this.activity_end_time = activity_end_time;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public double getActivity_lon() {
        return activity_lon;
    }

    public void setActivity_lon(double activity_lon) {
        this.activity_lon = activity_lon;
    }

    public double getActivity_lat() {
        return activity_lat;
    }

    public void setActivity_lat(double activity_lat) {
        this.activity_lat = activity_lat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditional_notes() {
        return additional_notes;
    }

    public void setAdditional_notes(String additional_notes) {
        this.additional_notes = additional_notes;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Attending> getAttending() {
        return attending;
    }

    public void setAttending(List<Attending> attending) {
        this.attending = attending;
    }

    public Boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(Boolean is_paid) {
        this.is_paid = is_paid;
    }

    public String getEvent_picture() {
        return event_picture;
    }

    public void setEvent_picture(String event_picture) {
        this.event_picture = event_picture;
    }

    public List<RequestsReceived> getRequests_received() {
        return requests_received;
    }

    public void setRequests_received(List<RequestsReceived> requests_received) {
        this.requests_received = requests_received;
    }

    public Boolean getIs_canceled() {
        return is_canceled;
    }

    public void setIs_canceled(Boolean is_canceled) {
        this.is_canceled = is_canceled;
    }

    public String getOrganization_logo() {
        return organization_logo;
    }

    public void setOrganization_logo(String organization_logo) {
        this.organization_logo = organization_logo;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getOrganization_pk() {
        return organization_pk;
    }

    public void setOrganization_pk(String organization_pk) {
        this.organization_pk = organization_pk;
    }

    public Boolean getIs_too_light() {
        return is_too_light;
    }

    public void setIs_too_light(Boolean is_too_light) {
        this.is_too_light = is_too_light;
    }
}
