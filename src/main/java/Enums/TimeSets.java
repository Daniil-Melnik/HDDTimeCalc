package Enums;

public enum TimeSets {
    T5_20_50_200_600(new int [] {5, 20, 50, 200, 600}, "5-20-50-200-600"),
    T40_160_400_16_48(new int [] {40, 160, 400, 1600, 4800}, "40-160-400-1.6-4.8"),
    T25_100_250_1_3(new int [] {25, 100, 250, 1000, 3000}, "25-100-250-1.0-3.0");

    private final int [] timeScaleNum;
    private final String timeScaleStr;

    TimeSets(int [] timeScaleNum, String timeScaleStr) {
        this.timeScaleNum = timeScaleNum;
        this.timeScaleStr = timeScaleStr;
    }

    public int [] getTimeScaleNum() {
        return timeScaleNum;
    }

    public String getTimeScaleStr() {
        return timeScaleStr;
    }

    @Override
    public String toString() {
        return timeScaleStr;
    }
}