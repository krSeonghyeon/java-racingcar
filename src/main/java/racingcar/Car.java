package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (checkNotMove())    return;
        position++;
    }

    private boolean checkNotMove() {
        return Randoms.pickNumberInRange(0, 9) < 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
