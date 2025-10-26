package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseCarNames(String input) {
        List<String> split = List.of(input.split(","));
        return split;
    }
}
