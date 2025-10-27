package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public void printResultStart() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName()+" : "+ "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void resultMessage(List<Car> resultMessage) {
        System.out.println("1번 자동차" + resultMessage.get(0).getPosition());
        System.out.println("2번 자동차" + resultMessage.get(1).getPosition());
        System.out.println("3번 자동차" + resultMessage.get(2).getPosition());
    }
}
