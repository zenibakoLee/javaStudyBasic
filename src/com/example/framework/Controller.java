package com.example.framework;

/**
 * 초기화,마무리는 늘 같은 코드
 * 실행만 다른 코드일 경우?
 */
public abstract class Controller {
    //protected는 같은 pacakge거나 상속받았을 경우에만 접근/호출 가능
    protected final void init(){
        System.out.println("초기화하는 코드");
    }
    protected final void close(){
        System.out.println("마무리하는 코드");
    }
    protected abstract void run(); //매번 다른 코드

    // 내가 갖고있는 메소드를 호출한다.
    // 어떤 순서를 가지고 있다. 이런 메소드를 템플릿 메소드라고 한다.
    public void execute(){
        this.init(); //초기화
        this.run();//실행
        this.close();//마무리
    }
}
