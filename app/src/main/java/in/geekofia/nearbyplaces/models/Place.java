package in.geekofia.nearbyplaces.models;

public class Place {
    private String mShopName, mShopIcon, mShopId, mVicinity, mType[];
    private double mShopLatitude, mShopLongitude;
    private double mRating;
    private int mUserRatingsTotal;
    private boolean isOpenNow;

    public Place(String mShopName, String mShopIcon, String mShopId, String mVicinity, String[] mType, double mShopLatitude, double mShopLongitude, double mRating, int mUserRatingsTotal, boolean isOpenNow) {
        this.mShopName = mShopName;
        this.mShopIcon = mShopIcon;
        this.mShopId = mShopId;
        this.mVicinity = mVicinity;
        this.mType = mType;
        this.mShopLatitude = mShopLatitude;
        this.mShopLongitude = mShopLongitude;
        this.mRating = mRating;
        this.mUserRatingsTotal = mUserRatingsTotal;
        this.isOpenNow = isOpenNow;
    }

    public String getmShopName() {
        return mShopName;
    }

    public String getmShopIcon() {
        return mShopIcon;
    }

    public String getmShopId() {
        return mShopId;
    }

    public String getmVicinity() {
        return mVicinity;
    }

    public String[] getmType() {
        return mType;
    }

    public double getmShopLatitude() {
        return mShopLatitude;
    }

    public double getmShopLongitude() {
        return mShopLongitude;
    }

    public double getmRating() {
        return mRating;
    }

    public int getmUserRatingsTotal() {
        return mUserRatingsTotal;
    }

    public boolean isOpenNow() {
        return isOpenNow;
    }
}
