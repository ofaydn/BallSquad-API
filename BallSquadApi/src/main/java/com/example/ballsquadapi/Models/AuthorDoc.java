package com.example.ballsquadapi.Models;

public class AuthorDoc {
    private String key;
    private String type;
    private String name;
    private String birth_date;
    private String top_work;

    public String getType() {
        return type;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getTop_work() {
        return top_work;
    }

    public void setTop_work(String top_work) {
        this.top_work = top_work;
    }

    public int getWork_count() {
        return work_count;
    }

    public void setWork_count(int work_count) {
        this.work_count = work_count;
    }

    public long get_version_() {
        return _version_;
    }

    public void set_version_(long _version_) {
        this._version_ = _version_;
    }

    private int work_count;
    private long _version_;
}
