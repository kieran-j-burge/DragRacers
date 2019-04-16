package android.webdevk.dragracers.Objects;

public class TutorialChecks {

    private Integer key;
    private String name;
    private Boolean done;

    public TutorialChecks(Integer key, String name, Boolean done) {
        this.key = key;
        this.name = name;
        this.done = done;
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

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
