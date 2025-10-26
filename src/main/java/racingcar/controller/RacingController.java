package racingcar.controller;

import racingcar.service.InputParser;
import racingcar.service.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    public RacingController() {
        this.inputView = new InputView();
        this.inputParser = new InputParser();
        this.inputValidator = new InputValidator();
    }
    public void run() {
        inputView.inputTryCount();
        String s = inputView.inputCarNames();
        List<String> strings = inputParser.parseCarNames(s);
        inputValidator.validationCarName(strings);

    }
}
