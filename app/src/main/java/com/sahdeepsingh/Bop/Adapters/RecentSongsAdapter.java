package com.sahdeepsingh.Bop.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sahdeepsingh.Bop.R;
import com.sahdeepsingh.Bop.playerMain.Main;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecentSongsAdapter extends RecyclerView.Adapter<RecentSongsAdapter.ViewHolder> {

    private List<Long> songs;

    public RecentSongsAdapter(List<Long> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_songs_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (getItemCount() != 0) {
            holder.songName.setText(Main.songs.getSongById(songs.get(position)).getTitle());
            holder.songBy.setText(Main.songs.getSongById(songs.get(position)).getArtist());
            Picasso.get().load(Main.songs.getAlbumArt(Main.songs.getSongById(songs.get(position)))).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.circleImageView);
        }
    }


    @Override
    public int getItemCount() {
        if (songs != null)
            return songs.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView songName;
        public final TextView songBy;
        final CircleImageView circleImageView;

        ViewHolder(View view) {
            super(view);
            songName = view.findViewById(R.id.titleSongRecent);
            songBy = view.findViewById(R.id.artistSongRecent);
            circleImageView = view.findViewById(R.id.imageSongRecent);
        }

    }
}