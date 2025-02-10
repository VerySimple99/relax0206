package com.example.simplejoy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitTest {


    /*
        Given-When-Then은 테스트 코드의 가독성과 유지보수성을 높이기 위한 구조화된 테스트 패턴입니다.
        🏗 구조
Given (준비)

테스트를 위한 사전 조건을 설정합니다.
Mock 객체를 생성하거나, 필요한 데이터를 셋업합니다.
When (실행)

테스트 대상 메서드를 호출합니다.
즉, 실제 동작(Act)을 수행하는 부분입니다.
Then (검증)

기대한 결과가 나왔는지 검증(Assert)하는 단계입니다.
예상된 값과 실제 값을 비교합니다.
     */
    @Test
    void 덧셈_테스트() {
        // Given (준비)
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 10;

        // When (실행)
        int result = calculator.add(a, b);

        // Then (검증)
        assertThat(result).isEqualTo(15);// 성공하는 케이스
    }

}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

