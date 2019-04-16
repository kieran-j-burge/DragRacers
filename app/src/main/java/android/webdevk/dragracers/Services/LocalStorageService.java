package android.webdevk.dragracers.Services;

import android.content.Context;
import android.webdevk.dragracers.Objects.Car;
import android.webdevk.dragracers.Objects.PitStop;
import android.webdevk.dragracers.Objects.TutorialChecks;

import java.util.ArrayList;
import java.util.List;

public interface LocalStorageService {

    void storeLocalData(String key, String value, Context context);

    //Get
    String getUserLocalData(String key, Context context);
    List<Car> getPitStopCarsFromStorage(Context context);
    List<Car> getOnTrackFromStorage(Context context);
    Integer getCoinsFromStorage(Context context);
    List<TutorialChecks> getTutorialChecksFromStorage(Context context);
    List<PitStop> getPitStopsFromStorage(Context context);

    //Store
    void putOnTrackIntoStorage(Context context, ArrayList<Car> carList);
    void putPitStopIntoStorage(Context context, ArrayList<Car> carList);
    void putCoinsIntoStorage(Context context, Integer coins);
    void putTutorialChecksIntoStorage(Context context, List<TutorialChecks> tutorialChecks);
    void putPitStopsIntoStorage(Context context, List<PitStop> pitStops);
}
