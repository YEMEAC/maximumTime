package maximumtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Yeison Melo <melo.yeison@gmail.com>
 */
public class MaximumTime {

    private static final String NOT_POSIBLE = "NOT POSSIBLE";
    private static final String PATTERN_HOUR = "0000";
    private static final char TWO = '2';
    private static final String DOTS = ":";

    private static List<Integer> hourTen(List<Integer> digits) {
        List<Integer> r = new ArrayList();
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) == 0 || digits.get(i) == 1 || digits.get(i) == 2) {
                Integer auxDigit = digits.get(i);
                digits.remove(i);
                r.addAll(hourUnity(auxDigit * 1000, digits));
                digits.add(i, auxDigit);
            }
        }
        return r;
    }

    private static List<Integer> hourUnity(Integer permutation, List<Integer> digits) {
        List<Integer> r = new ArrayList();
        for (int i = 0; i < digits.size(); i++) {
            if (!(permutation.toString().charAt(0) == TWO && digits.get(i) > 3)) { //avoid 24xx 25xx ...
                Integer auxDigit = digits.get(i);
                digits.remove(i);
                r.addAll(minutesTen(permutation + auxDigit * 100, digits));
                digits.add(i, auxDigit);
            }
        }
        return r;
    }

    private static List<Integer> minutesTen(Integer permutation, List<Integer> digits) {
        List<Integer> r = new ArrayList();
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) == 0 || digits.get(i) == 1 || digits.get(i) == 2
                    || digits.get(i) == 3 || digits.get(i) == 4 || digits.get(i) == 5) {
                Integer auxDigit = digits.get(i);
                digits.remove(i);
                r.addAll(minutesUnity(permutation + auxDigit * 10, digits));
                digits.add(i, auxDigit);
            }
        }
        return r;
    }

    private static List<Integer> minutesUnity(Integer permutation, List<Integer> digits) {
        List<Integer> r = new ArrayList();
        for (int i = 0; i < digits.size(); i++) {
            r.add(permutation + digits.get(i));
        }
        return r;
    }

    /**
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static String solution(int A, int B, int C, int D) {

        List<Integer> digits = new ArrayList();
        digits.add(A);
        digits.add(B);
        digits.add(C);
        digits.add(D);

        List<Integer> validHours = hourTen(digits);
        Collections.sort(validHours, Collections.reverseOrder());

        if (!validHours.isEmpty()) {
            String aux = PATTERN_HOUR.concat(validHours.get(0).toString());
            aux=aux.substring(aux.length()-4);
            return aux.subSequence(0, 2) + DOTS + aux.subSequence(2, 4);
        } else {
            return NOT_POSIBLE;
        }
    }
}
