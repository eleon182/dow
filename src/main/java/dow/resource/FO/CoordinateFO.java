package dow.resource.FO;

/**
 * Created by steve on 10/19/15.
 */
public class CoordinateFO{
    private String x;
    private String y;

    public CoordinateFO(String x) {
        this.x = x;
    }

    public CoordinateFO(String x, String y) {

        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
