package dataverification;

/**
 *
 * @author mursalatul
 */
public class InputVerification {

    /**
     * check if given input is a valid number string or not
     *
     * @param string
     * @return Boolean
     */
    static boolean isNumber(String s) {
        boolean status = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                status = false;
                break;
            }
        }
        return status;
    }
}
