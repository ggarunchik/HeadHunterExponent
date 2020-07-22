package tests;

import adapters.hh.VacancyAdapter;
import models.hh.VacanciesList;
import org.testng.annotations.Test;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static resources.constants.AreaConstants.*;
import static resources.constants.CurrConstants.*;
import static resources.constants.ExperienceConstants.*;
import static resources.constants.VacancyNameConstants.*;

public class VacanciesTest {

    @Test
    public void getVacancies() throws InterruptedException {
        VacanciesList vacanciesList = new VacancyAdapter().get(QA_AUTO, BELARUS_AREA, JUNIOR_EXP);
        System.out.println("Cредняя ЗП AUTO c опытом " + JUNIOR_EXP + ":" + vacanciesList.getItems().get(0).getSalary().getAverageInCurrency(vacanciesList, USD_ID));
        System.out.println(vacanciesList);
        Thread.sleep(8000);
        VacanciesList vacanciesList2 = new VacancyAdapter().get(QA_MANUAL, BELARUS_AREA, JUNIOR_EXP);
        System.out.println("Cредняя ЗП MANUAL c опытом" + JUNIOR_EXP + ":" + vacanciesList2.getItems().get(0).getSalary().getAverageInCurrency(vacanciesList2, USD_ID));
        System.out.println(vacanciesList2);
    }
}
