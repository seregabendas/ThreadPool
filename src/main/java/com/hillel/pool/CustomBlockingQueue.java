package com.hillel.pool;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue {

  private Queue<Runnable> queue;
  private int maxSize;
  private boolean isToTerminate;
  private final Object synchroMain = new Object();
  private final Object synchroThread = new Object();


  public CustomBlockingQueue(int maxSize) {
    this.maxSize = maxSize;
    queue = new LinkedList<>();
  }

  public void addTask(Runnable task) {
    synchronized (synchroMain) {
      while (queue.size() >= maxSize) {
        try {
          synchroMain.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      queue.add(task);

      synchronized (synchroThread) {
        synchroThread.notify();
      }
    }
  }

  public Runnable pollTask() throws Exception {
    synchronized (synchroThread) {
      while (queue.isEmpty()) {
        if (isToTerminate) {
          throw new Exception("Que is terminated");
        }
        try {
          synchroThread.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      Runnable task = queue.poll();
      synchronized (synchroMain) {
        synchroMain.notify();
      }

      return task;
    }
  }

  public void terminate() {
    isToTerminate = true;
    synchronized (synchroThread) {
      synchroThread.notifyAll();
    }
  }
}
