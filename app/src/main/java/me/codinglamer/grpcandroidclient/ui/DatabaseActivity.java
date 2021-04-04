package me.codinglamer.grpcandroidclient.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import me.codinglamer.grpcandroidclient.App;
import me.codinglamer.grpcandroidclient.database.PostEntity;
import me.codinglamer.grpcandroidclient.databinding.ActivityDatabaseBinding;
import me.codinglamer.grpcjavaserver.PostServiceOuterClass;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private PostsRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initComponents();

        loadData();
    }

    private void initComponents() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostsRvAdapter(new ArrayList<>());
        binding.recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        Observable.fromCallable(() -> App.getInstance().getDb().postDao().getAll())
                .subscribeOn(Schedulers.io())
                .subscribe(this::initializeData);
    }

    private void initializeData(List<PostEntity> postEntities) {
        List<PostServiceOuterClass.PostResponse> posts = new ArrayList<>();
        for (PostEntity postEntity : postEntities) {
            PostServiceOuterClass.PostResponse post = PostServiceOuterClass.PostResponse
                    .newBuilder()
                    .setId(postEntity.id)
                    .setTitle(postEntity.title)
                    .setDescription(postEntity.description)
                    .build();
            posts.add(post);
        }

        adapter.addItems(posts);
    }
}