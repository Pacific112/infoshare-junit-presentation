package pl.infoshare.junit5._1_simple._1_beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SimpleDateCalculator {

    private final Integer daysToAdd;

    public SimpleDateCalculator(@Value("${calculator.days-to-add}") Integer daysToAdd) {
        this.daysToAdd = daysToAdd;
    }

    public LocalDate calculateDate(LocalDate date) {
        return date.plusDays(daysToAdd);
    }
}
