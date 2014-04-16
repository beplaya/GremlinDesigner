package com.aj.gremlindesigner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import com.aj.gremlindesigner.R.drawable;

public class GremlinViewer extends View {

	private Bitmap bmStickBody;
	private Gremlin gremlin;

	public GremlinViewer(Context context) {
		super(context);
		init();
	}

	public GremlinViewer(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GremlinViewer(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		bmStickBody = BitmapFactory.decodeResource(getResources(), drawable.stickbody);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (gremlin == null)
			return;
		//
		float width = canvas.getWidth();
		float height = canvas.getHeight();
		float scaleX = width / bmStickBody.getWidth();
		float scaleY = height / bmStickBody.getHeight();
		//
		GremlinPoints gPoints = GremlinPoints.create(width, height, scaleX, scaleY);
		canvas.scale(scaleX, scaleY, gPoints.getCenter().x, gPoints.getCenter().y);

		drawBitmap(bmStickBody, canvas, gPoints.getCenter());
		drawBitmap(gremlin.body, canvas, gPoints.getBody());
		drawBitmap(gremlin.head, canvas, gPoints.getHead());
		drawBitmap(gremlin.eyes, canvas, gPoints.getEyes());
		drawBitmap(gremlin.hands, canvas, gPoints.getHands());
		drawBitmap(gremlin.feet, canvas, gPoints.getFeet());

		// drawCircle(canvas, Color.MAGENTA, gPoints.getBody(), 25f);
		// drawCircle(canvas, Color.BLACK, gPoints.getHead(), 10f);
		// drawCircle(canvas, Color.BLUE, gPoints.getEyes(), 6f);
		// drawCircle(canvas, Color.CYAN, gPoints.getHands(), 6f);
		// drawCircle(canvas, Color.GREEN, gPoints.getFeet(), 6f);

	}

	private void drawBitmap(int resID, Canvas canvas, PointF point) {
		drawBitmap(BitmapFactory.decodeResource(getResources(), resID), canvas, point);
	}

	private void drawBitmap(Bitmap bm, Canvas canvas, PointF point) {
		float left = point.x - bm.getWidth() / 2f;
		float top = point.y - bm.getHeight() / 2f;
		canvas.drawBitmap(bm, left, top, null);
	}

	private void drawCircle(Canvas canvas, int color, PointF point, float radius) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(color);

		canvas.drawCircle(point.x, point.y, radius, paint);
	}

	public void setGremlin(Gremlin gremlin) {
		this.gremlin = gremlin;
		invalidate();
	}
}
