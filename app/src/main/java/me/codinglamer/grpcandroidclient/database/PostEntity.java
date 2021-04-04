package me.codinglamer.grpcandroidclient.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts")
public class PostEntity {

    @PrimaryKey
    public long id;

    public String title;

    public String description;
}