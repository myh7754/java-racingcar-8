package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;

public class RacingService {
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void play(int tryCount, Cars car) {
        for  (int i = 0; i < tryCount; i++) {
            int randomNumber = generateRandomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }
}
