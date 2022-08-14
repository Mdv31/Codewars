import java.math.BigInteger;

public class Faberge {
    public static BigInteger height(BigInteger n, BigInteger m) {
        System.out.println(n+" "+m);
        if(n==BigInteger.ZERO && m==BigInteger.ZERO) return BigInteger.ZERO;
        if(n==BigInteger.ONE) return m;
        if(m==BigInteger.ONE) return BigInteger.ONE;

        BigInteger height = BigInteger.ZERO;

    /*for (BigInteger i=BigInteger.ZERO;i<m;i.)
      height=height+10;*/

        return height; // TODO replace with your solution
    }
}
