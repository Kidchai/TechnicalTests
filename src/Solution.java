import Exceptions.FileNotFoundGameException;
import Exceptions.IllegalArgumentGameException;

import java.io.IOException;

public class Solution {
    public static int getResult(String filePath) throws FileNotFoundGameException, IllegalArgumentGameException, IOException {
        Configuration configuration = new Configuration(filePath);

        Map map = new Map(configuration.getMapLine(), 4, 4);

        map.calculateCosts(map.get(0,0), configuration.getRaceCosts());

        return map.get(3, 3).getCost();
    }
}
