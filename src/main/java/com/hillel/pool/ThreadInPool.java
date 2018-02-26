package com.hillel.pool;

public class ThreadInPool implements Runnable {

  private boolean finished;
  private CustomBlockingQueue queue;

  public ThreadInPool(CustomBlockingQueue queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
      while (!finished) {
        Runnable task;
        try {
          task = queue.pollTask();
          task.run();
        } catch (Exception ignored) {
        }
      }
  }

  public void stop() {
    this.finished = true;
  }
}
