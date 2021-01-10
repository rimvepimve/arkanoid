package arkanoid;

public interface BallSpeedStrategy {
    boolean isApplicable(int i);
    double execute(double d);
}
