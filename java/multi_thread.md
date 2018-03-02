


当线程创建和销毁的时间大于任务执行的时间时，就需要考虑使用线程池了





1. sleep() 和 wait() 的区别就是 调用sleep方法的线程不会释放对象锁，而调用wait() 方法会释放对象锁

sleep()一般定时，而wait()需要对象notify()





package com.test;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Semaphore;

public class TestSemaphore {

                public static void main(String[] args) {

                // 线程池

                ExecutorService exec = Executors.newCachedThreadPool();

                // 只能5个线程同时访问

                final Semaphore semp = new Semaphore(5);

                 // 模拟20个客户端访问

                 for (int index = 0; index < 20; index++) {

                              final int NO = index;

                              Runnable run = new Runnable() {

                                                 public void run() {

                                                            try {

                                                                    // 获取许可

                                                                    semp.acquire();

                                                                    System.out.println("Accessing: " + NO);

                                                                    Thread.sleep((long) (Math.random() * 10000));

                                                                    // 访问完后，释放

                                                                    semp.release();

                                                                    System.out.println("-----------------"+semp.availablePermits());

                                                            } catch (InterruptedException e) {

                                                                    e.printStackTrace();

                                                            }

                                                  }

                                      };

                      exec.execute(run);

             }

             // 退出线程池

             exec.shutdown();

       }

} 
