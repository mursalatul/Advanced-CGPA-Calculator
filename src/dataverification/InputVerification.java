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
    public static boolean isNumber(String... arr) {
        boolean status = true;
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    status = false;
                    break;
                }
            }
            if (status == false) {
                break;
            }
        }

        return status;
    }
}
