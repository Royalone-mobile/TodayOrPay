package com.pay.todayorpay.design;

/**
 * Created by royalone on 2017-01-06.
 */

public interface DrawableClickListener {

    enum DrawablePosition { TOP, BOTTOM, LEFT, RIGHT }

    void onClick(DrawablePosition target);
}
