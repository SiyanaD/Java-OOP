package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
     CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository=delicacyRepository;
        this.cocktailRepository=cocktailRepository;
        this.boothRepository=boothRepository;
        totalIncome=0;

    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        //Creates a delicacy with the correct type. If the delicacy is created successfully, returns:
        //"Added delicacy {delicacy name} - {delicacy type} to the pastry shop!"
        //If a delicacy with the given name already exists in the delicacy repository,
        // throw an IllegalArgumentException with the message "{type} {name} is already in the pastry shop!"
        Delicacy delicacy = this.delicacyRepository.getByName(name);// създаваме delicacy
        //Gingerbread - type
        //Stolen -  type
        if (delicacy==null){//проверяваме дали съществува и ако не добавяме
        if (type.equals("Gingerbread")){
            delicacy=new Gingerbread(name,price);
        }
        else if (type.equals("Stolen")) {
            delicacy=new Stolen(name,price);
        }
        }
        else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,delicacy.getClass().getSimpleName(),delicacy.getName()));
        }
        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED,name,type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        //Creates a cocktail with the correct type. If the cocktail is created successful, returns:
        //"Added cocktail {cocktailName} - {cocktailBrand} to the pastry shop!”
        //If a cocktail with the given name already exists in the cocktail repository,
        // throw an IllegalArgumentException with the message "{type} {name} is already in the pastry shop!"
        Cocktail cocktail = this.cocktailRepository.getByName(name);// създаваме cocktail
        if (cocktail==null){//проверяваме дали съществува и ако не добавяме
            //types
            //MulledWine
            //Hibernation
            if (type.equals("MulledWine")){
                cocktail=new MulledWine(name,size,brand);
            }
            else if (type.equals("Hibernation")) {
                cocktail=new Hibernation(name,size,brand);
            }
        }
        else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,cocktail.getClass().getSimpleName(),cocktail.getName()));
        }
        cocktailRepository.add(cocktail);

        return String.format(OutputMessages.COCKTAIL_ADDED,name,brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
      //Creates a booth with the correct type and returns:
        //"Added booth number {boothNumber} in the pastry shop!"
        //If a booth with the given name already exists in the
        // booth repository, throw an IllegalArgumentException with
        // the message "Booth {boothNumber} is already added to the pastry shop!"
        Booth booth = this.boothRepository.getByNumber(boothNumber);
        if (booth==null){//проверяваме дали съществува и ако не добавяме
            //type
            //OpenBooth
            //PrivateBooth
            if (type.equals("OpenBooth")){
                booth=new OpenBooth(boothNumber,capacity);
            } else if (type.equals("PrivateBooth")) {
                booth=new PrivateBooth(boothNumber,capacity);
            }
        }
        else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST,booth.getBoothNumber()));
        }
        this.boothRepository.add(booth);

        return String.format(OutputMessages.BOOTH_ADDED,boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        //Finds a booth that is not reserved, and its capacity is
        // enough for the number of people provided. If there is no such booth returns:
        //"No available booth for {numberOfPeople} people!"
        //In the other case reserves the booth and return:
        //"Booth {boothNumber} has been reserved for {numberOfPeople} people!"
        for (Booth booth : this.boothRepository.getAll() ) {
            if (!booth.isReserved() && booth.getCapacity()>=numberOfPeople){
                booth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED,booth.getBoothNumber(),numberOfPeople);
            }
            
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE,numberOfPeople) ;
    }

    @Override
    public String leaveBooth(int boothNumber) {
       //Finds the booth with the same booth number. Gets the bill for that booth,
        // clears it and adds the sum to the total store income.
        // The bill is not only the orders, but the reservation for the number of people as well. Finally returns:
        //"Booth: {boothNumber}"
        //"Bill: {booth bill:f2}"
       Booth booth = this.boothRepository.getByNumber(boothNumber);
       double bill = booth.getBill();
       this.totalIncome+=bill;
       booth.clear();

        return String.format(OutputMessages.BILL,boothNumber,bill);
    }

    @Override
    public String getIncome() {
        //Returns the total income for the pastry shop for all completed bills.
        //"Income: {income:f2}lv"

        return String.format(OutputMessages.TOTAL_INCOME,this.totalIncome);
    }
}
