package com.kodilla.stream.world;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class WorldTestSuite {
    Country poland = new Country(new BigDecimal("1"));
    Country germany = new Country(new BigDecimal("1"));
    Country france = new Country(new BigDecimal("1"));
    List<Country> europeanCountries = Arrays.asList(poland, germany, france);
    Country brazil = new Country(new BigDecimal("1"));
    Country argentina = new Country(new BigDecimal("1"));
    Country bolivia = new Country(new BigDecimal("1"));
    List<Country> southAmericanCountries = Arrays.asList(brazil, argentina, bolivia);
    Country japan = new Country(new BigDecimal("1"));
    Country china = new Country(new BigDecimal("1"));
    Country vietnam = new Country(new BigDecimal("1"));
    List<Country> asianCountries = Arrays.asList(japan, china, vietnam);
    Continent europe = new Continent(europeanCountries);
    Continent southAmerica = new Continent(southAmericanCountries);
    Continent asia = new Continent(asianCountries);
    List<Continent> continentList = Arrays.asList(europe, southAmerica, asia);
    World world = new World(continentList);

    @Test
    public void testGetPeopleQuantity(){
        //When
        BigDecimal expected = new BigDecimal("9");
        BigDecimal real = world.getPeopleQuantity();
        //Then
        Assert.assertEquals(expected, real);
    }







}
