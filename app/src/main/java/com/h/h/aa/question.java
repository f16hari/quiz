package com.h.h.aa;

/**
 * Created by HARI JEYACHANDRAN on 12/4/2017.
 */

public class question {
    private int qt;
    private boolean qa;
    public question(int x,boolean y)
    {
        qt=x;
        qa=y;

    }
    public int getTextResId() {
        return qt;
    }
    public boolean isAnswerTrue() {
        return qa;
    }

}

