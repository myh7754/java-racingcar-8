package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class RacingService {
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void randomMoveCar(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= 5) {
                car.move();
            }
        }
    }
}
