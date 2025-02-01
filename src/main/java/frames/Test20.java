package frames;

public class Test20 {
    public static void main(String[] args) {
    int arg = 6;
    int[] a = new int[arg];
    for(int i = 5; i >= 0; i=i-2 )
    {
    a[i] = i;
    for (int q = 0; q < a.length; q++){
        System.out.print(a[q] + " ");
    }
}
    }
}