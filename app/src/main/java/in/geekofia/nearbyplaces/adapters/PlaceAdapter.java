package in.geekofia.nearbyplaces.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.geekofia.nearbyplaces.R;
import in.geekofia.nearbyplaces.models.Place;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private Context mContext;
    private ArrayList<Place> mPlacesList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewName, mTextViewId, mTextViewIcon, mTextViewVicinity, mTextViewRating,
                mTextViewTotalRatings, mTextViewStatus, mTextViewType, mTextViewLatitude, mTextViewLongitude;

        public PlaceViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            mTextViewName = itemView.findViewById(R.id.place_name);
            mTextViewId = itemView.findViewById(R.id.place_id);
            mTextViewIcon = itemView.findViewById(R.id.place_icon);
            mTextViewVicinity = itemView.findViewById(R.id.place_vicinity);
            mTextViewRating = itemView.findViewById(R.id.place_rating);
            mTextViewTotalRatings = itemView.findViewById(R.id.place_total_ratings);
            mTextViewStatus = itemView.findViewById(R.id.place_status);
            mTextViewType = itemView.findViewById(R.id.place_type);
            mTextViewLatitude = itemView.findViewById(R.id.place_latitude);
            mTextViewLongitude = itemView.findViewById(R.id.place_longitude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public PlaceAdapter(Context mContext, ArrayList<Place> mPlaceList) {
        this.mContext = mContext;
        this.mPlacesList = mPlaceList;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item, parent, false);
        return new PlaceViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Place currentItem = mPlacesList.get(position);
        String name, id, icon, types, rating, vicinity, user_ratings_total, open_now, latitude, longitude;

        name = currentItem.getmShopName();
        id = currentItem.getmShopId();
        icon = currentItem.getmShopIcon();
        types = String.valueOf(currentItem.getmType());
        vicinity = currentItem.getmVicinity();
        user_ratings_total = String.valueOf(currentItem.getmUserRatingsTotal());
        latitude = String.valueOf(currentItem.getmShopLatitude());
        longitude = String.valueOf(currentItem.getmShopLongitude());

        if (currentItem.isOpenNow()) {
            open_now = "Open";
        } else {
            open_now = "Closed";
        }

        double dbl_rating = currentItem.getmRating();

        if (dbl_rating == 0.0) {
            rating = "Not rated yet";
        } else {
            rating = String.valueOf(dbl_rating);
        }

        holder.mTextViewName.setText(name);
        holder.mTextViewId.setText(id);
        holder.mTextViewIcon.setText(icon);
        holder.mTextViewRating.setText(rating);
        holder.mTextViewTotalRatings.setText(user_ratings_total);
        holder.mTextViewVicinity.setText(vicinity);
        holder.mTextViewStatus.setText(open_now);
        holder.mTextViewType.setText(types);
        holder.mTextViewLatitude.setText(latitude);
        holder.mTextViewLongitude.setText(longitude);
    }

    @Override
    public int getItemCount() {
        return mPlacesList.size();
    }
}
