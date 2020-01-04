class Timer extends Thread
{
    public int timerValue = 0;
    public boolean suspended = false;

    Timer (int passedValue) {
        this.timerValue = passedValue;
    }

    public void setTimer(int passedValue) {
        this.timerValue = passedValue;
    }

    public void pause() {
        suspended = true;
    }

    public void cont() {
        suspended = false;
    }

    public void run() {
        while (Thread.currentThread() == this) {
            try {
                sleep(100);
            }
            catch (Exception e) {  }
            if (this.timerValue > 0 && !suspended) this.timerValue--;
        }
    }
}