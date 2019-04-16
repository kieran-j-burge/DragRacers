package android.webdevk.dragracers.Services.Impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.webdevk.dragracers.Objects.Car;
import android.webdevk.dragracers.Objects.PitStop;
import android.webdevk.dragracers.Objects.TutorialChecks;
import android.webdevk.dragracers.Services.LocalStorageService;
import android.webdevk.dragracers.Tools.TinyDB;

import java.util.ArrayList;
import java.util.List;

public class LocalStorageServiceImpl implements LocalStorageService {




    public void storeLocalData(String key, String value, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,value);
        editor.apply();
    }


    public String getUserLocalData(String key, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = preferences.getString(key, "");
        return value;
    }

    @Override
    public List<Car> getOnTrackFromStorage(Context context) {
        TinyDB tinydb = new TinyDB(context);
        List<Object> objList = tinydb.getListObject("onTrackList",Car.class);
        List<Car> carList = (List<Car>)(Object) objList;

        return carList;
    }

    @Override
    public List<Car> getPitStopCarsFromStorage(Context context) {
        TinyDB tinydb = new TinyDB(context);
        List<Object> objList = tinydb.getListObject("pitStopList",Car.class);
        List<Car> carList = (List<Car>)(Object) objList;

        return carList;
    }

    @Override
    public void putOnTrackIntoStorage(Context context, ArrayList<Car> carList) {
        TinyDB tinydb = new TinyDB(context);
        ArrayList<Object> objectList = new ArrayList<Object>(carList);
        tinydb.putListObject("onTrackList",objectList);

    }

    @Override
    public void putPitStopIntoStorage(Context context, ArrayList<Car> carList) {
        TinyDB tinydb = new TinyDB(context);
        ArrayList<Object> objectList = new ArrayList<Object>(carList);
        tinydb.putListObject("pitStopList",objectList);

    }

    @Override
    public void putCoinsIntoStorage(Context context, Integer coins) {
        TinyDB tinydb = new TinyDB(context);
        tinydb.putInt("coins", coins);

    }

    @Override
    public Integer getCoinsFromStorage(Context context) {
        TinyDB tinydb = new TinyDB(context);
        return tinydb.getInt("coins");
    }

    @Override
    public List<TutorialChecks> getTutorialChecksFromStorage(Context context) {
        TinyDB tinyDB = new TinyDB(context);
        List<TutorialChecks> tutorialChecks = (List<TutorialChecks>)(Object) tinyDB.getListObject("tutorialChecks",TutorialChecks.class);
        return tutorialChecks;
    }

    @Override
    public List<PitStop> getPitStopsFromStorage(Context context) {
        TinyDB tinyDB = new TinyDB(context);
        List<PitStop> pitStops = (List<PitStop>)(Object) tinyDB.getListObject("pitStops", PitStop.class);
        return pitStops;
    }

    @Override
    public void putTutorialChecksIntoStorage(Context context, List<TutorialChecks> tutorialChecks) {
        TinyDB tinydb = new TinyDB(context);
        ArrayList<Object> objectList = new ArrayList<Object>(tutorialChecks);
        tinydb.putListObject("tutorialChecks", objectList);
    }

    @Override
    public void putPitStopsIntoStorage(Context context, List<PitStop> pitStops) {
        TinyDB tinydb = new TinyDB(context);
        ArrayList<Object> objectList = new ArrayList<Object>(pitStops);
        tinydb.putListObject("pitStops", objectList);
    }
}
