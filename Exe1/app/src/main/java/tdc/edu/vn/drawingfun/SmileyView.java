package tdc.edu.vn.drawingfun;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SmileyView extends View {
    private Paint mCirclePaint, canvasPaint;
    private Paint mRectPaint;
    private Paint mEyeAndMouthPaint;

    private Bitmap canvasBitmap;

    private int paintColor = 0xFF660000;
    private float mCenterX;
    private float mCenterY;
    private float mRadius;
    private RectF mArcBounds = new RectF();
    Path path = new Path();
    Paint paint = new Paint();

    private Canvas drawCanvas;

    public SmileyView(Context context) {
        this(context, null);
    }

    public SmileyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmileyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    private void initPaints() {


        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(Color.RED);

//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(16 * getResources().getDisplayMetrics().density);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(w, h);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(mCenterX, mCenterY, mCenterY, mCirclePaint);

        // draw eyes
//        float eyeRadius = mRadius / 5f;
//        float eyeOffsetX = mRadius / 3f;
//        float eyeOffsetY = mRadius / 3f;
//        canvas.drawCircle(mCenterX - eyeOffsetX, mCenterY - eyeOffsetY, eyeRadius, mEyeAndMouthPaint);
//        canvas.drawCircle(mCenterX + eyeOffsetX, mCenterY - eyeOffsetY, eyeRadius, mEyeAndMouthPaint);
//        canvas.drawCircle(mCenterX + eyeOffsetX, mCenterY + eyeOffsetY, eyeRadius, mEyeAndMouthPaint);
//        canvas.drawCircle(mCenterX - eyeOffsetX, mCenterY + eyeOffsetY, eyeRadius, mEyeAndMouthPaint);
//        canvas.drawLine(eyeOffsetX, eyeOffsetY, eyeRadius, mRadius, paint);
        // draw mouth
//        float mouthInset = mRadius / 3f;
//        mArcBounds.set(mouthInset, mouthInset, mRadius * 2 - mouthInset, mRadius * 2 - mouthInset);
//        canvas.drawArc(mArcBounds, 45f, 90f, false, mEyeAndMouthPaint);

        float mid = getWidth() / 2;
        float min = Math.min(getWidth(), getHeight());
        float fat = min / 17;
        float half = min / 2;
        mid = mid - half;

        //paint.setStrokeWidth(fat);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        //canvas.drawCircle(mid + half, half, rad, paint);

        paint.setStyle(Paint.Style.FILL);
         //top left
        path.moveTo(mid + half * 0.5f, half * 0.84f);
        // top right
        path.lineTo(mid + half * 1.5f, half * 0.84f);
        // bottom left
        path.lineTo(mid + half * 0.68f, half * 1.45f);
        // top tip
        path.lineTo(mid + half * 1.0f, half * 0.5f);
        // bottom right
        path.lineTo(mid + half * 1.32f, half * 1.45f);
        // top left
        path.lineTo(mid + half * 0.5f, half * 0.84f);

        canvas.drawPath(path, paint);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCenterX = w / 2f;
        mCenterY = h / 2f;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                path.addCircle(eventX, eventY, 10, Path.Direction.CCW);
                break;
            case MotionEvent.ACTION_CANCEL: {
                path.addCircle(eventX, eventY, 10, Path.Direction.CCW);
                break;
            }
            default:
                return false;
        }
        invalidate();
        return true;
    }

    private void setupDrawing() {
        //Path
        path = new Path();
        //Paint
        paint = new Paint();
        paint.setColor(paintColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);

    }

    public void setColor(String newColor){
        //set color
        invalidate();
        paintColor = Color.parseColor(newColor);
        paint.setColor(paintColor);
    }

}


