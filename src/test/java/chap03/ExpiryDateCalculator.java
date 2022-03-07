package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {

        if (payData.getFirstBillingDate() != null) {

            // 이 내용을 조금 더 formal하게 바꾼 게 저기 아래 코드임
            // 결국 하려고 했던 게 1월 31일 결제, 2월 28일 결제, 그럼 3월은 3월 31일 결제여야하는 걸 구현하려고 한거니까
            if (payData.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) {
                return LocalDate.of(2019, 3, 31);
            }

            LocalDate candidateExp = payData.getBillingDate().plusMonths(1);

            // dayOfMonth는 해당 월의 전체 날짜수를 구해오는 메서드임
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                // withDayOfMonth는 해당 월의 일 수를 변경하는 메서드임
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }

        }
        return payData.getBillingDate().plusMonths(1);
    }
}
