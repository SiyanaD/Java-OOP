package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool {

    private int power;

    public ToolImpl(int power) {
        setPower(power);
    }



    //o	If the initial power is below 0, throw an IllegalArgumentException with a message:
    // "Cannot create a Tool with negative power.".
    public void setPower(int power) {
        if (power<0){
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
    @Override
    public int getPower() {

        return power;
    }

    @Override
    public void decreasesPower() {
        //The decreasesPower() method decreases the tool's power by 5.
        int currentPower = getPower();
        currentPower-=5;
        //A tool's power should not drop below 0. (If the power becomes less than 0, set it to 0).
        if (currentPower<0){
            currentPower=0;
        }
        this.setPower(currentPower);

    }

    @Override
    public boolean isUnfit() {
        //This method returns:
        //•	true – when power becomes equal to 0
        //•	false - otherwise.

        return this.getPower()==0;
    }


}
