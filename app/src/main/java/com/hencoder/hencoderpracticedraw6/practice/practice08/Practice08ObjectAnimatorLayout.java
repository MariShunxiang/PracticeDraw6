package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import android.widget.Toast;
import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
  Practice08ObjectAnimatorView view;
  Button animateBt;

  public Practice08ObjectAnimatorLayout(Context context) {
    super(context);
  }

  public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    view = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
    animateBt = (Button) findViewById(R.id.animateBt);

    animateBt.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
        // 1. 用 ObjectAnimator 创建 Animator 对象
        // 2. 用 start() 执行动画
        // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！

        ObjectAnimator progress = ObjectAnimator.ofFloat(view, "progress", 0, 80);

        progress.setDuration(1000).setInterpolator(new FastOutSlowInInterpolator());
        progress.start();
      }
    });
  }

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

  @Override protected void onDraw(Canvas canvas) {

    paint.setColor(Color.WHITE);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(Utils.dpToPixel(1));
    paint.setTextSize(40);
    paint.setTextAlign(Paint.Align.CENTER);

    int centerX = getWidth() / 2;
    int centerY = getHeight() / 2;

    canvas.drawText("123", centerX, -(paint.ascent() + paint.descent()), paint);

    canvas.drawLine(0, centerY, getWidth(), centerY, paint);
    canvas.drawLine(centerX, 0, centerX, getHeight(), paint);

    super.onDraw(canvas);
  }
}
