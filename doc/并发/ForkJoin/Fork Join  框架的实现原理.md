ForkJoinPool 由 ForkJoinTask数组和ForkJoinWorkerThread数组组成，ForkJoinTask数组负责把存放程序提交给ForkJoinPool的任务，而ForkJoinWorkThread数组负责执行这些任务

### ForkJoinTask  的fork 方法实现原理
当调用ForkJoinTask 的fork 方法的时，程序会调ForkJoinWorkThread的push 方法异步地执行这个任务，然后立即返回结果。push()方法将当前任务存放在ForkJoinTask 数组队列里面，然后再调用ForkJoinPool的signalWork()方法唤醒或者创建一个工作线程来执行任务

```
      final void push(ForkJoinTask<?> task) {
            ForkJoinTask<?>[] a; ForkJoinPool p;
            int b = base, s = top, n;
            if ((a = array) != null) {    // ignore if queue removed
                int m = a.length - 1;     // fenced write for task visibility
                U.putOrderedObject(a, ((m & s) << ASHIFT) + ABASE, task);
                U.putOrderedInt(this, QTOP, s + 1);
                if ((n = s - b) <= 1) {
                    if ((p = pool) != null)
                        p.signalWork(p.workQueues, this);
                }
                else if (n >= m)
                    growArray();
            }
        }
```
### ForkJoinTask join 方法的实现原理
Join 方法的主要作用是阻塞当前线程并等待获取结果。

首先调用doJoin方法，通过doJoin()方法得到当前任务的状态来判断返回什么结果，任务状态有 4 种： 已完成（normal） 被取消 （cancelled） 信号（signal） 和出现异常（exceptional）

在doJoin 方法中，首先通过查看任务的状态，看任务是否已经执行完成，如果执行完成，则直接返回任务状态，如果没有执行完成，则从任务数组里面取出任务并执行。如果任务顺利执行完成，。 则设置任务状态为NORMAL如果出现异常，则记录异常，并将任务状态设置为exceptional
