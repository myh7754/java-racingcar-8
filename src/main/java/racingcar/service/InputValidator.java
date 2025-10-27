package racingcar.service;

import java.util.List;

public class InputValidator {
    public void validateCarName(List<String> carNames){
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
    public int validateCount(String inputCount) {
        try {
            return Integer.parseInt(inputCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해야 합니다: "+ inputCount);        }
    }

}
