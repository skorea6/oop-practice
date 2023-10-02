package org.example.calculator;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override // 추상 메소드에 대한 오버라이드
        public int calculate(final int operand1, final int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int calculate(final int operand1, final int operand2) {
            if (operand2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return operand1 / operand2;
        }
    };

    final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public static int calculate(int operand1, String operator, int operand2) {
//        for (ArithmeticOperator value : ArithmeticOperator.values()) {
//            System.out.println(value.operator);
//        }
        ArithmeticOperator selectedArithmeticOperator = Arrays.stream(ArithmeticOperator.values()) // values: ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return selectedArithmeticOperator.calculate(operand1, operand2);
    }

    public abstract int calculate(final int operand1, final int operand2); // 위에 오버라이드
}
