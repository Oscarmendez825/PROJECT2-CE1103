package com.sample2;
/***
 * Executer class of the user management interface.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class RUNMAIN2 {
    /***
     * This method initializes the user manager interface.
     */
    public void iniciar(){
        Main2 main2 = new Main2();
        Thread thread = new Thread(main2);
        thread.start();
    }
}
