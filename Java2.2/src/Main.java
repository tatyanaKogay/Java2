public class Main {
    public static void main(String[] args) {
        try {
            sum(array("222222222222p221"));
        } catch (MyArraySizeException se){
            System.out.println(se.getMessage());
        } catch (MyArrayDataException de){
            System.out.println(de.getMessage());        }
    }

    public static String[][] array(String s) throws MyArraySizeException{

        int i, j;
        int let = 0;
        String[][] arr = new String[4][4];

        try {
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    arr[i][j] = String.valueOf(s.charAt(let++));
                }
            }
        } catch (StringIndexOutOfBoundsException sioobe){
            throw new MyArraySizeException("Wrong array size");
        }
        return arr;
    }

    public static void sum(String[][]sArr) throws MyArrayDataException{
        int sum = 0;
        int i,j;
        try{
            for (i=0; i<4; i++){
                for (j=0; j<4; j++){
                    Integer ad = Integer.parseInt(sArr[i][j]);
                    sum += ad;
                }
            }
        } catch (NumberFormatException nfe){
            throw new MyArrayDataException("Not integer value");
        }

        System.out.println("Result: " + (sum/2));
    }
}
