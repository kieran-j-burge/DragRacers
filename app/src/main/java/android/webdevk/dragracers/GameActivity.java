package android.webdevk.dragracers;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webdevk.dragracers.Objects.Car;
import android.webdevk.dragracers.Objects.PitStop;
import android.webdevk.dragracers.Objects.TutorialChecks;
import android.webdevk.dragracers.Services.Impl.LocalStorageServiceImpl;
import android.webdevk.dragracers.Tools.GraphicsHandler;
import android.webdevk.dragracers.Views.GameView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    LocalStorageServiceImpl localStorageService = new LocalStorageServiceImpl();
    GraphicsHandler graphicsHandler = new GraphicsHandler();

    List<Car> pitStopCars = new ArrayList<>();
    List<PitStop> pitStop = new ArrayList<>();
    Boolean isOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLocalStorage();
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkTutorialFromStorage();
        setPitStopImages();
    }


    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        updateLocalStorage();
    }

    public void addCar(View view) {
        Integer carLevel = Integer.parseInt(view.getResources().getResourceEntryName(view.getId()).split("_")[1]) ; // widgetA1
        Car carToBeAdded;
        GameView gameView = findViewById(R.id.gameview);
        Integer pitStopPosition = getPitStop(gameView);
        if (pitStopPosition != 404){
            carToBeAdded = purchaseCar(carLevel,gameView);
            if (carToBeAdded != null){
                pitStopCars.add(carToBeAdded);
                ImageView pitStopImg = (ImageView) findViewById(getPitStopImageView(pitStopPosition));
                pitStopImg.setImageResource(getCarImageAsInt(carLevel));
                pitStopImg.setImageAlpha(255);

                updateLocalStorage();
            }
            else{
                //Randomly ask to buy more coins
            }
        }
        else{
            Toast.makeText(this, "You already have 10 cars",
                    Toast.LENGTH_LONG).show();
        }
    }

    private Car purchaseCar(Integer level, GameView gameView){
        Integer pitStopPosition = getPitStop(gameView);
        Integer coins = gameView.getCoins();
        switch (level){
            case(1):{
                if (coins >= 1000){
                    gameView.setCoins(coins - 1000);
                    return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,1,1,1,false ,graphicsHandler.setCarGraphic(this,level));
                }
                else {
                    Toast.makeText(this, "You need "+(1000-coins)+" more coins",
                            Toast.LENGTH_LONG).show();
                    break;
                }
            }
            case(2):{
                if (coins >= 3000) {
                    gameView.setCoins(coins - 3000);
                    return new Car(pitStopPosition, pitStopPosition, "Rally", level, 200, 2, 1, 500,false, graphicsHandler.setCarGraphic(this, level));
                }
                else {
                    Toast.makeText(this, "You need "+(3000-coins)+" more coins",
                            Toast.LENGTH_LONG).show();
                    break;
                }
            }
            case(3):{
                if (coins >= 10000) {
                    gameView.setCoins(coins - 10000);
                    return new Car(pitStopPosition,pitStopPosition,"toyota",level,400,3,1,1000,false ,graphicsHandler.setCarGraphic(this,level));
                }
                else {
                    Toast.makeText(this, "You need "+(10000-coins)+" more coins",
                            Toast.LENGTH_LONG).show();
                    break;
                }
            }
            case(4):{
                return new Car(pitStopPosition,pitStopPosition,"Rally",level,500,4,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(5):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,5,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(6):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,6,1,100,false ,graphicsHandler.setCarGraphic(this,level));

            }
            case(7):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,7,1,100,false ,graphicsHandler.setCarGraphic(this,level));

            }
            case(8):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,8,1,100,false ,graphicsHandler.setCarGraphic(this,level));

            }
            case(9):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,9,1,100,false ,graphicsHandler.setCarGraphic(this,level));

            }
            case(10):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,10,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(11):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,11,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(12):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,12,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(13):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,13,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(14):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,14,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(15):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,15,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(16):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,16,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }
            case(17):{
                return new Car(pitStopPosition,pitStopPosition,"Banger",level,100,17,1,100,false ,graphicsHandler.setCarGraphic(this,level));
            }

        }
        return null;
    }

    public void openShop(View view){
        ScrollView shopOverlay = (ScrollView) findViewById(R.id.shopOverlay);
        shopOverlay.setVisibility(View.VISIBLE);
    }

    public void closeShop(View view){
        ScrollView shopOverlay = (ScrollView) findViewById(R.id.shopOverlay);
        shopOverlay.setVisibility(View.GONE);
    }

    public void handlePitStop(View view) {
        Integer pitStopId = Integer.parseInt(view.getResources().getResourceEntryName(view.getId()).split("_")[1]) ; // widgetA1
        Boolean isInPitStop = isCarInPitStop(pitStopId);
        Boolean isOnTrack = isCarOnTrack(pitStopId);

        GameView gameView = findViewById(R.id.gameview);
        ArrayList<Car> onTrack = gameView.getOnTrack();

        //If car is in pit stop > Move to track
        if (isInPitStop){
            Car removeC = null;
            for (Car c : pitStopCars){
                if (c.getPitStop() == pitStopId){
                    c.setPosition(0);
                    onTrack.add(c);
                    removeC = c;
                }
            }
            if (removeC != null){
                ImageView pitStopImg = (ImageView) findViewById(getPitStopImageView(pitStopId));
                pitStopImg.setImageResource(getCarImageAsInt(removeC.getLevel()));
                pitStopImg.setImageAlpha(150);
                pitStopCars.remove(removeC);
            }
        }

        //If car is on the track > move to pit stop
        else if(isOnTrack){
            Car removeC = null;
            System.out.println("Is in the on track for loop");
            onTrack = gameView.getOnTrack();
            for (Car c : onTrack){
                if (c.getPitStop() == pitStopId){
                    pitStopCars.add(c);
                    removeC = c;
                }
            }
            if (removeC != null){
                ImageView pitStopImg = (ImageView) findViewById(getPitStopImageView(pitStopId));
                pitStopImg.setImageResource(getCarImageAsInt(removeC.getLevel()));
                pitStopImg.setImageAlpha(255);
                onTrack.remove(removeC);
            }
        }

        //If there is no car in that slot > open shop
        else{
            //open the shop
        }

        //Update Lists
        try {
        }catch (Exception e){
        }


    }

    public int getPitStopImageView(Integer pitStopId) {

        switch (pitStopId){
            case 1: {
                return R.id.ps_1;
            }
            case 2: {
                return R.id.ps_2;
            }
            case 3: {
                return R.id.ps_3;
            }
            case 4: {
                return R.id.ps_4;
            }
            case 5: {
                return R.id.ps_5;
            }
            case 6: {
                return R.id.ps_6;
            }
            case 7: {
                return R.id.ps_7;
            }
            case 8: {
                return R.id.ps_8;
            }
            case 9: {
                return R.id.ps_9;
            }
            case 10: {
                return R.id.ps_10;
            }
            default:{
                return 0;
            }
        }
    }

    public int getCarImageAsInt(Integer level) {

        switch (level){
            case 1: {
                return R.drawable.car_level_1;
            }
            case 2: {
                return R.drawable.car_level_2;
            }
            case 3: {
                return R.drawable.car_level_3;
            }
            case 4: {
                return R.drawable.car_level_4;
            }
            case 5: {
                return R.drawable.car_level_5;
            }
            case 6: {
                return R.drawable.car_level_6;
            }
//            case 7: {
//                return R.drawable.car_level_7;
//            }
//            case 8: {
//                return R.drawable.car_level_8;
//            }
//            case 9: {
//                return R.id.ps_9;
//            }
//            case 10: {
//                return R.id.ps_10;
//            }
            default:{
                return 0;
            }
        }
    }

    private Boolean isCarInPitStop(Integer pitStopId){
        for (Car c: pitStopCars){
            if (c.getPitStop() == pitStopId){
                return true;
            }
        }
        return false;
    }

    private Boolean isCarOnTrack(Integer pitStopId){
        GameView gameView = findViewById(R.id.gameview);
        ArrayList<Car> onTrack = gameView.getOnTrack();

        for (Car c: onTrack){
            if (c.getPitStop() == pitStopId){
                return true;
            }
        }
        return false;
    }


    private Integer getPitStop(GameView gameView){
        Boolean[] taken = {false,false,false,false,false,false,false,false,false,false};
        List<Car> onTrack = gameView.getOnTrack();
        Integer pitStopCheck;
        for (Car c : onTrack){
            pitStopCheck = c.getPitStop();
            taken[pitStopCheck - 1] = true;
        }

        for (Car c : pitStopCars){
            pitStopCheck = c.getPitStop();
            taken[pitStopCheck - 1] = true;
        }

        int position = 1;
        for (Boolean b : taken){
            if (b == false){
                return position;
            }
            position++;
        }
        return 404;
    }



    private List<Car> setCarsFromStorageImg(List<Car> carsFromStorage) {
        for (Car c : carsFromStorage){
            c.setImage(graphicsHandler.setCarGraphic(this, c.getLevel()));
        }
        return carsFromStorage;
    }

    private void setPitStopImages(){
        List<Car> onTrackFromStorage = setCarsFromStorageImg(localStorageService.getOnTrackFromStorage(this));

        for (Car c: pitStopCars){
            ImageView pitStopImg = (ImageView) findViewById(getPitStopImageView(c.getPitStop()));
            pitStopImg.setImageResource(getCarImageAsInt(c.getLevel()));
            pitStopImg.setImageAlpha(255);
        }

        for (Car c: onTrackFromStorage){
            ImageView pitStopImg = (ImageView) findViewById(getPitStopImageView(c.getPitStop()));
            pitStopImg.setImageResource(getCarImageAsInt(c.getLevel()));
            pitStopImg.setImageAlpha(150);
        }
    }

    private void getLocalStorage() {
        List<PitStop> pitStopsFromStorage;
        pitStopsFromStorage = localStorageService.getPitStopsFromStorage(this);
        if (pitStopsFromStorage.size() == 0){
            List<PitStop> pitStopsStore = new ArrayList<>();
            for (int i = 0; i <=10; i++){
                pitStopsStore.add(new PitStop(i,1));
            }
            localStorageService.putPitStopsIntoStorage(this, pitStopsStore);
            getLocalStorage();
        }
        else {
            pitStop = pitStopsFromStorage;
        }

        List<Car> pitStopCarsFromStorage;
        pitStopCarsFromStorage = setCarsFromStorageImg(localStorageService.getPitStopCarsFromStorage(this));

        for(Car c: pitStopCarsFromStorage){
            pitStopCars.add(c);
        }
    }


    private void updateLocalStorage(){
        GameView gameView = findViewById(R.id.gameview);
        ArrayList<Car> onTrackStore = gameView.getOnTrack();
        ArrayList<Car> pitStopStore = new ArrayList<>(pitStopCars);
        localStorageService.putCoinsIntoStorage(this, gameView.getCoins());
        localStorageService.putOnTrackIntoStorage(this,onTrackStore);
        localStorageService.putPitStopIntoStorage(this,pitStopStore);
    }

    private void checkTutorialFromStorage() {
        List<TutorialChecks> tutorialChecks = localStorageService.getTutorialChecksFromStorage(this);
        if (tutorialChecks.size() != 0){
            if (tutorialChecks.get(0).getDone()){
                if (tutorialChecks.get(1).getDone()){
                    if (tutorialChecks.get(2).getDone()){
                        if (tutorialChecks.get(3).getDone()){

                        }
                        else{
                            launchTutorial(3);
                        }
                    }
                    else{
                        launchTutorial(2);
                    }
                }
                else{
                    launchTutorial(1);
                }
            }
            else {
                launchTutorial(0);
            }
        }
        else {
            updateTutorial(false,false,false,false);
            checkTutorialFromStorage();
        }
    }

    private void launchTutorial(Integer tutKey){
        switch (tutKey){
            case 0:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialOne);
                tutorialOne.setVisibility(View.VISIBLE);
                break;
            }
            case 1:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialTwo);
                tutorialOne.setVisibility(View.VISIBLE);
                break;
            }
            case 2:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialThree);
                tutorialOne.setVisibility(View.VISIBLE);
                break;
            }
            case 3:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialFour);
                tutorialOne.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

    private void closeTutorial(Integer tutKey){
        switch (tutKey){
            case 0:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialOne);
                tutorialOne.setVisibility(View.GONE);
                break;
            }
            case 1:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialTwo);
                tutorialOne.setVisibility(View.GONE);
                break;
            }
            case 2:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialThree);
                tutorialOne.setVisibility(View.GONE);
                break;
            }
            case 3:{
                LinearLayout tutorialOne = (LinearLayout) findViewById(R.id.tutorialFour);
                tutorialOne.setVisibility(View.GONE);
                break;
            }
        }
    }

    private void updateTutorial(Boolean tutorialOne,Boolean tutorialTwo,Boolean tutorialThree,Boolean tutorialFour){
        List<TutorialChecks> tutorialChecksStore = new ArrayList<>();
        tutorialChecksStore.add(new TutorialChecks(1,"tut_1",tutorialOne));
        tutorialChecksStore.add(new TutorialChecks(2,"tut_2",tutorialTwo));
        tutorialChecksStore.add(new TutorialChecks(3,"tut_3",tutorialThree));
        tutorialChecksStore.add(new TutorialChecks(4,"tut_4",tutorialFour));
        localStorageService.putTutorialChecksIntoStorage(this,tutorialChecksStore);
    }

    public void runTutorialOne(View view){
        GameView gameView = findViewById(R.id.gameview);
        gameView.setCoins(gameView.getCoins() + 1000);
        updateTutorial(true,false,false,false);
        closeTutorial(0);
        checkTutorialFromStorage();
    }

    public void runTutorialTwo(View view){
        updateTutorial(true,true,false,false);
        closeTutorial(1);
        checkTutorialFromStorage();
    }

    public void runTutorialThree(View view){
        updateTutorial(true,true,true,false);
        closeTutorial(2);
        checkTutorialFromStorage();
    }

    public void runTutorialFour(View view){
        updateTutorial(true,true,true,true);
        closeTutorial(3);
        checkTutorialFromStorage();
    }

    public void openPitStopUpgrade(View view){
        ScrollView pitStopOverlay = (ScrollView) findViewById(R.id.pitStopUpgradeOverlay);
        pitStopOverlay.setVisibility(View.VISIBLE);
    }

    public void closePitStopUpgrade(View view){
        ScrollView pitStopOverlay = (ScrollView) findViewById(R.id.pitStopUpgradeOverlay);
        pitStopOverlay.setVisibility(View.GONE);
    }

    public void doubleSpeed(View view){

        final GameView gv = (GameView) findViewById(R.id.gameview);
        gv.setMultiplier(2);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                Toast.makeText(getApplicationContext(), "seconds remaining: " + millisUntilFinished / 1000,
                        Toast.LENGTH_LONG).show();
            }

            public void onFinish() {
                gv.setMultiplier(1);

            }
        }.start();
    }

    private void handleRestoreCarClick(Integer psKey){
        for (Car c : pitStopCars){
            if (c.getPitStop() == psKey){
                restoreCar(c);
            }
        }
    }

    private Car restoreCar(Car c){
        PitStop ps = pitStop.get(c.getPitStop() );
        c.setLapsLeft(ps.getLapDuration());
        return c;
    }

    public List<Car> getPitStopCars() {
        return pitStopCars;
    }

    public void setPitStopCars(List<Car> pitStopCars) {
        this.pitStopCars = pitStopCars;
    }

    public void ranOutOfLaps(Car c){
        restoreCar(c);
        pitStopCars.add(c);
        ImageView pitStopImg = (ImageView) findViewById(getPitStopImageView(c.getPitStop()));
        pitStopImg.setImageResource(getCarImageAsInt(c.getLevel()));
        pitStopImg.setImageAlpha(255);

    }
}
