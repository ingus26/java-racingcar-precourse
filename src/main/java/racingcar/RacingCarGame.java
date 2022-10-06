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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setCars(player);
        }
    }

}