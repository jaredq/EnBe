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
 * Handles requests for the application alphabets page.
 */
@Controller
public class AlphabetsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlphabetsController.class);
	
	/**
	 * Simply selects the alphabets view to render by returning its name.
	 */
	@RequestMapping(value = "/alphabets", method = RequestMethod.GET)
	public String alphabets(Locale locale, Model model) {
		logger.info("Welcome alphabets! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "alphabets";
	}
	
}
