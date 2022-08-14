import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Permutations {

    public static List<String> singlePermutations(String s) {
        // Your code here!
        List<String> resultList = new ArrayList<>();
        if (s.length()==1) { resultList.add(s); return resultList;}

        for(int i=0;i<s.length();i++){
            List<String>temp=singlePermutations(s.substring(0, i)+s.substring(i+1));
            for (String string : temp) {
                resultList.add(s.charAt(i)+string);
            }
        }

        return resultList.stream().distinct().collect(Collectors.toList());
    }
}


/*** Алгоритм
 * 1234
 * 1
 * 12               21
 * 312  132 123     321 231 213
 *
 * 4312 4132 4123
 * 3412 1432 1423
 * 3142 1342 1243
 * 3124 1324 1234
 *

 */