/**
TrafficLight class needs to remember the **currentRoad**
Solution 1: Use a semaphore to make sure the critical section is guarded.
- carArrived() - acquireUninterruptibly() and release()
Solution 2: Use a ReentrantLock - use lock() and unlock() to enter and exit critical sections.


*/

class TrafficLight {

    int currentRoad;
    // Semaphore semaphore;
    Lock lock;

    public TrafficLight() {
        this.currentRoad = 1; 
        // this.semaphore = new Semaphore(1);
        lock = new ReentrantLock(true); // true indicates fairness   
    }
    
    /** Using ReentrantLock */
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        this.lock.lock();
        if (this.currentRoad != roadId) {
            turnGreen.run(); // turning green for the roadId
            this.currentRoad = roadId;
        }
        crossCar.run();
        this.lock.unlock();
    }

    /** Using Semaphore */
    /**
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        
        this.semaphore.acquireUninterruptibly();
        if (this.currentRoad != roadId) {
            turnGreen.run(); // turning green for the roadId
            this.currentRoad = roadId;
        }
        crossCar.run();
        this.semaphore.release();

    }
    */
}