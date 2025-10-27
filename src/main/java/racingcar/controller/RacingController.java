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
        List<Car> cars = createCars();
        int tryCount = inputTryCount();

        outputView.printResultStart();
        playRace(cars, tryCount);

        List<Car> winner = racingService.findWinner(cars);
        outputView.resultMessage(winner);
    }

    private int inputTryCount(){
        String inputCount = inputView.inputTryCount();
        return inputValidator.validateCount(inputCount);
    }

    private List<Car> createCars(){
        String carNamesInput = inputView.inputCarNames();
        List<String> carNames = inputParser.parseCarNames(carNamesInput);
        inputValidator.validateCarName(carNames);
        return racingService.createCars(carNames);
    }

    private void playRace(List<Car> cars, int tryCount){
        for (int i =0; i < tryCount; i++) {
            racingService.randomMoveCar(cars);
            outputView.printRoundResult(cars);
        }
    }
}
