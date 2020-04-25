package concurrentDemo;

public class ConcurrencyTest {
    private static final long count = 10001;
    private static void concurrency(){
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        int a = 0;
                        for (long i =0 ;i<count ;i++){
                            a += 5;
                        }
                    }
                }
        );
        thread.start();
        int b  =0;
        for(long i =0 ;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :"+ time+"ms,b = "+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        long a = 0;
        for (long i = 0;i<count;i++){
            a +=5;
        }
        int b = 0;
        for(long i =0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Serial:"+time+"ms;b = "+b);
    }


    public static void main(String[] args) {
        concurrency();
        serial();
    }
}
