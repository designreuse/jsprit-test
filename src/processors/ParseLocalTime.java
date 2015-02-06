package processors;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

public class ParseLocalTime implements CellProcessor {

	private DateTimeFormatter formatter;
	
	public ParseLocalTime(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public Object execute(Object value, CsvContext context) {
		return LocalTime.parse((CharSequence) value, formatter);
	}
	
}
