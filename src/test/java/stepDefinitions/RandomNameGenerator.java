package stepDefinitions;

import java.util.Random;

public class RandomNameGenerator  {
    private static final String RANDOM_NAME;
        static {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack", "test","qa","automation","code"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        RANDOM_NAME = names[index];
    }

    public static String getConstantRandomName() {
        return RANDOM_NAME;
    }
//     public static String getConstantRandomNames() {
//         if (RANDOM_NAME!=null){
//             RANDOM_NAME.toUpperCase();
//         }else{
//             RANDOM_NAME = "error";
//         }
//         return RANDOM_NAME;
//     }
}
