
public class Vector2 {
    int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Vector2 opposit) {
        if (opposit.y == y && opposit.x == x)
            return true;
        return false;
    }

    public float getDistance(float x, float y) {
        float dx = x - this.x;
        float dy = y - this.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
