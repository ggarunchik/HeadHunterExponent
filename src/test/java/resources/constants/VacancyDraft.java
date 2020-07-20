package resources.constants;

import java.util.ArrayList;
import java.util.List;

public class VacancyDraft {
    private List<String> denyListManualQA = new ArrayList<>();
    private List<String> denyListAutoQA = new ArrayList<>();

    public VacancyDraft() {
        initLists();
    }

    public List<String> getDenyListManualQA() {
        return denyListManualQA;
    }

    public List<String> getDenyListAutoQA() {
        return denyListAutoQA;
    }

    public void initLists(){
        denyListManualQA.add("Auto");
        denyListManualQA.add("Automation");
        denyListManualQA.add("developer");
        denyListManualQA.add("разработчик");
        denyListManualQA.add("Разработчик");
        denyListManualQA.add("продавец");
        denyListManualQA.add("консультант");
        denyListManualQA.add("контролер ОТК");
        denyListManualQA.add("производство");
        denyListManualQA.add("Инженер по качеству");
        denyListManualQA.add("Ведущий");
        denyListManualQA.add("администратор");
        denyListManualQA.add("Системный");

        denyListAutoQA.add("developer");
        denyListAutoQA.add("разработчик");
        denyListAutoQA.add("продавец");
        denyListAutoQA.add("консультант");
        denyListAutoQA.add("manual");
        denyListAutoQA.add("ручной");
        denyListAutoQA.add("ручное");
        denyListAutoQA.add("мануальное");
    }
}
