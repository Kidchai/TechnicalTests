import Exceptions.BaseException;

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