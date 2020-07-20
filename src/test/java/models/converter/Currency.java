package models.converter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class Currency {
    @SerializedName("Cur_ID")
    @Expose
    int curID;
    @SerializedName("Cur_OfficialRate")
    @Expose
    double curOfficialRate;


}
