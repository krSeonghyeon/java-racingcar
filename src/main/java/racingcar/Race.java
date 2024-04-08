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

    private void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printProgress() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners() {
        List<String> winners = new ArrayList<>();

        findWinners(winners);

        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

    private void findWinners(List<String> winners) {
        int maxPosition = 0;

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
    }

    public void startRace() {
        for (int i = 0; i < tryCount; ++i) {
            moveAllCars();
            printProgress();
        }
        printWinners();
    }
}
