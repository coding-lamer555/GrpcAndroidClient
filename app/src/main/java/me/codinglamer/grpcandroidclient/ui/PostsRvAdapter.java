package me.codinglamer.grpcandroidclient.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.codinglamer.grpcandroidclient.databinding.CardPostBinding;
import me.codinglamer.grpcjavaserver.PostServiceOuterClass;

public class PostsRvAdapter extends RecyclerView.Adapter<PostsRvAdapter.PostsViewHolder> {

    private List<PostServiceOuterClass.PostResponse> posts;

    public PostsRvAdapter(List<PostServiceOuterClass.PostResponse> posts) {
        this.posts = posts;
    }

    public void addItem(PostServiceOuterClass.PostResponse post) {
        posts.add(post);
        notifyDataSetChanged();
    }

    public void addItems(List<PostServiceOuterClass.PostResponse> posts) {
        this.posts.addAll(posts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardPostBinding binding = CardPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        PostServiceOuterClass.PostResponse currentPost = posts.get(position);
        holder.bind(currentPost);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        public final CardPostBinding binding;
        public final Context context;

        public PostsViewHolder(CardPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }

        public void bind(PostServiceOuterClass.PostResponse post) {
            binding.title.setText(post.getTitle());
            binding.description.setText(post.getDescription());
        }
    }
}