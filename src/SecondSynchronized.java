//TODO:
// o Создайте класс, который содержит синхронизированный список (например, LinkedList).
// o Создайте несколько потоков, каждый из которых будет сортировать свою часть списка.
// o Используйте блокирующую синхронизацию (synchronized) при доступе к списку.

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Sorting implements Runnable {

    private final List<Integer> synchronizedList;

    public Sorting(List<Integer> numbers) {
        synchronizedList = Collections.synchronizedList(numbers);
    }

    @Override
    public void run() {
        synchronized (synchronizedList) {
            Collections.sort(synchronizedList);
            System.out.println(Thread.currentThread().getName() + ": Sorted part of the list: " + synchronizedList);
        }
    }
}

public class SecondSynchronized {
    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            numbers.add(new Random().nextInt(100));
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Sorting(numbers.subList(i * 10, (i + 1) * 10))).start();
        }
        System.out.println(numbers);
    }
}
