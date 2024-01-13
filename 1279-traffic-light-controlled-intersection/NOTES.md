#### **Solution 1:**
The critical deciding factor is the the roadId for which the traffic light is green. Therefore the TrafficLight class needs to remember the **currentRoad** that is with the Green light.
And then for every invocation of carArrived() check if the  **currentRoad** is the same as the parameter roadId.
​
Using Semaphores  - only 1 permit suffices.
1. Use a semaphore to make sure the critical section is guarded.
- carArrived() - acquireUninterruptibly() and release()
​
#### **Solution 2:**
Using ReentrantLock
1. Use a ReentrantLock - use lock() and unlock() to enter and exit critical sections.
​
| Feature                       | ReentrantLocks                                   | Semaphores                                      |
|-------------------------------|--------------------------------------------------|-------------------------------------------------|
| Reentrancy                    | Supports reentrancy (a thread can acquire the lock multiple times) | Does not support reentrancy                      |
| Fine-grained Control          | Provides fine-grained control with conditions    | Generally used for resource counting and simple synchronization |
| Condition Variables           | Built-in support for condition variables         | Does not have built-in support for condition variables |
| Interruptible Locking         | Supports interruptible locking                  | Does not support interruptible locking           |
| Performance                   | Can have better performance in certain scenarios | Can be heavier in terms of resource usage         |
| Fairness                       | Provides fairness options (fair lock acquisition) | Fairness is not guaranteed by default             |
| Built-in Try-Lock             | Built-in support for tryLock() method            | Does not have built-in support for t
​