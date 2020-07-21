package com.sample2;

public class RUNMAIN2 {

    public void iniciar(){
        Main2 main2 = new Main2();
        Thread thread = new Thread(main2);
        thread.start();
    }
}
