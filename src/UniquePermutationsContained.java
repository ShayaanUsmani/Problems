import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// given a string n and a string h, print how many unique permutations
// of string n are in h, discounting duplicates
public class UniquePermutationsContained {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String tokens1 = in.readLine();
        String tokens2 = in.readLine();
        String n = tokens1;
        String h = tokens2;
        ArrayList<String> nPerms = permutations(n);
        ArrayList<String> worked = new ArrayList<>();

        for(int i = 0; i<nPerms.size(); i++){
            if(h.contains(nPerms.get(i))){
                worked.add(nPerms.get(i));
            }
        }

        System.out.println(worked.size());
    }

    public static ArrayList<String> permutations(String s)
    {
        ArrayList<String> sub = new ArrayList<>();

        sub.add(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++)
        {
            for (int j = sub.size() - 1; j >= 0 ; j--)
            {
                String str = sub.remove(j);

                for (int k = 0; k <= str.length(); k++)
                {
                    if(!sub.contains(str.substring(0, k) + s.charAt(i) +
                            str.substring(k))) {
                        sub.add(str.substring(0, k) + s.charAt(i) +
                                str.substring(k));
                    }
                }
            }
        }
        return sub;
    }

}