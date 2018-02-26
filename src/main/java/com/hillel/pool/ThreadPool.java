package com.hillel.pool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

  private CustomBlockingQueue customBlockingQueue;
  private List<ThreadInPool> list = new ArrayList<>();
  private List<Thread> threads = new ArrayList<>();

  public ThreadPool (int numberOfThreads) {
    customBlockingQueue = new CustomBlockingQueue(10);
    for (int i = 0; i < numberOfThreads; i++) {
      ThreadInPool threadInPool = new ThreadInPool(customBlockingQueue);
      list.add(threadInPool);
      Thread thread = new Thread(threadInPool);
      threads.add(thread);
      thread.start();

    }
  }

  public void execute(Runnable task) {
    customBlockingQueue.addTask(task);
  }

  public void terminate() {
    for (ThreadInPool threadInPool : list) {
      threadInPool.stop();
    }
    customBlockingQueue.terminate();
  }

}
