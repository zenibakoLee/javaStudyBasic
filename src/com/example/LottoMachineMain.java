package com.example;

public class LottoMachineMain {
    public static void main(String[] args){
        Ball[] balls = new Ball[LottoMachine.MAX_BALL_COUNT];
        for(int i=0;i<LottoMachine.MAX_BALL_COUNT;i++){
            balls[i] = new Ball(i+1);
        }
        LottoMachine lottoMachine = new LottoMachineImpl();
        lottoMachine.setBalls(balls);
        lottoMachine.mix();
        Ball[] result = lottoMachine.getBalls();

        for(Ball ball:result){
            System.out.println(ball.getNumber());
        }
    }
}
