package inhLabP04StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;

    //конструктор
    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);

    }
    public String pop(){
        if (this.data.isEmpty()){
            throw new IllegalArgumentException();
        }

        int index = this.size()-1;

      return   this.data.remove(index);
    }
    public String peek(){
        if (this.data.isEmpty()){
            throw new IllegalArgumentException();
        }
        int index = this.size()-1;
return this.data.get(index);
    }

    public int size(){
        if (this.data.isEmpty()){
            throw new IllegalArgumentException();
        }
return this.data.size();
    }
    public boolean isEmpty(){
        return  this.size()==0;
    }
}
