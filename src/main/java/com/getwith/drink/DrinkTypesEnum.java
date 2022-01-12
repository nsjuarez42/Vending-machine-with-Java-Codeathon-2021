package com.getwith.drink;

public enum DrinkTypesEnum implements InterfaceDrink {

    CHOCOLATE("CHOCOLATE",0.6,2),
    TEA("TEA",0.4,2),
    COFFEE("COFFEE",0.5,2);

    private final String drink;
    private final Double price;
    private final Integer sugars;

    private DrinkTypesEnum(String drink,double price,Integer sugars){
     this.drink = drink;
     this.price = price;
     this.sugars = sugars;
    }

    public String buyDrink(Float money){
        String template = "The %s costs %s.";
        return money < price ? String.format(template,drink.toLowerCase(),price) : "";
    }

    public String addSugars(Integer sugars,Boolean isExtraHot){
        String message;
        if (sugars >= 0 && sugars <= 2) {
          message = "You have ordered a " + this.drink.toLowerCase();

          if (isExtraHot) {
            message += " extra hot";
          }

          message += " with " + sugars;
  
          if (sugars > 0) {
            message += " sugars (stick included)";
          } else {
            message += " sugar";
          }

        } else {
          message = "The number of sugars should be between 0 and 2.";
        }
        return message;
    }

}
