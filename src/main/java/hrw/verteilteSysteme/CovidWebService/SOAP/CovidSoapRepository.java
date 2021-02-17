package hrw.verteilteSysteme.CovidWebService.SOAP;

import generated.Covid;
import hrw.verteilteSysteme.CovidWebService.CovidInfo.CalculateCovidNumber;
import hrw.verteilteSysteme.CovidWebService.CovidInfo.JHU;
import hrw.verteilteSysteme.CovidWebService.CovidInfo.RKI;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
/**
 *
 * @author Markus Meier, Leon Wagner und Leona Cerimi
 *
 */

@Component
public class CovidSoapRepository {

    public Covid findCovid(int nDays, String info, int rValue) {
        CalculateCovidNumber calculateCovidNumber = new CalculateCovidNumber(new RKI().getRKICovidInfo(), new JHU().getJHUCovidInfo());
        Covid covid;
        switch (info) {
            case "/date":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",calculateCovidNumber.getGermanyInfoJHU().get(calculateCovidNumber.getGermanyInfoJHU().size()-1).getDate()).toString());
                return covid;
            case "/infection":
                covid = new Covid();
                covid.setJsonInfo( new JSONObject().put("value",String.valueOf(calculateCovidNumber.getNewInfectionsLastDayJHU())).toString());
                return covid;
            case "/infected":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",String.valueOf(calculateCovidNumber.getTotalInfectionsJHU())).toString());
                return covid;
            case "/increase":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",String.valueOf(calculateCovidNumber.getIncreaseLasteDayJHU())).toString());
            return covid;
            case "/average":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",String.valueOf(calculateCovidNumber.getAverageIncreaseDayJHU(nDays))).toString());
                return covid;
            case "/incidencevalue":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",String.valueOf(calculateCovidNumber.getRWerthTotalGermanyRKI())).toString());
                return covid;
            case "/incidencegoal":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",calculateCovidNumber.getTotalTargetInfectionRKI(rValue)).toString());
                return covid;
            case "/days":
                covid = new Covid();
                covid.setJsonInfo(new JSONObject().put("value",String.valueOf(calculateCovidNumber.getTargetIncidenceForRWerthRKI(rValue,calculateCovidNumber.getTotalInfectionsJHU(),nDays))).toString());
                return covid;
            default:
                covid = new Covid();
                covid.setJsonInfo("Tut mir leid, diesen Befehl verstehe ich nicht.");
                return covid;
        }
    }
}