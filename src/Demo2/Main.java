package Demo2;

public class Main {
    public static void main(String[] args) {
        System.out.println("面向对象运行结果：");
        Input input = new Input();
        input.input("D:\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\output.txt");

    }
}
