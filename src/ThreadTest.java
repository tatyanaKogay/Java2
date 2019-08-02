public class ThreadTest {

    private static final int SIZE = 1000000;
    private static final int HALF = SIZE/2;
    /**через классы и метод join() у меня не получилось(((, подскажите пожалуйста, в чем ошибка*/

 /*   private static class Test1 extends Thread{
        @Override
        public void run(){
            fillArr1();
        }
        public void fillArr1(){
            float[] arr = new float[SIZE];
            for (int i = 0; i<SIZE; i++){
                arr[i] = 1;
            }
            for (int j = 0; j<SIZE; j++){
                arr[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                        Math.cos(0.4f + j / 2));
            }
        }
    }

    private static class Test2 implements Runnable{
        @Override
        public void run(){
            fillArr2();
        }
        public void fillArr2(){
            float[] arr = new float[SIZE];
            float[] arrHalf1 = new float[HALF];
            float[] arrHalf2 = new float[HALF];
            for (int i = 0; i<SIZE; i++){
                arr[i] = 1;
            }
            System.arraycopy(arr,0,arrHalf1,0,HALF);
            System.arraycopy(arr,HALF,arrHalf2,0,HALF);
                    for (int j = 0; j<HALF; j++){
                        arrHalf1[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                                Math.cos(0.4f + j / 2));
                    }

                    for (int j = 0; j<HALF; j++){
                        arrHalf2[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                                Math.cos(0.4f + j / 2));
                    }
            System.arraycopy(arrHalf1,0,arr,0,HALF);
            System.arraycopy(arrHalf2,0,arr,HALF,HALF);
        }
    }

    private static class Test3 implements Runnable{
        Thread thread  = new Thread(this);
        @Override
        public void run(){
            thread.start();
            fillArr3();
        }
        public void fillArr3(){
            float[] arr = new float[SIZE];
            float[] arrHalf1 = new float[HALF];
            float[] arrHalf2 = new float[HALF];
            for (int i = 0; i<SIZE; i++){
                arr[i] = 1;
            }
            System.arraycopy(arr,0,arrHalf1,0,HALF);
            System.arraycopy(arr,HALF,arrHalf2,0,HALF);
            Runnable r1 = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j<HALF; j++){
                        arrHalf1[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                                Math.cos(0.4f + j / 2));
                    }
                }
            };
            Runnable r2 = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j<HALF; j++){
                        arrHalf2[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                                Math.cos(0.4f + j / 2));
                    }
                }
            };
            new Thread(r1).start();
            new Thread(r2).start();
            System.arraycopy(arrHalf1,0,arr,0,HALF);
            System.arraycopy(arrHalf2,0,arr,HALF,HALF);
        }
    }*/


    public static void main(String[] args) {/*TODO*/
        ThreadTest test = new ThreadTest();
        long a = System.currentTimeMillis();

/*        Thread t1 = new Test1();
        t1.start();

        Thread t2 = new Thread(new Test2());

        Test3 t3 = new Test3();

        try{
            t1.join();
            System.out.println(System.currentTimeMillis()-a);
            t2.join();
            System.out.println(System.currentTimeMillis()-a);
            t3.thread.join();
            System.out.println(System.currentTimeMillis()-a);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
*/
        test.fillArr1();
        System.out.println(System.currentTimeMillis()-a);
        test.fillArr2();
        System.out.println(System.currentTimeMillis()-a);

    }



    public void fillArr1(){
        float[] arr = new float[SIZE];
        for (int i = 0; i<SIZE; i++){
            arr[i] = 1;
        }
        for (int j = 0; j<SIZE; j++){
            arr[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                    Math.cos(0.4f + j / 2));
        }
    }

    public void fillArr2(){/*если раскоментировать код, то время выполнения будет 407*/
        float[] arr = new float[SIZE];
        float[] arrHalf1 = new float[HALF];
        float[] arrHalf2 = new float[HALF];
        for (int i = 0; i<SIZE; i++){
            arr[i] = 1;
        }
        System.arraycopy(arr,0,arrHalf1,0,HALF);
        System.arraycopy(arr,HALF,arrHalf2,0,HALF);
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
                for (int j = 0; j<HALF; j++){
                    arrHalf1[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                            Math.cos(0.4f + j / 2));
                }
//            }
//        };
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
                for (int j = 0; j<HALF; j++){
                    arrHalf2[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                            Math.cos(0.4f + j / 2));
                }
//            }
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
        System.arraycopy(arrHalf1,0,arr,0,HALF);
        System.arraycopy(arrHalf2,0,arr,HALF,HALF);
    }

}
