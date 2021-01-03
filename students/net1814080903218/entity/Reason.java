package edu.hzuapps.androidlabs.net1814080903218.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "reason")
public class Reason {
    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "reason")
    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Reason{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    @Ignore
    public Reason() {
    }

    public Reason(String time, String reason) {
        this.time = time;
        this.reason = reason;
    }


}
