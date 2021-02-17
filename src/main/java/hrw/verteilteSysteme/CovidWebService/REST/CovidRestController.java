package hrw.verteilteSysteme.CovidWebService.REST;

import hrw.verteilteSysteme.CovidWebService.CovidInfo.CalculateCovidNumber;
import hrw.verteilteSysteme.CovidWebService.CovidInfo.JHU;
import hrw.verteilteSysteme.CovidWebService.CovidInfo.RKI;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 *
 * @author Markus Meier, Leon Wagner und Leona Cerimi
 *
 */
@RestController
public class CovidRestController {

	private CalculateCovidNumber calculateCovidNumber;

	public CovidRestController() {
		this.calculateCovidNumber = new CalculateCovidNumber(new RKI().getRKICovidInfo(), new JHU().getJHUCovidInfo());
	}

	public void loadCovidInfo() {
		calculateCovidNumber.setCountyList(new RKI().getRKICovidInfo());
		calculateCovidNumber.setGermanyInfoJHU(new JHU().getJHUCovidInfo());
	}

	@GetMapping("/allInfos/{rValue}/{day}")
	@ApiResponse(description = "Liefert alle Informationen unserer Kennzahlen", responseCode = "200")
	public String getAllInfos(@PathVariable("rValue") int rValue, @PathVariable("day") int day) {
		loadCovidInfo();
		JSONObject covindInfoJsonObj = new JSONObject();
		covindInfoJsonObj.put("date", calculateCovidNumber.getGermanyInfoJHU()
				.get(calculateCovidNumber.getGermanyInfoJHU().size() - 1).getDate()).toString();

		covindInfoJsonObj.put("rValueTotalGermany", calculateCovidNumber.getRValueTotalGermanyRKI()).toString();

		covindInfoJsonObj.put("totalTargetInfection", calculateCovidNumber.getTotalTargetInfectionRKI(rValue))
				.toString();

		covindInfoJsonObj.put("targetIncidenceForRValue", calculateCovidNumber.getTargetIncidenceForRValueRKI(rValue,day)).toString();

		covindInfoJsonObj.put("averageIncrease", calculateCovidNumber.getAverageIncreaseDayJHU(day)).toString();

		covindInfoJsonObj.put("percentInfection", calculateCovidNumber.getIncreaseLastDayJHU()).toString();

		covindInfoJsonObj.put("totalInfection", calculateCovidNumber.getTotalInfectionsJHU()).toString();

		covindInfoJsonObj.put("newInfection24", calculateCovidNumber.getNewInfectionsLastDayJHU()).toString();

		return covindInfoJsonObj.toString();
	}

	@GetMapping("/date")
	@ApiResponse(description = "Liefert das Datum des Datensatzes", responseCode = "200")
	public String getDate() {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getGermanyInfoJHU()
				.get(calculateCovidNumber.getGermanyInfoJHU().size() - 1).getDate()).toString();
		obj.put("info", "date").toString();
		return obj.toString();
	}

	// RKI Anforderungen
	@GetMapping("/rValueTotalGermany")
	@ApiResponse(description = "Liefert die Gesamtinfektionen", responseCode = "200")
	public String getRValueTotalGermany() {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getRValueTotalGermanyRKI()).toString();
		obj.put("info", "rValueTotalGermany").toString();
		return obj.toString();

	}

	@GetMapping("/totalTargetInfection/{rValue}")
	@ApiResponse(description = "Liefert Anstieg der letzten 24h", responseCode = "200")
	public String getTotalTargetInfection(@PathVariable("rValue") int rValue) {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getTotalTargetInfectionRKI(rValue)).toString();
		obj.put("info", "totalTargetInfection/" + rValue).toString();
		return obj.toString();
	}

	@GetMapping("/targetIncidenceForRValue/{rValue}/{day}")
	@ApiResponse(description = "Liefert die Voraussage ueber die noch notwendigen Tage des Lockdowns bis zur\n" +
			"\t//Erreichung einer definierten Inzidenz (r-Wert)", responseCode = "200")
	public String getTargetIncidenceForRValue(@PathVariable("rValue") int rValue, @PathVariable("day") int day) {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getTargetIncidenceForRValueRKI(rValue,day)).toString();
		obj.put("info", "targetIncidenceForRValue/" + rValue + "/" + day).toString();
		return obj.toString();
	}

	// JHU Anforderungen
	@GetMapping("/averageIncrease/{day}")
	@ApiResponse(description = "Liefert die durchschnittlicher Anstieg der letzten n Tage", responseCode = "200")
	public String getAverageIncrease(@PathVariable("day") int day) {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getAverageIncreaseDayJHU(day)).toString();
		obj.put("info", "averageIncrease/" + day).toString();
		return obj.toString();
	}

	@GetMapping("/percentInfection")
	@ApiResponse(description = "Liefert den Anstieg der letzten 24h", responseCode = "200")
	public String getPercenteInfection() {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getIncreaseLastDayJHU()).toString();
		obj.put("info", "percentInfection").toString();
		return obj.toString();
	}

	@GetMapping("/totalInfection")
	@ApiResponse(description = "Liefert die aktuelle Gesamtinfektionen", responseCode = "200")
	public String getTotalInfection() {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getTotalInfectionsJHU()).toString();
		obj.put("info", "totalInfection").toString();
		return obj.toString();
	}
	//Eigentlich: newInfectionLast24
	@GetMapping("/newInfectionLastDay")
	@ApiResponse(description = "Liefert die Neuinfektion in den letzten 24h", responseCode = "200")
	public String getNewInfection() {
		loadCovidInfo();
		JSONObject obj = new JSONObject();
		obj.put("value", calculateCovidNumber.getNewInfectionsLastDayJHU()).toString();
		obj.put("info", "newInfectionLastDay").toString();
		return obj.toString();
	}

}
