import java.io.File;
import java.io.FileNotFoundException;



public class TugOfWar {
    int[] team;
    int N;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	//java.util.Scanner
        java.util.Scanner scan = null;
        try {
            scan = new java.util.Scanner(
                    new File(
                            "C:\\Users\\a.ram\\workspace\\TestJavaVersion\\src\\sample_in_out"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            TugOfWar tw = new TugOfWar();
            tw.init(scan);
            int firstSet = tw.N / 2;
            int fSum = 0, sSum = 0;
            for (int n = 0; n < tw.N; n++) {
                if (n < firstSet)
                    fSum += tw.team[n];
                else
                    sSum += tw.team[n];
            }
            int diff = Math.abs(fSum - sSum);
            int finalfSum = fSum;
            int finalsSum = sSum;

            for (int j = 0; j < firstSet; j++) {
                for (int k = firstSet; k < tw.N; k++) {
                    int tempfSum = fSum - tw.team[j] + tw.team[k];
                    int tempsSum = sSum - tw.team[k] + tw.team[j];
                    if (Math.abs(tempfSum - tempsSum) < diff) {
                        diff = Math.abs(tempfSum - tempsSum);
                        finalfSum = tempfSum;
                        finalsSum = tempsSum;
                    }
                }
            }
            System.out.println(finalfSum + " " + finalsSum);
        }
    }

    private void init(java.util.Scanner scan) {
        // TODO Auto-generated method stub
        N = scan.nextInt();
        team = new int[N];
        for (int i = 0; i < team.length; i++) {
            team[i] = scan.nextInt();
        }
    }

}
