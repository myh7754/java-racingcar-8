package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final RacingService racingService;
    private final GenerateNumber generateNumber;
    private final OutputView outputView;
    public RacingController() {
        this.inputView = new InputView();
        this.inputParser = new InputParser();
        this.inputValidator = new InputValidator();
        this.generateNumber = new GenerateRandomNumber();
        this.racingService = new RacingService(generateNumber);
        this.outputView = new OutputView();
    }
    public void run() {
        int i = inputView.inputTryCount();
        String s = inputView.inputCarNames();
        List<String> strings = inputParser.parseCarNames(s);
        inputValidator.validationCarName(strings);
        List<Car> cars = racingService.playGame(strings, i);
    }
}
