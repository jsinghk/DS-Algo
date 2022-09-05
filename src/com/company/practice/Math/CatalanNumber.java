package com.company.practice.Math;

public class CatalanNumber {

    //Finding no. of non-intersecting cords with 2*n points in a circle
    //Finding no. of correct order parenthesis possible for n pair of parenthesis
    //Catalan Numbers (from n=0) - 1,1,2,5,14,42,132,429....
    public static void main(String[] args) {
        System.out.println("First 5 Catalan No. : ");
        for (int i=0; i<5; i++) {
            System.out.print(usingFormula(i) + "  ");
        }
        System.out.println();
        for (int i=0; i<5; i++) {
            System.out.print(usingBinomial(i) + "  ");
        }
    }

    // C0=1 and C(N+1)=E{Ci*C(N-i)}
    public static int usingFormula(int n){
        if (n<=1) {
            return 1;
        }
        int res = 0;
        for (int i=0; i<n; i++) {
            res = res + usingFormula(i)*usingFormula(n-i-1);
        }
        return res;
    }

    //Binomial = (2n!)/((n+1)!n!)
    public static int usingBinomial(int n) {
        //Calculate n!
        int c=1;
        for (int i=1; i<=n; i++) {
            c=c*i;
        }

        //Calculate (n+1)!
        int b = c*(n+1);

        //Calculate 2n!
        int a=1;
        for (int i=1; i<=2*n; i++) {
            a=a*i;
        }

        return (a/(b*c));
    }
}
