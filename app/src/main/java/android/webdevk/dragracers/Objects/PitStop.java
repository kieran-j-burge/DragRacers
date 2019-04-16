package android.webdevk.dragracers.Objects;

public class PitStop {

    private Integer key;
    private Integer lapDuration;

    public PitStop(Integer key, Integer lapDuration) {
        this.key = key;
        this.lapDuration = lapDuration;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getLapDuration() {
        return lapDuration;
    }

    public void setLapDuration(Integer lapDuration) {
        this.lapDuration = lapDuration;
    }
}
