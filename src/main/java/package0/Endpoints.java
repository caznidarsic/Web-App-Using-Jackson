package package0;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("example")
public class Endpoints {
	
	
	@POST
	@Path("toObject")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JacksonObject_return setObject(JacksonObject t) {
		JacksonObject_return jor = new JacksonObject_return();
		final String hike = t.getHike();
		final String date = t.getDate();
		final String duration = t.getDuration();
		final String hikers = t.getHikers();
		

		
		if (hike != null && date != null && duration != null && hikers != null) {
    		if (!hike.matches("^[a-zA-Z\\s-]+$")) {
    			jor.setReturnMessage("The field \"Hike\" is formatted incorrectly. The Hike name can only contain letters, spaces and \"-\" characters.");
    			return jor;
    		}
    		else if (!date.matches("^\\d\\d\\d\\d\\-\\d\\d\\-\\d\\d$")) {
    			jor.setReturnMessage("The date is formatted incorrectly. Proper format is: \"YYYY-MM-DD\"");
    			return jor;
    			    		}
			else if (Integer.parseInt(date.substring(0, 4)) > 2100) {
    			jor.setReturnMessage("The year is out of valid range.");
    			return jor;
			}
			else if (Integer.parseInt(date.substring(5, 7)) > 12) {
    			jor.setReturnMessage("The month is out of valid range.");
    			return jor;
			}
			else if (Integer.parseInt(date.substring(8, 10)) > 31) {
    			jor.setReturnMessage("The day is out of valid range.");
    			return jor;
			}
    		else if (!duration.matches("^\\d{1,2}$")) {
    			jor.setReturnMessage("The field \"Duration\" is formatted incorrectly. Proper format is: \"##\" or \"#\"");
    			return jor;
    		}
    		else if (!hikers.matches("^\\d+$")) {
    			jor.setReturnMessage("The field \"Hikers\" is formatted incorrectly. The field \"Hikers\" can only contain numbers.");
    			return jor;
    		}
    		else {
    			jor.setReturnMessage(GetQuote.getQuote(hike, date, Integer.valueOf(duration), Integer.valueOf(hikers)));
    			return jor;
    		}
		}
		else {
			jor.setReturnMessage("Some inputs were missing/formatted incorrectly.");
			return jor;
		}
	}
}
