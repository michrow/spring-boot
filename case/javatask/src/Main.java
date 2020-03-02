import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

    }

    public void playTimer(){
        System.out.println("Hello World!");
        System.out.println(System.currentTimeMillis());
        Timer timer = new Timer();
        timer.schedule(new MyTask(),3000,1000);
    }

}
class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+"  执行MyTask任务");
    }
}