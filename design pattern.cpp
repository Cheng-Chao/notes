//  state pattern 

package com.xingoo.test.design.state;
class Context{
    private State state;
    public void setState(State state) {
        this.state = state;
    }
    public void operation(){
        state.operation();
    }
}
interface State{
    public void operation();
}
class ConcreteState1 implements State{
    public void operation(){
        System.out.println("state1 operation");
    }
}
class ConcreteState2 implements State{
    public void operation(){
        System.out.println("state2 operation");
    }
}
class ConcreteState3 implements State{
    public void operation(){
        System.out.println("state3 operation");
    }
}
public class Client {
    public static void main(String[] args) {
        Context ctx = new Context();
        State state1 = new ConcreteState1();
        State state2 = new ConcreteState2();
        State state3 = new ConcreteState3();
        
        ctx.setState(state1);
        ctx.operation();
        
        ctx.setState(state2);
        ctx.operation();
        
        ctx.setState(state3);
        ctx.operation();
    }
}
