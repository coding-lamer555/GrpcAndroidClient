package me.codinglamer.grpcandroidclient;

import androidx.room.Room;

import me.codinglamer.grpcandroidclient.database.AppDatabase;

public class App extends android.app.Application {

    private static App instance;

    private AppDatabase db;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "grpc-android-client-database").build();
    }

    public AppDatabase getDb() {
        return db;
    }
}