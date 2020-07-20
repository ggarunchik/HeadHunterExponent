package adapters.currancyconverter;

import adapters.base.MainAdapter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.converter.Currency;

import static io.restassured.RestAssured.given;

public class ConverterAdapter extends MainAdapter {

    public Currency getCurrRate(int currID) {
        Response response = given()
            //    .log().uri()
                .when()
                .get("https://www.nbrb.by/api/exrates/rates/{currID}", currID)
                .then()
              //  .log().body()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();
        return gson.fromJson(response.asString().trim(), Currency.class);
    }
}
