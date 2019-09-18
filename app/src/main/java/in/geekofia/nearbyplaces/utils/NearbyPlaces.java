package in.geekofia.nearbyplaces.utils;

import android.text.TextUtils;
import android.util.Log;

import in.geekofia.nearbyplaces.models.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NearbyPlaces {
    public static final String TAG = "Error Log";

    private NearbyPlaces() {
    }

    public static ArrayList<Place> getNearbyPlaces(String JSON_RESPONSE){

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(JSON_RESPONSE)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding blog posts to
        ArrayList<Place> nearbyPlaces = new ArrayList<>();

        String name, id, icon, vicinity;
        double rating, latitude, longitude;
        int user_ratings_total;

        try {
            JSONObject RootNearbyPlacesResponse = new JSONObject(JSON_RESPONSE);
            JSONArray results = RootNearbyPlacesResponse.getJSONArray("results");
//            JSONArray RootEarthPosts = new JSONArray(JSON_RESPONSE);

            for (int i = 0; i < results.length(); i++) {
                // object {}
                JSONObject CurrentPlace = results.getJSONObject(i);

                // "Key" : value
                name = CurrentPlace.getString("name");
                id = CurrentPlace.getString("id");
                icon = CurrentPlace.getString("icon");

                if (CurrentPlace.has("rating")){
                    rating = CurrentPlace.getDouble("rating");
                } else {
                    rating = 0.0;
                }

                if (CurrentPlace.has("int user_ratings_total")){
                    user_ratings_total = CurrentPlace.getInt("user_ratings_total");
                } else {
                    user_ratings_total = 0;
                }

                vicinity = CurrentPlace.getString("vicinity");

                JSONObject geometry = CurrentPlace.getJSONObject("geometry");
                JSONObject location = geometry.getJSONObject("location");
                latitude = location.getDouble("lat");
                longitude = location.getDouble("lng");

//                JSONObject opening_hours = CurrentPlace.getJSONObject("opening_hours");
                boolean open_now = false;

                JSONArray types = CurrentPlace.getJSONArray("types");
                String type[] = new String[types.length()];
                for (int t = 0; t < types.length(); t++){
                    type[t] = types.getString(t);
                }

                Place newPlace = new Place(name, icon, id, vicinity, type, latitude, longitude, rating, user_ratings_total, open_now);
                nearbyPlaces.add(newPlace);
            }

        } catch (JSONException e) {
            Log.e("PostUtils", "Problem parsing the LatestPosts JSON results", e);
        }

        // Return the list of nearby places
        return nearbyPlaces;
    }
}
