import Exceptions.BaseException;

public class Main {

    public static void main(String[] args) {
        String filePath = "";
        if (args.length != 0) {
            filePath = args[0];
        }

        try {
            System.out.println(Solution.getResult(filePath));
        } catch (BaseException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}