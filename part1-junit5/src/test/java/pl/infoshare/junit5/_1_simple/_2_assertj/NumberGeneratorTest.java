package pl.infoshare.junit5._1_simple._2_assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

//    private final NumberGenerator testObj = new NumberGenerator();
//
//    @Test
//    void should_generate_next_number() {
//        // given
//        var givenNumber = 10;
//
//        // when
//        var result = testObj.getNext(givenNumber);
//
//        // then
//        assertThat(result.getValue()).isEqualTo(1);
//        assertThat(result.getNegative())
//                .isNegative()
//                .isEqualTo(-11);
//        assertThat(result).hasFieldOrPropertyWithValue("internalRepresentation", "even");
//    }
//
//    @Test
//    void should_throw_exception_when_number_is_negative() {
//        // given
//        var givenNumber = -10;
//
//        // when & then
//        assertThatThrownBy(() -> testObj.getNext(givenNumber))
//                .isInstanceOf(NumberBelowZeroException.class)
//                .hasMessage("Number -10 is below zero");
//    }
//
//    @Test
//    void should_generate_previous_number() {
//        // given
//        var givenNumber = 11;
//        var expectedNumber = new GeneratedNumber(10);
//
//        // when
//        var result = testObj.getPrevious(givenNumber);
//
//        // then
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(expectedNumber);
////        assertThat(result.get()).isSameAs(expectedNumber);
//
//        assertThat(result).isNotEmpty()
//                .contains(expectedNumber);
//
//        assertThat(result).hasValueSatisfying(r -> {
//            assertThat(r.getValue()).isEqualTo(10);
//            assertThat(r.getNegative()).isLessThan(0);
//        });
//    }
//
//    @Test
//    void should_return_empty_optional_when_trying_get_previous_number_for_zero() {
//        // given
//        var givenNumber = 5;
//        var givenRange = 3;
//
//        // when
//        var result = testObj.getNextNumbers(givenNumber, givenRange);
//
//        // then
//        assertThat(result).hasSize(3);
//        assertThat(result.get(0).getValue()).isEqualTo(5);
//        assertThat(result.get(1).getValue()).isEqualTo(6);
//        assertThat(result.get(2).getValue()).isEqualTo(7);
//
//        assertThat(result)
//                .extracting(GeneratedNumber::getValue)
//                .contains(7, 6, 5)
//                .containsExactly(5, 6, 7);
//
//        assertThat(result).allSatisfy(r -> assertThat(r.getNegative()).isNegative());
//    }
}