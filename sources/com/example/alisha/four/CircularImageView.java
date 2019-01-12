package com.example.alisha.four;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class CircularImageView extends ImageView {
    private static final int SHADOW_COLOR = -7829368;
    private static final float SHADOW_DX = 0.0f;
    private static final float SHADOW_DY = 2.0f;
    private static final boolean SHADOW_ENABLED = true;
    private static final float SHADOW_RADIUS = 4.0f;
    private static final String TAG = CircularImageView.class.getSimpleName();
    private int borderWidth;
    private int canvasSize;
    private boolean hasBorder;
    private boolean hasSelector;
    private Bitmap image;
    private boolean isSelected;
    private Paint paint;
    private Paint paintBorder;
    private Paint paintSelectorBorder;
    private ColorFilter selectorFilter;
    private int selectorStrokeWidth;
    private BitmapShader shader;
    private int shadowColor;
    private float shadowDx;
    private float shadowDy;
    private boolean shadowEnabled;
    private float shadowRadius;

    public CircularImageView(Context context) {
        this(context, null, 0);
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public CircularImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        this.paint = new Paint();
        this.paint.setAntiAlias(SHADOW_ENABLED);
        this.paintBorder = new Paint();
        this.paintBorder.setAntiAlias(SHADOW_ENABLED);
        this.paintBorder.setStyle(Style.STROKE);
        this.paintSelectorBorder = new Paint();
        this.paintSelectorBorder.setAntiAlias(SHADOW_ENABLED);
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray attributes = context.obtainStyledAttributes(attrs, C0325R.styleable.CircularImageView, defStyle, 0);
        this.hasBorder = attributes.getBoolean(0, false);
        this.hasSelector = attributes.getBoolean(3, false);
        this.shadowEnabled = attributes.getBoolean(7, SHADOW_ENABLED);
        if (this.hasBorder) {
            setBorderWidth(attributes.getDimensionPixelOffset(2, (int) ((context.getResources().getDisplayMetrics().density * SHADOW_DY) + 3.0f)));
            setBorderColor(attributes.getColor(1, -1));
        }
        if (this.hasSelector) {
            int defaultSelectorSize = (int) ((context.getResources().getDisplayMetrics().density * SHADOW_DY) + 0.5f);
            setSelectorColor(attributes.getColor(4, 0));
            setSelectorStrokeWidth(attributes.getDimensionPixelOffset(6, defaultSelectorSize));
            setSelectorStrokeColor(attributes.getColor(5, -16776961));
        }
        if (this.shadowEnabled) {
            this.shadowRadius = attributes.getFloat(11, SHADOW_RADIUS);
            this.shadowDx = attributes.getFloat(9, 0.0f);
            this.shadowDy = attributes.getFloat(10, SHADOW_DY);
            this.shadowColor = attributes.getColor(8, SHADOW_COLOR);
            setShadowEnabled(SHADOW_ENABLED);
        }
        attributes.recycle();
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        if (this.paintBorder != null) {
            this.paintBorder.setStrokeWidth((float) borderWidth);
        }
        requestLayout();
        invalidate();
    }

    public void setBorderColor(int borderColor) {
        if (this.paintBorder != null) {
            this.paintBorder.setColor(borderColor);
        }
        invalidate();
    }

    public void setSelectorColor(int selectorColor) {
        this.selectorFilter = new PorterDuffColorFilter(selectorColor, Mode.SRC_ATOP);
        invalidate();
    }

    public void setSelectorStrokeWidth(int selectorStrokeWidth) {
        this.selectorStrokeWidth = selectorStrokeWidth;
        requestLayout();
        invalidate();
    }

    public void setSelectorStrokeColor(int selectorStrokeColor) {
        if (this.paintSelectorBorder != null) {
            this.paintSelectorBorder.setColor(selectorStrokeColor);
        }
        invalidate();
    }

    public void setShadowEnabled(boolean enabled) {
        this.shadowEnabled = enabled;
        updateShadow();
    }

    public void setShadow(float radius, float dx, float dy, int color) {
        this.shadowRadius = radius;
        this.shadowDx = dx;
        this.shadowDy = dy;
        this.shadowColor = color;
        updateShadow();
    }

    public void onDraw(Canvas canvas) {
        if (this.image != null && this.image.getHeight() != 0 && this.image.getWidth() != 0) {
            int oldCanvasSize = this.canvasSize;
            this.canvasSize = getWidth() < getHeight() ? getWidth() : getHeight();
            if (oldCanvasSize != this.canvasSize) {
                updateBitmapShader();
            }
            this.paint.setShader(this.shader);
            int outerWidth = 0;
            int center = this.canvasSize / 2;
            if (this.hasSelector && this.isSelected) {
                outerWidth = this.selectorStrokeWidth;
                center = (this.canvasSize - (outerWidth * 2)) / 2;
                this.paint.setColorFilter(this.selectorFilter);
                canvas.drawCircle((float) (center + outerWidth), (float) (center + outerWidth), ((float) (((this.canvasSize - (outerWidth * 2)) / 2) + outerWidth)) - SHADOW_RADIUS, this.paintSelectorBorder);
            } else if (this.hasBorder) {
                outerWidth = this.borderWidth;
                center = (this.canvasSize - (outerWidth * 2)) / 2;
                this.paint.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((outerWidth / 2) + 0), (float) ((outerWidth / 2) + 0), (float) (this.canvasSize - (outerWidth / 2)), (float) (this.canvasSize - (outerWidth / 2))), 360.0f, 360.0f, false, this.paintBorder);
            } else {
                this.paint.setColorFilter(null);
            }
            canvas.drawCircle((float) (center + outerWidth), (float) (center + outerWidth), (float) ((this.canvasSize - (outerWidth * 2)) / 2), this.paint);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (isClickable()) {
            switch (event.getAction()) {
                case 0:
                    this.isSelected = SHADOW_ENABLED;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.isSelected = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(event);
        }
        this.isSelected = false;
        return super.onTouchEvent(event);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.image = drawableToBitmap(getDrawable());
        if (this.canvasSize > 0) {
            updateBitmapShader();
        }
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.image = drawableToBitmap(getDrawable());
        if (this.canvasSize > 0) {
            updateBitmapShader();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.image = drawableToBitmap(getDrawable());
        if (this.canvasSize > 0) {
            updateBitmapShader();
        }
    }

    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        this.image = bm;
        if (this.canvasSize > 0) {
            updateBitmapShader();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            return specSize;
        }
        if (specMode == Integer.MIN_VALUE) {
            return specSize;
        }
        return this.canvasSize;
    }

    private int measureHeight(int measureSpecHeight) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpecHeight);
        int specSize = MeasureSpec.getSize(measureSpecHeight);
        if (specMode == 1073741824) {
            result = specSize;
        } else if (specMode == Integer.MIN_VALUE) {
            result = specSize;
        } else {
            result = this.canvasSize;
        }
        return result + 2;
    }

    private void updateShadow() {
        float radius = this.shadowEnabled ? this.shadowRadius : 0.0f;
        this.paintBorder.setShadowLayer(radius, this.shadowDx, this.shadowDy, this.shadowColor);
        this.paintSelectorBorder.setShadowLayer(radius, this.shadowDx, this.shadowDy, this.shadowColor);
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            Log.i(TAG, "Bitmap drawable!");
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            Log.e(TAG, "Encountered OutOfMemoryError while generating bitmap!");
            return null;
        }
    }

    public void setIconModeEnabled(boolean e) {
    }

    public void updateBitmapShader() {
        if (this.image != null) {
            this.shader = new BitmapShader(this.image, TileMode.CLAMP, TileMode.CLAMP);
            if (this.canvasSize != this.image.getWidth() || this.canvasSize != this.image.getHeight()) {
                Matrix matrix = new Matrix();
                float scale = ((float) this.canvasSize) / ((float) this.image.getWidth());
                matrix.setScale(scale, scale);
                this.shader.setLocalMatrix(matrix);
            }
        }
    }

    public boolean isSelected() {
        return this.isSelected;
    }
}
