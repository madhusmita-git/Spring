package test;
import java.text.DateFormatSymbols;
import java.util.Locale;


public class LocaleMonth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.FRANCE);
		String[] months = dfs.getMonths();
		for(String month : months) {
			System.out.println(month);
		}
	}

}
