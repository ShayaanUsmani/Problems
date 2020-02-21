import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// given an array with i*j elements, create a 2D array with given integers
// starting at index [0][0], if the another element's y position +1 and x position +1
// can multiply to result in the current integer which we are on, we are able to jump to
// the new element. The goal is to see if we can end up on element [i][j], meaning we escaped
// "yes" is printed if escape is possible, "no" if not.
public class EscapePossibility {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(in.readLine());
        int j = Integer.parseInt(in.readLine());

        int[][] map = new int[i][j];

        for(int l = 0; l<i; l++) {
            String[] strings = in.readLine().split(" ");
            for(int m = 0; m<strings.length; m++){
                map[l][m] = Integer.parseInt(strings[m]);
            }
        }

        if(map[0][0] == 0 || map[0][0] == 1 || map[0][0] > i*j){
            System.out.print("no");
            System.exit(0);
        }
        else if(map[0][0] == i*j){
            System.out.print("yes");
            System.exit(0);
        }

        for(int q = 0; q<i; q++){
            for (int w = 0; w<j; w++){
                System.out.print(map[q][w] + " ");
            }
            System.out.println();
        }

        checkEscape(map,i,j,0,0);
    }

    public static void checkEscape(int[][] map, int i, int j, int y, int x){
        if(map[y][x]==i*j){
            System.out.print("yes");
            System.exit(0);
        }

        for(int a = 0; a < i; a++){

            for(int b = 0; b < j; b++){
                if(a == 0 && b == 0){
                    b++;
                }

                if((a+1)*(b+1)==map[y][x]){
                    checkEscape(map,i,j,a,b);
                }
            }
        }

        if(y==0 && x==0){
            System.out.print("no");
            System.exit(0);
        }

    }
}
