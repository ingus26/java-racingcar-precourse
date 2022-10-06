package racingcar;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    String name;

    int moveCount;

    public Car(String name) {
        if (nullValidation(name) && sizeValidation(name)) {
            this.name = name;
        }
        this.moveCount = 0;
    }

    protected String getName() {
        return this.name;
    }

    protected void setMoveCount() {
        this.moveCount += 1;
    }

    protected int getMoveCount() {
        return this.moveCount;
    }

    private boolean sizeValidation(String name) {
        if (name.length() > Config.MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_MAX_SIZE.getMessage());
        }
        return true;
    }

    private boolean nullValidation(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_MAX_SIZE.getMessage());
        }
        return true;
    }

}