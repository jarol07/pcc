package org.ulasalle.pcc.fourthread;

public class ThreadSingleton extends Thread {

    private int id;
    private final Singleton singleton = Singleton.singleton;

    public ThreadSingleton(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            singleton.setIncrement(singleton.getIncrement() + 1);
            //System.out.println(id + " - " + singleton.getIncrement());
        }
    }

}
