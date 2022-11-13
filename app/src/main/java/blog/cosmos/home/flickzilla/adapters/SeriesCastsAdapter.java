package blog.cosmos.home.flickzilla.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import blog.cosmos.home.flickzilla.R;
import blog.cosmos.home.flickzilla.activities.CastActivity;
import blog.cosmos.home.flickzilla.network.series.SeriesCastBrief;
import blog.cosmos.home.flickzilla.utils.Constants;

public class SeriesCastsAdapter extends RecyclerView.Adapter<SeriesCastsAdapter.CastViewHolder> {

    private Context mContext;
    private List<SeriesCastBrief> mCasts;

    public SeriesCastsAdapter(Context mContext, List<SeriesCastBrief> mCasts) {
        this.mContext = mContext;
        this.mCasts = mCasts;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CastViewHolder(LayoutInflater.from(mContext).inflate(R.layout.cast_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        Glide.with(mContext.getApplicationContext())
                .load(Constants.IMAGE_LOADING_BASE_URL_342 + mCasts.get(position).getProfilePath())
                .centerCrop()
                .placeholder(R.drawable.cast_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.cast_imageView);

        if (mCasts.get(position).getName() != null)
            holder.cast_actor_name.setText(mCasts.get(position).getName());
        else
            holder.cast_actor_name.setText("");

        if (mCasts.get(position).getCharacter() != null)
            holder.cast_actor_alias.setText(mCasts.get(position).getCharacter());
        else
            holder.cast_actor_alias.setText("");
    }

    @Override
    public int getItemCount() {
        return mCasts.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout cast_linear_layout;
        private ImageView cast_imageView;
        private TextView cast_actor_name;
        private TextView cast_actor_alias;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);

            cast_linear_layout = itemView.findViewById(R.id.cast_root_view);
            cast_imageView = itemView.findViewById(R.id.cast_imageView);
            cast_actor_name = itemView.findViewById(R.id.cast_actor_name);
            cast_actor_alias = itemView.findViewById(R.id.cast_actor_alias);

            cast_linear_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CastActivity.class);
                    intent.putExtra("person_id", mCasts.get(getAdapterPosition()).getId());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
