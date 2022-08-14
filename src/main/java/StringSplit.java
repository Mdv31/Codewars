public class StringSplit {
    public static String[] solution(String s) {
        //Write your code here
        if(s.length()%2!=0){s=s+"_";}

        String[] data = new String[s.length()/2];
        int j=0;

        for(int i=0;i<s.length();i=i+2){
            data[j] = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1));
            j++;
        }
        return data;
    }
}



