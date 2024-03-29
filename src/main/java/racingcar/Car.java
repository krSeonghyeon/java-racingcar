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
        int pickedNumber = Randoms.pickNumberInRange(0, 9);

        if (IsValid(pickedNumber)) {
            position++;
        }
    }

    private boolean IsValid(int pickedNumber) {
        return pickedNumber >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
