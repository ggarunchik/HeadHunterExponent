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
        VacanciesList allVacancies = new VacancyAdapter().getAll(QA_MANUAL, BELARUS_AREA, JUNIOR_EXP);
        String totalFoundFirstVacancy = String.valueOf(allVacancies.getFound());
        VacanciesList vacanciesWithSalaryOnly = new VacancyAdapter().get(QA_MANUAL, BELARUS_AREA, JUNIOR_EXP);
        String firstVacancy = String.valueOf(vacanciesWithSalaryOnly.getItems().get(0).getSalary().getAverageInCurrency(vacanciesWithSalaryOnly, USD_ID));

        Thread.sleep(8000);

        VacanciesList allVacanciesSecond = new VacancyAdapter().getAll(QA_AUTO, BELARUS_AREA, JUNIOR_EXP);
        String totalFoundSecondVacancy = String.valueOf(allVacanciesSecond.getFound());
        VacanciesList vacanciesWithSalaryOnlySecond = new VacancyAdapter().get(QA_AUTO, BELARUS_AREA, JUNIOR_EXP);
        String secondVacancy = String.valueOf(vacanciesWithSalaryOnlySecond.getItems().get(0).getSalary().getAverageInCurrency(vacanciesWithSalaryOnlySecond, USD_ID));

        writeJson("JUN QA MANUAL", firstVacancy,"JUN QA AUTO ", secondVacancy, totalFoundFirstVacancy, totalFoundSecondVacancy);
    }
}
