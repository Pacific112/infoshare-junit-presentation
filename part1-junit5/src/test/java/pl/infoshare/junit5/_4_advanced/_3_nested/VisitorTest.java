package pl.infoshare.junit5._4_advanced._3_nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.infoshare.junit5._4_advanced._3_nested.IdType;
import pl.infoshare.junit5._4_advanced._3_nested.Visitor;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("A visitor")
class VisitorTest {

    private final String name = "Maciek";

    @Nested
    @DisplayName("coming from eu")
    class WhenFromEu {

        private final boolean isFromEu = true;

        @Nested
        @DisplayName("and having passport")
        class WithPassport {

            private final IdType idType = IdType.PASSPORT;

            @Test
            @DisplayName("should be allow to enter")
            void name() {
                // given
                var givenVisitor = new Visitor(name, idType, isFromEu);

                // when
                var result = givenVisitor.canEnter();

                // then
                assertThat(result).isTrue();
            }
        }

        @Nested
        @DisplayName("and having id")
        class WithId {

            private final IdType idType = IdType.ID;

            @Test
            @DisplayName("should be allow to enter")
            void name() {
                // given
                var givenVisitor = new Visitor(name, idType, isFromEu);

                // when
                var result = givenVisitor.canEnter();

                // then
                assertThat(result).isTrue();
            }
        }
    }

    @Nested
    @DisplayName("coming from outside eu")
    class WhenOutsideFromEu {

        private final boolean isFromEu = false;

        @Nested
        @DisplayName("and having passport")
        class WithPassport {

            private final IdType idType = IdType.PASSPORT;

            @Test
            @DisplayName("should be allow to enter")
            void name() {
                // given
                var givenVisitor = new Visitor(name, idType, isFromEu);

                // when
                var result = givenVisitor.canEnter();

                // then
                assertThat(result).isTrue();
            }
        }

        @Nested
        @DisplayName("and having id")
        class WithId {

            private final IdType idType = IdType.ID;

            @Test
            @DisplayName("should not be allow to enter")
            void name() {
                // given
                var givenVisitor = new Visitor(name, idType, isFromEu);

                // when
                var result = givenVisitor.canEnter();

                // then
                assertThat(result).isFalse();
            }
        }
    }
}