import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(new File(args[0]))){
                Library.initbook(scn);
                Library.inituser(scn);
                Library.cmd(scn);
        }catch (Exception e){
            System.out.println("error to readfile");
            System.out.println("try to type \"java Main sampleInput\"");
            e.printStackTrace();
        }
    }
}
