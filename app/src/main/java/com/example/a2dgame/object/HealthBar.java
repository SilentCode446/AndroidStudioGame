package com.example.a2dgame.object;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.a2dgame.R;

public class HealthBar {
    private final Player player;
    private int width, height, margin;
    private Paint borderPaint, healthBarPaint;

    public HealthBar(Context context, Player player) {
        this.player = player;
        this.width = 130;
        this.height = 30;
        this.margin = 5;

        this.borderPaint = new Paint();
        int borderColor = ContextCompat.getColor(context, R.color.healthBarBorder);
        this.borderPaint.setColor(borderColor);

        this.healthBarPaint = new Paint();
        int healthBarColor = ContextCompat.getColor(context, R.color.healthBar);
        this.healthBarPaint.setColor(healthBarColor);
    }

    public void draw(Canvas canvas) {
        float x = (float) player.getPositionX();
        float y = (float) player.getPositionY();
        float distanceToPlayer = 85;
        float healthPointPorcentage = player.getHealthPoints() / player.MAX_HEALTH_POINTS;

        // Border positions
        float borderLeft, borderTop, borderRight, borderBottom;
        borderLeft = x - width / 2;
        borderRight = x + width / 2;
        borderTop = y - distanceToPlayer;
        borderBottom = borderTop + height;

        // Draw border
        canvas.drawRect(borderLeft, borderTop, borderRight, borderBottom, borderPaint);

        // Health bar positions
        float healthBarLeft, healthBarTop, healthBarRight, healthBarBottom;
        healthBarLeft = borderLeft + margin;
        healthBarRight = healthBarLeft + (width - margin * 2) * healthPointPorcentage;
        healthBarTop = borderTop + margin;
        healthBarBottom = borderTop + height - margin;

        // Draw health
        canvas.drawRect(healthBarLeft, healthBarTop, healthBarRight, healthBarBottom, healthBarPaint);
    }
}
