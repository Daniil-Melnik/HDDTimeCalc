package Utils;

public class CalcUtils {
    public static float getOperatingTime(int [] values1, float [] values0){
        float summ = 0;

        for (int i = 0; i< 5; i++){
            summ += values0[i] * values1[i];
        }
        return summ / 1000000;
    }
}
