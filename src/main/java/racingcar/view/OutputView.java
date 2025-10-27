package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void resultMessage(List<Car> resultMessage) {
        System.out.println("1번 자동차" + resultMessage.get(0).getPosition());
        System.out.println("2번 자동차" + resultMessage.get(1).getPosition());
        System.out.println("3번 자동차" + resultMessage.get(2).getPosition());
    }
}
