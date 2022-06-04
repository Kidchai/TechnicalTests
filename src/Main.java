import Exceptions.BaseException;
import Exceptions.FileNotFoundGameException;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(Solution.getResult());
        } catch (BaseException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}