package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

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
}
