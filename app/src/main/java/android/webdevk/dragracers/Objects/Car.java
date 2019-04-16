package android.webdevk.dragracers.Objects;

import android.graphics.Bitmap;

public class Car {
    private Integer key;
    private Integer pitStop;
    private String name;
    private Integer level;
    private Integer coins;
    private Integer speed;
    private Integer position;
    private Integer lapsLeft;
    private Boolean onTrack;
    private Bitmap image;

    public Car(Integer key, Integer pitStop, String name, Integer level, Integer coins, Integer speed, Integer position, Integer lapsLeft, Boolean onTrack, Bitmap image) {
        this.key = key;
        this.pitStop = pitStop;
        this.name = name;
        this.level = level;
        this.coins = coins;
        this.speed = speed;
        this.position = position;
        this.lapsLeft = lapsLeft;
        this.onTrack = onTrack;
        this.image = image;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Boolean getOnTrack() {
        return onTrack;
    }

    public void setOnTrack(Boolean onTrack) {
        this.onTrack = onTrack;
    }

    public Integer getPitStop() {
        return pitStop;
    }

    public void setPitStop(Integer pitStop) {
        this.pitStop = pitStop;
    }

    public Integer getLapsLeft() {
        return lapsLeft;
    }

    public void setLapsLeft(Integer lapsLeft) {
        this.lapsLeft = lapsLeft;
    }
}
