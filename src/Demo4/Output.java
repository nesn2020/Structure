package Demo4;

import java.io.*;

public class Output extends Filter {
    private File file;
    public Output(File file,Pipe input) {
        super(input, null);
        this.file = file;
    }

    @Override
    public void transform() throws IOException {
        BufferedWriter outputFile =null;
        String line;
        try {
            outputFile = new BufferedWriter(new FileWriter(file));
            int n = 1;
            while (input.hashNextLine()) {
                String str = input.readerLine();
                outputFile.write(str+"\n");
                System.out.println("output.txt第" + n + "行："+ str);
                n++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (outputFile!=null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        input.closeReader();
    }
}
