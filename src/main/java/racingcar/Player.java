package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.platform.commons.util.StringUtils;

public class Player {

    String carName;

    int raceCount;

    protected String[] getCarNames() {
        return this.carName.split(Config.PREFIX);
    }

    protected void setCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES.getMessage());
        try {
            this.carName = readLine();
            nullValidation();
            overlapValidation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCarNames();
        }
    }

    private void overlapValidation() {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(getCarNames()));

        if (carNameSet.size() != getCarNames().length) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_OVERLAY.getMessage());
        }
    }

    private void nullValidation() {
        if (StringUtils.isBlank(this.carName)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY.getMessage());
        }
    }

}