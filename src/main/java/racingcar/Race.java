package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int tryCount;

    public Race(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int currentPosition = car.getPosition();

            if (currentPosition > maxPosition) {
                maxPosition = currentPosition;
                winners.clear();
                winners.add(car.getName());
            } else if (currentPosition == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

    public void startRace() {
        for (int i = 0; i < tryCount; ++i) {
            moveAllCars();
            printResult();
        }
        printWinners();
    }
}
