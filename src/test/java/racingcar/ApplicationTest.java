package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.*;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private InputParser inputParser;
    private InputValidator inputValidator;
    private static final String INPUT_MESSAGE = "112,119,소방차,경찰차";

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
        inputValidator = new InputValidator();
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 입력값_파싱_테스트() {
        List<String> parsedMessage = inputParser.parseCarNames(INPUT_MESSAGE);

        assertThat(parsedMessage)
                .hasSize(4)
                .containsExactly("112", "119", "소방차", "경찰차");
    }

    @Test
    public void 자동차이름_길이_검증() {
        List<String> carNames = List.of("pobi", "woni11");
        assertThatThrownBy(() -> inputValidator.validationCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5글자 이하여야 합니다");
    }

    @Test
    public void 빈_자동차_이름_검증() {
        List<String> carNames = List.of("pobi", "");
        assertThatThrownBy(() -> inputValidator.validationCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 비어있습니다.");
    }

    @Test
    public void 자동차이름_중복_검증() {
        List<String> carNames = List.of("pobi", "pobi", "canno");
        assertThatThrownBy(() -> inputValidator.validationCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다");
    }

    @Test
    public void 자동차_전진_테스트() {
        List<String> carNames = List.of("pobi", "kk", "canno");
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        GenerateNumber mockNumber = () -> 5;
        RacingService racingService = new RacingService(mockNumber);

        racingService.randomMoveCar(cars);
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_전진_실패_테스트() {
        List<String> carNames = List.of("pobi", "kk", "canno");
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        GenerateNumber mockNumber = () -> 3;
        RacingService racingService = new RacingService(mockNumber);

        racingService.randomMoveCar(cars);
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }

    @Test
    public void 자동자_전진_혼합_테스트() {
        List<String> carNames = List.of("pobi", "kk", "canno");
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        int [] numbers = {4,3,7};
        int[] index = {0};

        GenerateNumber mockNumber = () -> numbers[index[0]++];
        RacingService racingService = new RacingService(mockNumber);

        racingService.randomMoveCar(cars);
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

}
