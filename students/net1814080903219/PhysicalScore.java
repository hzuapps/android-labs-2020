package edu.hzuapps.androidlabs.net1814080903219;

public class PhysicalScore {
    private float high;
    private float weight;
    private int vitalCapacity;
    private float run50Time;
    private int jump;
    private float touch;
    private float run1000Time;
    private int upCount;
    private float totalScore;

    public PhysicalScore() {
    }

    public PhysicalScore(float high, float weight, int vitalCapacity, float run50Time, int jump, float touch, float run1000Time, int upCount, float totalScore) {
        this.high = high;
        this.weight = weight;
        this.vitalCapacity = vitalCapacity;
        this.run50Time = run50Time;
        this.jump = jump;
        this.touch = touch;
        this.run1000Time = run1000Time;
        this.upCount = upCount;
        this.totalScore = totalScore;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getVitalCapacity() {
        return vitalCapacity;
    }

    public void setVitalCapacity(int vitalCapacity) {
        this.vitalCapacity = vitalCapacity;
    }

    public float getRun50Time() {
        return run50Time;
    }

    public void setRun50Time(float run50Time) {
        this.run50Time = run50Time;
    }

    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    public float getTouch() {
        return touch;
    }

    public void setTouch(float touch) {
        this.touch = touch;
    }

    public float getRun1000Time() {
        return run1000Time;
    }

    public void setRun1000Time(float run1000Time) {
        this.run1000Time = run1000Time;
    }

    public int getUpCount() {
        return upCount;
    }

    public void setUpCount(int upCount) {
        this.upCount = upCount;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "PhysicalScore{" +
                "high=" + high +
                ", weight=" + weight +
                ", vitalCapacity=" + vitalCapacity +
                ", run50Time=" + run50Time +
                ", jump=" + jump +
                ", touch=" + touch +
                ", run1000Time=" + run1000Time +
                ", upCount=" + upCount +
                ", totalScore=" + totalScore +
                '}';
    }
}
