package be.pxl.ja.streamingservice.model;

public enum Rating {
    LITTLE_KIDS("Little Kids",0),
    OLDER_KIDS("Older Kids",7),
    TEENS("Teens",12),
    MATURE("Mature",16);

    private String displayName;
    private int mimimumAge;

    Rating(String displayName, int mimimumAge){
        this.displayName = displayName;
        this.mimimumAge = mimimumAge;
    }

    public int getMimimumAge() {
        return mimimumAge;
    }
}
