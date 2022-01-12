package com.getwith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(DataProviderRunner.class)
public class MakeDrinkCommandTest {

    @Mock
    private Output output;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

        /*tests

    how to make message string price and drinkType constant

    use drink types enum here????

    */

    @Test
    @UseDataProvider("invalidDrink")
    public void testInvalidDrink(Input input,String expected){
        new MakeDrinkCommand().execute(input,output);
        verify(output,times(1)).run(expected);
    }

    @Test
    @UseDataProvider("invalidDrinkPrice")
    public void testInvalidDrinkPrice(Input input,String expected){
        new MakeDrinkCommand().execute(input,output);
        verify(output,times(1)).run(expected);
    }

    @Test
    @UseDataProvider("drinksWithoutSugar")
    public void testDrinksWithoutSugar(Input input,String expected){
        new MakeDrinkCommand().execute(input,output);
        verify(output,times(1)).run(expected);
    }

    @Test
    @UseDataProvider("drinksWithSugar")
    public void testDrinksWithSugar(Input input,String expected){
        new MakeDrinkCommand().execute(input,output);
        verify(output,times(1)).run(expected);
    }

    @Test
    @UseDataProvider("drinksExtraHotWithoutSugar")
    public void testDrinksExtraHotWithoutSugar(Input input,String expected){
        new MakeDrinkCommand().execute(input,output);
        verify(output,times(1)).run(expected);
    }

    @Test
    @UseDataProvider("drinksExtraHotWithSugar")
    public void testDrinksExtraHotWithSugar(Input input,String expected){
        new MakeDrinkCommand().execute(input,output);
        verify(output,times(1)).run(expected);
    }
    



    @DataProvider
    public static Object[][] invalidDrink(){
        return new Object[][]{
            {new InputArguments("foo", (float) 0.1, 1, false), "The drink type should be tea, coffee or chocolate."},
        };
    }

    @DataProvider
    public static Object[][] invalidDrinkPrice(){
        float invalidPrice = 0;
        boolean extraHot = false;
        int sugar = 0;

        return new Object[][]{
         {new InputArguments("coffee",invalidPrice,sugar,extraHot),"The coffee costs 0.5."},
         {new InputArguments("chocolate",invalidPrice,sugar,extraHot),"The chocolate costs 0.6."},
         {new InputArguments("tea",invalidPrice,sugar,extraHot),"The tea costs 0.4."},
        };
    }

    @DataProvider
    public static Object[][] drinksWithoutSugar(){
     int sugar = 0;
     boolean extraHot = false;
     
     return new Object[][]{
       {new InputArguments("coffee",(float) 0.5,sugar,extraHot),"You have ordered a coffee with 0 sugar"},
       {new InputArguments("chocolate",(float) 0.6,sugar,extraHot),"You have ordered a chocolate with 0 sugar"},
       {new InputArguments("tea",(float) 0.4,sugar,extraHot),"You have ordered a tea with 0 sugar"},
     };

    }

    @DataProvider 
    public static Object [][] drinksWithSugar(){
        int sugar= 1;
        boolean extraHot = false;

        return new Object[][]{
        {new InputArguments("coffee",(float) 0.5,sugar,extraHot),"You have ordered a coffee with 1 sugars (stick included)"},
        {new InputArguments("chocolate",(float) 0.6,sugar,extraHot),"You have ordered a chocolate with 1 sugars (stick included)"},
        {new InputArguments("tea",(float)0.4,sugar,extraHot),"You have ordered a tea with 1 sugars (stick included)"},
        };
    }

    @DataProvider 
    public static Object[][] drinksExtraHotWithoutSugar(){
        int sugar = 0;
        boolean extraHot = true;

        return new Object[][]{
            {new InputArguments("coffee",(float) 0.5,sugar,extraHot),"You have ordered a coffee extra hot with 0 sugar"},
            {new InputArguments("chocolate",(float) 0.6,sugar,extraHot),"You have ordered a chocolate extra hot with 0 sugar"},
            {new InputArguments("tea",(float)0.4,sugar,extraHot),"You have ordered a tea extra hot with 0 sugar"},
        };
    }

    @DataProvider
    public static Object[][] drinksExtraHotWithSugar(){
        int sugar =1;
        boolean extraHot = true;

        return new Object[][]{
            {new InputArguments("coffee",(float)0.5,sugar,extraHot),"You have ordered a coffee extra hot with 1 sugars (stick included)"},
            {new InputArguments("chocolate",(float)0.6,sugar,extraHot),"You have ordered a chocolate extra hot with 1 sugars (stick included)"},
            {new InputArguments("tea",(float)0.4,sugar,extraHot),"You have ordered a tea extra hot with 1 sugars (stick included)"},
        };
    }

}
