package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carNameArray = carNames.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNameArray) {
            cars.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("\n실행결과");
        Race race = new Race(cars, tryCount);
        race.startRace();
    }
}
