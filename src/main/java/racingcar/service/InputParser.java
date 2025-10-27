package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public List<String> parseCarNames(String input) {
        List<String> split = Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .toList();
        return split;
    }
}
