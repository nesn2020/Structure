package Demo4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("管道-过滤运行结果：");
        File inFile = new File("D:\\input.txt");
        File outFile = new File("D:\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}
