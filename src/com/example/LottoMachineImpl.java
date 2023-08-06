package com.example;

public class LottoMachineImpl implements  LottoMachine{
    private Ball[] balls;
    @Override
    public void setBalls(Ball[] balls) {
        this.balls = balls;
    }

    @Override
    public void mix() {
        for(int i =0;i<10000;i++){
           int x1 = (int)(Math.random()*LottoMachine.MAX_BALL_COUNT);
           int x2 = (int)(Math.random()*LottoMachine.MAX_BALL_COUNT);
           while(x1==x2){
               x2 = (int)(Math.random()*LottoMachine.MAX_BALL_COUNT);
           }
           Ball tmp = balls[x1];
           balls[x1] = balls[x2];
           balls[x2] = tmp;
        }
    }

    @Override
    public Ball[] getBalls() {
        Ball[] result = new Ball[LottoMachine.RETURN_BALL_COUNT];
        for(int i=0;i<LottoMachine.RETURN_BALL_COUNT;i++){
            result[i] = balls[i];
        }
        return result;
    }
}
