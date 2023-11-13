package christmas.domain.util;

public enum ErrorMessage {
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_ONLY_BEVERAGE("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요."),
    STRING_IS_NULL("[ERROR] 해당 입력 값이 NULL 입니다."),
    STRING_IS_EMPTY_OR_BLANK("[ERROR] 해당 입력 값에 공백이 있거나 빈 값입니다.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
