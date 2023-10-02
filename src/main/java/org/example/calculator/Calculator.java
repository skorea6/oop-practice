package org.example.calculator;

import org.example.calculator.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(
            new AdditionOperator(), new DivisionOperator(), new MultiplicationOperator(), new SubtractionOperator()
    );

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
        return arithmeticOperators.stream()
                .filter(v -> v.supports(operator))
                .map(v -> v.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }
}
