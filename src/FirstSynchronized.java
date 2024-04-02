import java.util.ArrayList;
import java.util.Random;

//TODO:
// o	Создайте класс, который содержит синхронизированный список (например, ArrayList).
// o	Создайте несколько потоков, которые параллельно будут выполнять поиск рандомного
//      элемента в этом списке. У каждого потока будет свой элемент.
// o	Используйте блокирующую синхронизацию (synchronized) при доступе к списку.
public class FirstSynchronized {
    private static final ArrayList<Integer> synchronizedList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            synchronizedList.add(i);
        }
        System.out.println(synchronizedList);
        for (int i = 0; i < 3; i++) {
            Thread synchronizedSearchThread = new Thread(new search());
            synchronizedSearchThread.start();
        }

    }

    static class search implements Runnable {

        @Override
        public void run() {
            Random random = new Random();
            synchronized (synchronizedList) {
                int index = random.nextInt(synchronizedList.size());
                int number = synchronizedList.get(index);
                System.out.println();
                System.out.println("Элемент " + index + " по индексу " + number);
            }
        }
    }

}
