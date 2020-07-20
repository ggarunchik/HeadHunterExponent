package models.hh;

import adapters.currancyconverter.ConverterAdapter;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Salary {
    @Expose
    int from;
    @Expose
    int to;
    @Expose
    String currency;

    int averageSalary;

    public int getAverageInCurrency(VacanciesList vacanciesList, int currID) {
        averageSalary = 0;
        double currRate = new ConverterAdapter().getCurrRate(currID).getCurOfficialRate();

        if (!vacanciesList.getItems().isEmpty()) {
            for (Vacancy vacancy : vacanciesList.getItems()) {
                int salaryFrom = vacancy.getSalary().getFrom();
                int salaryTo = vacancy.getSalary().getTo();
                String currencyName = vacancy.getSalary().getCurrency();

                if (salaryTo == 0) {
                    if (currencyName.equals("USD")) {
                        averageSalary += salaryFrom;
                    } else if (currencyName.equals("BYR")) {
                        salaryFrom = (int) (salaryFrom / currRate);
                        averageSalary += salaryFrom;
                    }
                } else {
                    int averageVacancySalary = (salaryFrom + salaryTo) / 2;
                    if (currencyName.equals("USD")) {
                        averageSalary += averageVacancySalary;
                    } else if (currencyName.equals("BYR")) {
                        averageVacancySalary = (int) (averageVacancySalary / currRate);
                        averageSalary += averageVacancySalary;
                    }
                }
            }
            return averageSalary / vacanciesList.getItems().size();
        }
        return averageSalary;
    }
}
