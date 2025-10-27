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
        String carNamesInput = inputView.inputCarNames();
        String inputCount = inputView.inputTryCount();
        int tryCount = inputValidator.validateCount(inputCount);
        List<String> carNames = inputParser.parseCarNames(carNamesInput);
        inputValidator.validationCarName(carNames);
        List<Car> cars = racingService.createCars(carNames);
        outputView.printResultStart();
        for (int i =0; i < tryCount; i++ ) {
            racingService.randomMoveCar(cars);
            outputView.printRoundResult(cars);
        }
        List<Car> winner = racingService.findWinner(cars);
        outputView.resultMessage(winner);
    }
}
