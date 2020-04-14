package dto;

public class StackDto {

    private int min;
    private int max;
    private int data;

    public StackDto() {}

    public StackDto(int min, int max, int data) {
        this.data = data;
        this.min = min;
        this.max =  max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
