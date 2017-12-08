public class Volatiless {

        public void main(String[] args)
        {
            Clock clock = new Clock();
            Thread clockThread = new Thread(clock);
            clockThread.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clock.cancel();
        }


        class Clock implements Runnable
        {
            private volatile boolean isCancel = false;

            public void cancel()
            {
                this.isCancel = true;
            }

            public void run()
            {
                while (!this.isCancel)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Tik");
                }
            }
        }
    }

