package models.hh;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class VacanciesList {
    @Expose
    List<Vacancy> items;


    public VacanciesList(List<Vacancy> items) {
        this.items = items;
    }

    public VacanciesList() {
    }
}
