package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
    private final GenerateNumber numberGenerator;
    public RacingService(GenerateNumber generateNumber) {
        this.numberGenerator = generateNumber;
    }

    public void randomMoveCar(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = numberGenerator.generateNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public List<Car> playGame(List<String> carNames, int tryCount) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        for (int i = 0; i < tryCount; i++) {
            randomMoveCar(cars);
        }
        return  cars;
    }
}
