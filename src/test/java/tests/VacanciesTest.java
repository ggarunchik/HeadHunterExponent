package tests;

import adapters.hh.VacancyAdapter;
import models.hh.VacanciesList;
import org.testng.annotations.Test;

import static resources.constants.AreaConstants.BELARUS_AREA;
import static resources.constants.CurrConstants.USD_ID;
import static resources.constants.ExperienceConstants.*;
import static resources.constants.VacancyNameConstants.QA_AUTO;
import static resources.constants.VacancyNameConstants.QA_MANUAL;

public class VacanciesTest {

    @Test
    public void getVacancies() {
        VacanciesList vacanciesList = new VacancyAdapter().get(QA_AUTO, BELARUS_AREA, JUNIOR_EXP);
        System.out.println("Cредняя ЗП AUTO: " + vacanciesList.getItems().get(0).getSalary().getAverageInCurrency(vacanciesList, USD_ID));
        System.out.println(vacanciesList);
        VacanciesList vacanciesList2 = new VacancyAdapter().get(QA_MANUAL, BELARUS_AREA, JUNIOR_EXP);
        System.out.println("Cредняя ЗП MANUAL: " + vacanciesList2.getItems().get(0).getSalary().getAverageInCurrency(vacanciesList2, USD_ID));
        System.out.println(vacanciesList2);

    }
}
