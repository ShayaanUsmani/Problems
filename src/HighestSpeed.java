import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// given times and positions, print the highest speed

public class HighestSpeed {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        double[] times = new double[n];
        double[] pos = new double[n];
        System.out.print(n);
        for(int i = 0; i < n; i++){
            times[i] = Integer.parseInt(in.readLine().split(" ")[0]);
            pos[i] = Integer.parseInt(in.readLine().split(" ")[1]);
        }
        for(int i = 0; i < n; i++){
            pos[i] = pos[i] - pos[0];
        }

        double vMax = 0;
        for( int i = 1; i<n; i++){
            double speed = Math.abs((pos[i] - pos[i-1]) / (times[i]-times[i-1]));
                if (speed > Math.abs(vMax)) {
                    vMax = speed;
                }
        }

        System.out.print(vMax);
    }
}
