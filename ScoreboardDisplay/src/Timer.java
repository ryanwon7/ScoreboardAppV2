public class Timer extends Thread {
    private int timerValue = 0;
    private boolean paused = false;

    public Timer(int startAmount) {
        this.timerValue = startAmount;
    }

    public void setTimer(int newValue) {
        this.timerValue = newValue;
    }

    public void pause() {
        this.paused = true;
    }

    public void start() {
        this.paused = false;
    }

    public void run() {
        while (Thread.currentThread() == this) {
            try {
                sleep(100);
            } catch (Exception e) {
            }
            if (this.timerValue > 0 && !paused) {
                this.timerValue--;
            }
        }
    }
}
