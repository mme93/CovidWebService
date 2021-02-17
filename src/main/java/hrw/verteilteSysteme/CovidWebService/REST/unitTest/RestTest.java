package hrw.verteilteSysteme.CovidWebService.REST.unitTest;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hrw.verteiltesysteme.app.CovidRestController;
import hrw.verteiltesysteme.covid.CalculateCovidNumber;
import hrw.verteiltesysteme.covid.JHU;
import hrw.verteiltesysteme.covid.RKI;
*/
public class RestTest {
	/*
	static CovidRestController restController;
	static CalculateCovidNumber calculateCovidNumber;

	@BeforeAll()
	public static void initializeMockData() {
		restController = new CovidRestController();
		calculateCovidNumber = new CalculateCovidNumber(new RKI().getRKICovidInfo(), new JHU().getJHUCovidInfo());
	}
	
	@Test
	@DisplayName("Check the GetRequest")
	public void testGetRequest() {
		assertEquals(new JSONObject(restController.getDate()).get("value").toString(), calculateCovidNumber
				.getGermanyInfoJHU().get(calculateCovidNumber.getGermanyInfoJHU().size() - 1).getDate());
		assertEquals(new JSONObject(restController.getAverageIncreaseDay(7)).get("value").toString(),
				String.valueOf(calculateCovidNumber.getAverageIncreaseDayJHU(7)));
		assertEquals(new JSONObject(restController.getNewInfection()).get("value").toString(),
				String.valueOf(calculateCovidNumber.getNewInfectionsLastDayJHU()));
		assertEquals(new JSONObject(restController.getRWerthTotalGermany()).get("value").toString(),
				String.valueOf(calculateCovidNumber.getRWerthTotalGermanyRKI()));
		assertEquals(new JSONObject(restController.getTargetIncidenceForRWert(35, 7)).get("value").toString(),
				String.valueOf(calculateCovidNumber.getTargetIncidenceForRWerthRKI(50,
						calculateCovidNumber.getTotalTargetInfectionRKI(50), 7)));
		assertEquals(new JSONObject(restController.getTotalInfection()).get("value").toString(),
				String.valueOf(calculateCovidNumber.getTotalInfectionsJHU()));
		assertEquals(new JSONObject(restController.getTotalTargetInfection(35)).get("value").toString(),
				String.valueOf(calculateCovidNumber.getTotalTargetInfectionRKI(35)));
		assertEquals(new JSONObject(restController.getPercenteInfection()).get("value").toString(),
				String.valueOf(calculateCovidNumber.getIncreaseLasteDayJHU()));
	}
	*/
	
}
