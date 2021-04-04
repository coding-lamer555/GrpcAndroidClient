package me.codinglamer.grpcandroidclient.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PostEntity postEntity);

    @Query("SELECT * FROM posts")
    List<PostEntity> getAll();

    @Query("DELETE FROM posts")
    void deleteAll();
}