package Demo3;

public class KWICSubject extends Subject{
    public void startKWIC(){
        for (int i = 0;i<4;i++){
            this.notifyOneObserver(i);
        }
    }
}
