package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {

        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;

        int metCounts = getMetCriteriaCounts(s);

        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

        // 숫자, 영문, 특수문자, 8자리 이상 모두 충족하면 강함
        return PasswordStrength.STRONG;
    }

    // 비밀번호에 숫자가 포함되지 않으면 보통
    private boolean meetsContainingNumberCriteria(String s) {

        for (char ch: s.toCharArray()) {

            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUpperCriteria(String s) {
        for (char ch: s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;

        if (s.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(s)) metCounts++;
        if (meetsContainingUpperCriteria(s)) metCounts++;

        return metCounts;
    }
}