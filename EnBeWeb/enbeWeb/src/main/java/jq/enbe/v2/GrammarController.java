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
 * Handles requests for the application grammar page.
 */
@Controller
public class GrammarController {
	
	private static final Logger logger = LoggerFactory.getLogger(GrammarController.class);
	
	/**
	 * Simply selects the grammar view to render by returning its name.
	 */
	@RequestMapping(value = "/grammar", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome grammar! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "grammar";
	}

}
