package tests;

import adapters.hh.VacancyAdapter;
import models.hh.VacanciesList;
import org.testng.annotations.Test;

import static resources.constants.AreaConstants.*;
import static resources.constants.CurrConstants.*;
import static resources.constants.ExperienceConstants.*;
import static resources.constants.VacancyNameConstants.*;
import static utils.jsonWorker.writeJson;

public class VacanciesTest {

    @Test
    public void getVacancies() throws InterruptedException {
        VacanciesList vacanciesList2 = new VacancyAdapter().get(QA_MANUAL, BELARUS_AREA, JUNIOR_EXP);
        String firstVacancy = String.valueOf(vacanciesList2.getItems().get(0).getSalary().getAverageInCurrency(vacanciesList2, USD_ID));

        Thread.sleep(8000);

        VacanciesList vacanciesList = new VacancyAdapter().get(QA_AUTO, BELARUS_AREA, JUNIOR_EXP);
        String secondVacancy = String.valueOf(vacanciesList.getItems().get(0).getSalary().getAverageInCurrency(vacanciesList, USD_ID));

        writeJson("JUN QA MANUAL SALARY", firstVacancy,"JUN QA AUTO SALARY", secondVacancy);
    }
}
