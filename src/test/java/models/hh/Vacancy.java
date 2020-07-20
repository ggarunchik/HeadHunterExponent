package models.hh;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Vacancy {
    @Expose
    String name;
    @SerializedName("has_test")
    @Expose
    boolean hasTest;
    @Expose
    Area area;
    @Expose
    Salary salary;
}
