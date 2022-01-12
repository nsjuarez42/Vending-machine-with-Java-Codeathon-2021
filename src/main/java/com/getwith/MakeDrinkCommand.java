package com.getwith;

import com.getwith.drink.DrinkTypesEnum;
import java.util.Arrays;

public class MakeDrinkCommand implements Command {

  private boolean isADrinkType(String drink){
    for(DrinkTypesEnum d : DrinkTypesEnum.values()){
      if(d.name().equals(drink.toUpperCase())){
        return true;
      }
    }
    return false;
   }
  
  @Override
  public void execute(Input input, Output out) {

    String drinkType = input.getParameter("drinkType");
    Integer sugarsNo = input.getParameter("sugar");
    Boolean isExtraHot = input.getParameter("extraHot");
    Float money = input.getParameter("money");

    boolean isValid = isADrinkType(drinkType);
 
    if (isValid) {
      
      DrinkTypesEnum drink = DrinkTypesEnum.valueOf(drinkType.toUpperCase());
      String buy = drink.buyDrink(money);
      if(!buy.equals("")){
       out.run(buy);
      }

      out.run(drink.addSugars(sugarsNo,isExtraHot));

    } else {
      out.run("The drink type should be tea, coffee or chocolate.");
    }

  }
}
