package lab01;

public class ArrayAndCasting {

    private double[] numbers;

    public ArrayAndCasting(double[] numbers) {
        this.numbers = numbers;
    }

    public int[] convertToInt(double[] numbers) {
        int[] integers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integers[i] = (int) numbers[i];
        }
        return integers;
    }
}
