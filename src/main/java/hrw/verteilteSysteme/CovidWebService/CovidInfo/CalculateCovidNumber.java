package hrw.verteilteSysteme.CovidWebService.CovidInfo;

import java.util.List;
/**
 *
 * @author Markus Meier, Leon Wagner und Leona Cerimi
 *
 */
public class CalculateCovidNumber {
	private List<JhuDataSet> germanyInfoJHU;
	private List<County> countyList;

	public CalculateCovidNumber(List<County> countyList, List<JhuDataSet> germanyInfoJHU) {
		this.countyList = countyList;
		this.germanyInfoJHU = germanyInfoJHU;
	}
	//1a) Neuinfektion in den letzten 24h
	public int getNewInfectionsLastDayJHU() {
		JhuDataSet lastday = germanyInfoJHU.get(germanyInfoJHU.size() - 1);
		JhuDataSet dayBeforeLastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 2);
		return lastday.getConfirmed() - dayBeforeLastDay.getConfirmed();
	}
	//1b) Gesamtinfektionen
	public int getTotalInfectionsJHU() {
		JhuDataSet lastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 1);
		return lastDay.getConfirmed() - lastDay.getDeaths() - lastDay.getRecovered();
	}
	//1c) Anstieg der letzten 24h
	public double getIncreaseLastDayJHU() {
		JhuDataSet lastday = germanyInfoJHU.get(germanyInfoJHU.size() - 1);
		JhuDataSet dayBeforeLastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 2);
		int lastDayInfection=lastday.getConfirmed() - dayBeforeLastDay.getConfirmed();

		JhuDataSet beforeLastday = germanyInfoJHU.get(germanyInfoJHU.size() - 2);
		JhuDataSet beforeDayBeforeLastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 3);
		int beforeLastDayInfection=lastday.getConfirmed() - dayBeforeLastDay.getConfirmed();

		return lastDayInfection-beforeLastDayInfection;
	}
	//1d) Durchschnittlicher Anstieg der letzten n Tage
	public int getAverageIncreaseDayJHU(int days) {
		int totalDays = 0;
		for (int i = 0; i < days; i++) {
			totalDays = totalDays + getNewInfectionAtThisDay(i);
		}
		return totalDays / days;
	}
	//Hilfesmethode
	private int getNewInfectionAtThisDay(int dayIndex) {
		JhuDataSet lastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 1 - dayIndex);
		JhuDataSet dayBeforeLastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 2 - dayIndex);
		return lastDay.getConfirmed() - dayBeforeLastDay.getConfirmed();
	}
	//2a) r-Wert fuer Gesamtdeutschland
	public double getRValueTotalGermanyRKI() {
		double totalRValue = 0;
		for (County county : countyList) {
			totalRValue = totalRValue + county.getrNumber();
		}
		return totalRValue / countyList.size();
	}
	//2b) Ziel-Gesamtinfektion
	public double getTotalTargetInfectionRKI(double rGoal) {
		double actualInfectedPeople = getTotalInfectionsJHU();
		double rValue = getRValueTotalGermanyRKI();
		return (actualInfectedPeople / rValue) * rGoal;
	}
	//2c) Voraussage ueber die noch notwendigen Tage des Lockdowns bis zur
	//Erreichung einer definierten Inzidenz (r-Wert)
	public Double getTargetIncidenceForRValueRKI(double rGoal, int nDay) {


		double totalInfection = getTotalInfectionsJHU();
		double totalTargetInfection = getTotalTargetInfectionRKI(rGoal);
		double days = (totalInfection - totalTargetInfection) / getNDay(7);
		return days;
	}

	private double getNDay(int nDay) {
		int dayCount = 0;
		for (int i = 0; i < nDay; i++) {
			JhuDataSet lastday = germanyInfoJHU.get(germanyInfoJHU.size() - 1 - i);
			JhuDataSet dayBeforeLastDay = germanyInfoJHU.get(germanyInfoJHU.size() - 2 - i);

			int firstInfection = lastday.getConfirmed() - dayBeforeLastDay.getConfirmed();

			JhuDataSet lastday2 = germanyInfoJHU.get(germanyInfoJHU.size() - 2 - i);
			JhuDataSet dayBeforeLastDay2 = germanyInfoJHU.get(germanyInfoJHU.size() - 3 - i);

			int secondInfection = lastday2.getConfirmed() - dayBeforeLastDay2.getConfirmed();
			int dif = firstInfection - secondInfection;
			if(dif<0){
				dayCount = dayCount + dif;
			}
		}
		if (dayCount < 0) {
			dayCount = dayCount * (-1);
		}
		return dayCount / nDay;
	}

	public List<JhuDataSet> getGermanyInfoJHU() {
		return germanyInfoJHU;
	}

	public void setGermanyInfoJHU(List<JhuDataSet> germanyInfoJHU) {
		this.germanyInfoJHU = germanyInfoJHU;
	}

	public List<County> getCountyList() {
		return countyList;
	}

	public void setCountyList(List<County> countyList) {
		this.countyList = countyList;
	}
}
