package homework_01.calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

        testCalculateDiscountByBasicFunctionality();
        testCalculateDiscountByPurchaseAmountLessThanZero();
        testCalculateDiscountByPurchaseAmountEqualToZeroZero();
        testCalculateDiscountByDiscountAmountLessThanZero();
        testCalculateDiscountByDiscountAmountMoreThanOneHundredPercent();
    }

    // Проверка базового функционала метода
    public static void testCalculateDiscountByBasicFunctionality(){
        assertThat(Calculator.calculateDiscount(122.33, 3)).isEqualTo(118.66);
        System.out.println("Сумма к оплате с учетом скидки " + Calculator.calculateDiscount(122.33,3));
    }

    // Проверка с отрицательным значением PurchaseAmount
    public static void testCalculateDiscountByPurchaseAmountLessThanZero(){
        assertThatThrownBy(() -> Calculator.calculateDiscount(-1.00, 25))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The purchase amount cannot be less than or equal to zero");
    }

    // Проверка со значением PurchaseAmount=0
    public static void testCalculateDiscountByPurchaseAmountEqualToZeroZero(){
        assertThatThrownBy(() -> Calculator.calculateDiscount(0, 25))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The purchase amount cannot be less than or equal to zero");
    }

    // Проверка с отрицательным значением DiscountAmount
    public static void testCalculateDiscountByDiscountAmountLessThanZero(){
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.00, -25))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The discount amount cannot be less than zero");
    }

    // Проверка со значением DiscountAmount больше 100
    public static void testCalculateDiscountByDiscountAmountMoreThanOneHundredPercent(){
        assertThatThrownBy(() -> Calculator.calculateDiscount(100.00, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("The discount amount cannot be higher than to 100");
    }
}
