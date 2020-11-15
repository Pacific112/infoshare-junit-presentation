package pl.infoshare.junit5._1_simple._2_assertj;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class NumberStatisticsTest {


    @Test
    void should_return_all_statistics_for_given_number(SoftAssertions softly) {
        // given
        var givenNumber = 2;

        // when
        var result = new NumberStatistics(givenNumber);

        // then
        softly.assertThat(result.getNumber()).isEqualTo(givenNumber);
        softly.assertThat(result.getSquare()).isEqualTo(4);
        softly.assertThat(result.getTextRepresentation()).isEqualTo("two");
    }
}