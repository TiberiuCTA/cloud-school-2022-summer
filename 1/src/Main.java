import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int i, j;

        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                b[i][j]=sc.nextInt();
            }
        }

        System.out.println("SUM:");
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(a[i][j]+b[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("PROD:");
        for(int k=0;k<n;k++){
            for(i=0;i<n;i++){
                int s=0;
                for(j=0;j<n;j++){
                    s+=a[k][j]*b[j][i];
                }
                System.out.print(s+" ");
            }
            System.out.println();
        }

    }
}
