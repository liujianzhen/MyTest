场景：
    通过多个线程，有的执行数字的加一操作，有的执行数字的减一操作，实现 010101 这样的输出
 NumberHolder 通过线程的通信机制 wait() 和 notify() 实现了两个线程工作的情况下没问题，但在多个线程时就会出现问题。
 
 jdk1.5中，提供了多线程的升级解决方案：
 将同步synchronized替换为显式的Lock操作，将Object类中的wait(), notify(),notifyAll()替换成了Condition对象，
 该对象可以通过Lock锁对象获取; 一个Lock对象上可以绑定多个Condition对象，这样实现了本方线程只唤醒对方线程
 NumberHolder2 通过此方法实现