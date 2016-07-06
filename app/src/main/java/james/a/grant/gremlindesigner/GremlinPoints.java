package james.a.grant.gremlindesigner;

import android.graphics.PointF;

public class GremlinPoints {

    private PointF center;
    private PointF body;
    private PointF eyes;
    private PointF head;
    private PointF hands;
    private PointF feet;
    private float stepSize;

    public static GremlinPoints create(float width, float height, float scaleX, float scaleY) {
        return new GremlinPoints(width, height, scaleY, scaleY);
    }

    public GremlinPoints(float width, float height, float scaleX, float scaleY) {
        this.stepSize = Math.max(width / scaleX, height / scaleY) / 100f;
        //
        center = new PointF(width / 2f, height / 2f);
        body = translateFromPointByPercentage(center, 0, -10);
        head = translateFromPointByPercentage(center, 0, -35);
        eyes = translateFromPointByPercentage(center, 0, -37);
        hands = translateFromPointByPercentage(center, 0, 5);
        feet = translateFromPointByPercentage(center, 0, 40);
    }

    private PointF translateFromPointByPercentage(PointF origin, float xPercent, float yPercent) {
        return new PointF(origin.x + (stepSize * xPercent), origin.y + (stepSize * yPercent));
    }

    public PointF getCenter() {
        return center;
    }

    public PointF getBody() {
        return body;
    }

    public PointF getEyes() {
        return eyes;
    }

    public PointF getHead() {
        return head;
    }

    public float getStepSize() {
        return stepSize;
    }

    public PointF getHands() {
        return hands;
    }

    public PointF getFeet() {
        return feet;
    }

}
