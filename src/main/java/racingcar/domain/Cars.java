package racingcar.domain;

public class Cars {
    public String name;
    public int position;

    public Cars(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
