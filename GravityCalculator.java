class GravityCalculator {
  public static void main(String[] arguments) {
    double gravity = -9.81;
    double initialVelocity = 0.0;
    double fallingTime = 10.0;
    double initialPosition = 0.0;
    double finalPosition = 0.0;
    double positionAfter10s = 0.5 * gravity * 10 * 10 + initialPosition + initialVelocity * 10;
    System.out.println("The object's position after " + fallingTime + " seconds is " + finalPosition + " m.");
    System.out.println("The object's position after 10 seconds is " + positionAfter10s + " m.");
  }
}
