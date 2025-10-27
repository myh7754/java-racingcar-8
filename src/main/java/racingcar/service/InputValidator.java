package racingcar.service;

import java.util.List;

public class InputValidator {
    public void validationCarName(List<String> carNames){
        carNames.stream().forEach(carName -> {
            if(carName.isEmpty()){
                throw new IllegalArgumentException("차 이름이 비어있습니다.");
            }
            if(carName.length() >5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다");
            }
        });

        long distinctCount = carNames.stream().distinct().count();
        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다");
        }
    }

}
