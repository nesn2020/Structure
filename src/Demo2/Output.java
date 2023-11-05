package Demo2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;

    public Output(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public void output(String filename){
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            int n = 1;
            while (it.hasNext()) {
                String str = it.next();
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
    }
}
