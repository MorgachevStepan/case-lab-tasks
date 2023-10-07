package hm4.Concurrency;

/**
 * @author Stepan Morgachev
 * @date 07.10.2023 18:04
 */
public class Main {
    public static void main(String[] args) {
        HelloSpeaker helloSpeaker = new HelloSpeaker();
        helloSpeaker.start();
        while (true){
            System.out.println("Работает основная программа");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

class HelloSpeaker extends Thread{
    @Override
    public void run(){
        while(true) {
            try {
                sleep(10000);
                System.out.println("Ассинхронный привет");
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("Ассинхронный пока");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
