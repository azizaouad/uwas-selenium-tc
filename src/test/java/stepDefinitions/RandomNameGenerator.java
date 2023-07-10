package stepDefinitions;

import java.util.Random;

public class RandomNameGenerator  {
    private static final String RANDOM_NAME;
        static {
        String[] names = {"restore", "tester","glovo","jumia","Charlie", "arch","archee","test","qa","automation","code", "kk","hh","lmlm","mp","mplol"};
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












