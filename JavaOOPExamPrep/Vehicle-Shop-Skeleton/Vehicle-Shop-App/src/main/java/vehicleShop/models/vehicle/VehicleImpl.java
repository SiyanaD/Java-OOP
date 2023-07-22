package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle {
    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
      this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    @Override
    public boolean reached() {
        //The reached() method returns true if the strengthRequired reaches 0.
        return this.getStrengthRequired()==0;
    }

    @Override
    public void making() {
        //The making() decreases the required strength of the vehicle by 5 units.
        int currentStrength=getStrengthRequired();
        currentStrength-=5;
        //•	A vehicle's required strength should not drop below 0.
        //o	If the strength becomes less than 0, set it to 0.
        if (currentStrength<0){
            currentStrength=0;
        }
        this.setStrengthRequired(currentStrength);

    }

    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired<0){
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }


}
