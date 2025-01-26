package Enums;

public enum TimeSetsStr {
    T5_20_50_200_600("5-20-50-200-600"),
    T40_160_400_16_48( "40-160-400-1.6-4.8"),
    T25_100_250_1_3("25-100-250-1.0-3.0");

    private final String timeScaleStr;

    TimeSetsStr(String timeScaleStr) {
        this.timeScaleStr = timeScaleStr;
    }

    public String getTimeScaleStr() {
        return timeScaleStr;
    }

    @Override
    public String toString() {
        return timeScaleStr;
    }
}
