package ru.jollydroid.cusomviewonmeasuredemo1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by tse on 31/03/16.
 */
public class MyView extends FrameLayout {

    private Item item;
    private TextView text;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setItem(Item item) {
        this.item = item;

        invalidate();
        text.invalidate();

        text.setText("" + item.a + "x" + item.b);
        text.setWidth(30);
        text.setHeight(30);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        text = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        final int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int measuredWidth = 1;
        switch (widthSpecMode) {
            case MeasureSpec.UNSPECIFIED:
                // в нашей задаче сюда попасть не должны
                // вьюха сама решает, какой ей быть
                measuredWidth = item.a;
                break;

            case MeasureSpec.AT_MOST:
                // в нашей задаче сюда попасть не должны
                // родитель говорит, что мы можем быть не шире, чем.
                measuredWidth = Math.min(item.a, widthSpecSize);
                break;

            case MeasureSpec.EXACTLY:
                // родитель точно указал ширину
                measuredWidth = widthSpecSize;
                break;
        }

        // ожидаем, что родитель спросит ширину. поэтому считаем заранее
        int measuredHeight = measuredWidth * item.b / item.a;
        switch (heightSpecMode) {
            case MeasureSpec.UNSPECIFIED:
                // вьюха сама решает, какой ей быть
                // высота уже посчитана
                break;

            case MeasureSpec.AT_MOST:
                // в нашей задаче сюда попасть не должны
                // родитель говорит, что мы можем быть не выше, чем.
                measuredHeight = Math.min(measuredHeight, heightSpecSize);
                break;

            case MeasureSpec.EXACTLY:
                // в нашей задаче сюда попасть не должны
                // родитель точно указал высоту
                measuredHeight = heightSpecSize;
                break;
        }

        super.onMeasure(MeasureSpec.makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY));

//        setMeasuredDimension(measuredWidth, measuredHeight);

    }
}
