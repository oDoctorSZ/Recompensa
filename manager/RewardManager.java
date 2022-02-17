package dbc.mad.recompensastp.manager;

public class RewardManager {

    private String name;
    private boolean used;
    private String duration;
    private int tpReward;

    public RewardManager(String name, boolean used, String duration, int tpReward) {
        this.name = name;
        this.used = used;
        this.duration = duration;
        this.tpReward = tpReward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getReward() {
        return tpReward;
    }

    public void setReward(int reward) {
        this.tpReward = reward;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}


