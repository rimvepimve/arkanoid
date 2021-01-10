package arkanoid;

import static arkanoid.Constants.*;

public class AccelerationStrategy implements BallSpeedStrategy {
    @Override
    public boolean isApplicable(int score) {
        return (score % 2 == 0) && (score < (BRICK_ROWS * BRICK_COLUMNS) / 2);
    }

    @Override
    public double execute(double speed) {
        return speed + SPEED_INCREMENT;
    }
}
