package com.hillel.pool;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    int cpus = 4;

    ThreadPool threadPool = new ThreadPool(cpus);
    threadPool.execute(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Some task 1");
    });
    threadPool.execute(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Some task 1.1");
    });
    threadPool.execute(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Some task 1.2");
    });
    threadPool.execute(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Some task 1.3");
    });
    threadPool.execute(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Some task 1.4");
    });
    threadPool.execute(() -> System.out.println("Some task 3"));
    threadPool.execute(() -> System.out.println("Some task 4"));
    threadPool.execute(() -> System.out.println("Some task 5"));
    threadPool.execute(() -> System.out.println("Some task 6"));
    threadPool.execute(() -> System.out.println("Some task 7"));
    threadPool.execute(() -> System.out.println("Some task 8"));
    threadPool.execute(() -> System.out.println("Some task 9"));
    threadPool.execute(() -> System.out.println("Some task 0"));

    Thread.sleep(30000);
    System.out.println("before stop");
    threadPool.terminate();
    System.out.println("after stop");

  }
}
