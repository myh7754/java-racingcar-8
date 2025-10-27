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

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return cars;
    }

    public List<Car> findWinner(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .collect(Collectors.toList());
    }

}
