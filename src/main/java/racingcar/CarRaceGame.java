package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGame {
    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String allCarNames = Console.readLine();
        String[] carNames = allCarNames.split(",");
        validateCarNames(carNames);

        return carNames;
    }

    private List<Car> createCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);

        return tryCount;
    }

    private void printResult(List<Car> cars, int tryCount) {
        System.out.println("\n실행결과");
        Race race = new Race(cars, tryCount);
        race.startRace();
    }

    public void startGame() {
        String[] carNames = getCarNames();

        List<Car> cars = createCar(carNames);

        int tryCount = getTryCount();

        printResult(cars, tryCount);
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }
}
