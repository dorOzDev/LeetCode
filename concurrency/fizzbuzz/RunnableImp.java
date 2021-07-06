package concurrency.fizzbuzz;

class RunnableImp implements Runnable {

    private String msg;

    public RunnableImp(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println(msg);
    }
}