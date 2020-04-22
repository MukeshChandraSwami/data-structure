package dto;

public class QueueDto {

    private int data;
    private int priority;

    public QueueDto(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
