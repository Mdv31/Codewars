public class Kata {

    public static char triangle(String row) {
        // Return the answer
        if (row.length()==1) return row.trim().charAt(0);
        if (row.length()%2==0 && row.length()>2) triangle(String.valueOf(row.charAt(0))+String.valueOf(row.charAt(row.length()-1)));
        if (row.length()%2==1) row=row+" ";
        System.out.println("ВХОД "+row);
        String result="";
        for (int i=0; i< row.length(); i=i+2 ) {
            switch (row.substring(i, i + 2)) {
                case ("GB"):
                    result = result + "R";
                    break;
                case "BG":
                    result = result + "R";
                    break;
                case "RG":
                    result = result + "B";
                    break;
                case "GR":
                    result = result + "B";
                    break;
                case "BR":
                    result = result + "G";
                    break;
                case "RB":
                    result = result + "G";
                    break;
                case "RR":
                    result = result + "R";
                    break;
                case "BB":
                    result = result + "B";
                    break;
                case "GG":
                    result = result + "G";
                    break;
                default:
                    result=result+row.substring(i, i + 2);

            }
        }

        System.out.println("ВЫХОД "+result);
        triangle(result.trim());
        return result.charAt(0);
    }

}