package demo;

/**
 * Demostration business logic.
 * Created by adamd on 6/19/2018.
 */
public class FooClass {
    public static int SUCCESS_CODE = 1;

    public String doBusinessLogic(int someCode) {
        String result = "FAILURE";

        if (someCode == SUCCESS_CODE) {
            result = "SUCCESS";
        }

        return result;
    }
}
