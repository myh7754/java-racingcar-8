package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber implements  GenerateNumber{
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    };
}
