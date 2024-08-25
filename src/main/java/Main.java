import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    static int maxSpeed = 250;
    static int minSpeed = 0;


    public static void main(String[] args) {
        Car[] raceCars = new Car[3];

        System.out.println("24 часа Ле-Мана");
        System.out.println("В нашей гонке участвует 3 автомобиля");
        System.out.println("Вам необходимо поочередно ввести Название и Скорость каждого авто");
        System.out.println("Важно! Скорость авто не должна превышать 250 км/час");
        System.out.println("Далее мы определим победителя - кто проехал наибольшую дистанцию");
        System.out.println("Начнем.");


        for (int i = 0; i < raceCars.length; i++) {
            System.out.println("Введите название " + (i + 1) + "-го автомобиля:");
            String carName = scanner.next();
            System.out.println("Введите скорость " + (i + 1) + "-го автомобиля:");

            int carSpeed;

           while (true) {
               //проверка на ввод целого числа, удовлетворяющего условию задачи
               if (scanner.hasNextInt()) {
                   carSpeed = scanner.nextInt();
                   if (carSpeed > minSpeed && carSpeed < maxSpeed) {
                       break;
                   }
               }
               else {
                   scanner.next();
               }
               System.out.println("Данные некорректны. Введите целое число от 0 до 250");
           }
            raceCars[i] = new Car(carName, carSpeed);
        }
        System.out.println("Самый быстрый автомобиль: " + Race.raceResult(raceCars));
    }
}

class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    public static String raceResult (Car[] raceCars) {
        int maxSpeedIndex = 0;
        int maxRaceSpeed = raceCars[0].speed;
        for (int i = 0; i < raceCars.length; i++) {
            if (raceCars[i].speed > maxRaceSpeed) {
                maxRaceSpeed = raceCars[i].speed;
                maxSpeedIndex = i;
            }
        }
        return raceCars[maxSpeedIndex].name;
    }
}
