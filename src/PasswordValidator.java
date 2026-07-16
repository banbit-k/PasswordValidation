// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
        // TODO: implement ตาม spec ใน README.md (R1-R6)
         // R1: null -> throw
        if (pw == null) {
            throw new IllegalArgumentException("password must not be null");
        }

        // R2: length 8..20 inclusive
        if (pw.length() < MIN_LEN || pw.length() > MAX_LEN) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpace = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else if (c == ' ') hasSpace = true;
        }

        // R3: at least 1 uppercase
        if (!hasUpper) return false;
        // R4: at least 1 lowercase
        if (!hasLower) return false;
        // R5: at least 1 digit
        if (!hasDigit) return false;
        // R6: no spaces
        if (hasSpace) return false;
        return true;
    }
}
