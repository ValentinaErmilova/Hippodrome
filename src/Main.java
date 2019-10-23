import java.util.Arrays;
import java.util.List;

public class Main {
    private List<Horse> horses;
    static Main game;

    private List<Horse> getHorses() {
        return this.horses;
    }

    private Main(List<Horse> horses) {
        this.horses = horses;
    }

    private void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    private void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private Horse getWinner(){
        Horse winner = null;
        double distance = getHorses().get(0).getDistance();
        for (int i = 0; i < horses.size(); i++) {
            if (getHorses().get(i).getDistance() > distance){
                winner = getHorses().get(i);
                distance = winner.getDistance();
            }
        }

        return winner;
    }

    private void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    private void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        try {
            Main.game = new Main(Arrays.asList(
                    new Horse("Red", 3, 0),
                    new Horse("Blue", 3, 0),
                    new Horse("Green", 3, 0)
            ));
            game.run();
            game.printWinner();
        } catch(Exception e) {

        }
    }
}
