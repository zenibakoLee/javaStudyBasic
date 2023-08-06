package com.example;
/*
1. 1~45까지의 Ball을 로또 기계에 넣는다.
2. 로또 기계에 있는 Ball을 섞는다.
3. 섞인 Ball중에서 6개를 꺼낸다.
 */
public interface LottoMachine {
    int MAX_BALL_COUNT = 45;
    int RETURN_BALL_COUNT = 5;
    public void setBalls(Ball[] balls);
    public void mix();
    public Ball[] getBalls();
}
