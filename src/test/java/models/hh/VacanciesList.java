package models.hh;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class VacanciesList {
    @Expose
    List<Vacancy> items;
    @Expose
    int found;


    public VacanciesList(List<Vacancy> items) {
        this.items = items;
    }

    public VacanciesList() {
    }
}
