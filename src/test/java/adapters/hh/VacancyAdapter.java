package adapters.hh;

import adapters.base.MainAdapter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.hh.VacanciesList;
import models.hh.Vacancy;
import resources.constants.VacancyDraft;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static resources.constants.VacancyNameConstants.QA_AUTO;
import static resources.constants.VacancyNameConstants.QA_MANUAL;

public class VacancyAdapter extends MainAdapter {

    public VacanciesList get(String vacancyName, String areaName, String experience) {
        Response response = given()
                // .log().uri()
                .when()
                .get("https://api.hh.ru/vacancies?text={vacancyName}&area={areaName}&only_with_salary=true&experience={experience}&per_page=100", vacancyName, areaName, experience)
                .then()
                //.log().body()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();
        VacanciesList vacanciesList = gson.fromJson(response.asString().trim(), VacanciesList.class);
        return verifyVacancyNameValid(vacanciesList, vacancyName);
    }

    public VacanciesList getAll(String vacancyName, String areaName, String experience) {
        Response response = given()
                // .log().uri()
                .when()
                .get("https://api.hh.ru/vacancies?text={vacancyName}&area={areaName}&experience={experience}&per_page=100", vacancyName, areaName, experience)
                .then()
                //.log().body()
                .statusCode(200)
                .contentType(ContentType.JSON).extract().response();
        return gson.fromJson(response.asString().trim(), VacanciesList.class);
    }

    public VacanciesList verifyVacancyNameValid(VacanciesList vacanciesList, String vacancyName) {

        VacancyDraft vacancyDraft = new VacancyDraft();
        VacanciesList correctVacancyList = new VacanciesList();
        List<Vacancy> correctVacancy = new ArrayList<>();

        if (!vacanciesList.getItems().isEmpty()) {
            for (Vacancy vacancy : vacanciesList.getItems()) {
                String vacancyNameToValid = vacancy.getName();
                switch (vacancyName){
                    case QA_MANUAL:
                        if (vacancyDraft.getDenyListManualQA().stream().noneMatch(vacancyNameToValid::contains)) {
                            correctVacancy.add(vacancy);
                        }
                        break;
                    case QA_AUTO:
                        if (vacancyDraft.getDenyListAutoQA().stream().noneMatch(vacancyNameToValid::contains)) {
                            correctVacancy.add(vacancy);
                        }
                        break;
                    default:
                        System.out.println("Smth wrong with vacancies list");
                        break;
                }
            }
            correctVacancyList.setItems(correctVacancy);

        }
        return correctVacancyList;
    }
}


