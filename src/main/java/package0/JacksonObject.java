package package0;

public class JacksonObject {
	
	private String hike;
	private String date;
	private String duration;
	private String hikers;
	
	
	public String getHike() {
		return hike;
	}

	public void setHike(String hike) {
		this.hike = hike;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public JacksonObject() {
		super();
	}
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getHikers() {
		return hikers;
	}

	public void setHikers(String hikers) {
		this.hikers = hikers;
	}


	@Override
	public String toString() {
		return "JacksonObject [hike=" + hike + ", date=" + date + ", duration=" + duration + ", hikers=" + hikers + "]";
	}

	
}
