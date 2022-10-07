package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;

    public RacingCarGame() {
        cars = new ArrayList<>();
    }

    protected void run() {
        start();
    }

    private void start() {
        Player player = new Player();
        setCars(player);
        player.setRaceCount();
    }

    private void setCars(Player player) {
        try {
            player.setCarNames();
            setCar(player.getCarNames());
            sizeValidation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCars(player);
        }
    }

    private void setCar(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
    }

    private void sizeValidation() {
        if (cars.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_EMPTY.getMessage());
        }
    }

}