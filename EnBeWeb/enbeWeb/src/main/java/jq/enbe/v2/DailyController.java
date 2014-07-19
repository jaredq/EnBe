package jq.enbe.v2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application daily page.
 */
@Controller
public class DailyController {

	private static final Logger logger = LoggerFactory.getLogger(DailyController.class);

	/**
	 * Simply selects the daily view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/daily" }, method = RequestMethod.GET)
	public String daily(Locale locale, Model model) {
		logger.info("Welcome daily! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
				locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "daily";
	}

}
