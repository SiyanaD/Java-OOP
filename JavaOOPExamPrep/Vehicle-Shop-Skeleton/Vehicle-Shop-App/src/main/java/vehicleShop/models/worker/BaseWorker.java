package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

//BaseWorker is a base class or any type of Worker and it should not be able be instantiated-abstract class
public abstract class BaseWorker implements Worker {
    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
      this.setName(name);
       this.setStrength(strength);
        //•	tools – Collection<Tool>
        //o	A collection of a worker's tools.
        this.tools=new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {

        //o	If the name is null or whitespace, throw an IllegalArgumentException with a message:
        //"Worker name cannot be null or empty."
        if (name==null || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }



    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        //o	If the strength is below 0, throw an IllegalArgumentException with a message:
        // "Cannot create a Worker with negative strength."
        if (strength<0){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }
    public Collection<Tool> getTools() {
        return tools;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }
    //BaseWorker Alt+Insert и избираш implement'sMethod и се имплементират методите->

    @Override
    public void working() {
        //The working() method decreases workers' strength by 10.
        int currentStrength = getStrength();//текуща сила на работника
        currentStrength-=10;
        //•	A worker's strength should not drop below 0 (If the strength becomes less than 0, set it to 0).
        if (currentStrength<0){
            currentStrength=0;
        }
        //сетваме намалената сила
        setStrength(currentStrength);


    }

    @Override
    public void addTool(Tool tool) {
        //This method adds a tool to the worker's collection of tools.
        this.getTools().add(tool);

    }

    @Override
    public boolean canWork() {
        //This method returns:
        //•	true - if the current strength of the worker is greater than 0
        //•	false - otherwise

        return this.getStrength()>0;
    }

    @Override
    public String toString() {
       long leftTools = this.tools.stream().filter(tool -> tool.getPower()>0).count();//броиме останалите инструменти който не са счупени
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + ", Strength: " + strength).append(System.lineSeparator());
        sb.append("Tools: " + leftTools + " fit left").append(System.lineSeparator());
        return sb.toString().trim();//trim() - чисти излишни интервали
    }
}
