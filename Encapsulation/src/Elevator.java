public class Elevator {
    private int minFloor;
    private int maxFloor;
    private int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveDown() {
        currentFloor = currentFloor - 1;
    }
    public void moveUp() {
        currentFloor = currentFloor + 1;
    }
    public void move(int floor) {
        if (floor >= minFloor && floor <= maxFloor) {
            while (floor != currentFloor) {
                if (floor > currentFloor)
                    moveUp();
                else moveDown();
                System.out.println(getCurrentFloor());
            }
        } else if (floor == currentFloor) {
        } else {
            System.out.println("Ошибка ввода этажа!");
        }
    }
}
