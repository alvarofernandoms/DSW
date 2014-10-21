package context;

import video.Video;

public class ViewerFromBrazil implements Video {

	String urlNerdOffice;
	String urlDesceALetra;
	String country;

	public String getViewVideoNerdOffice() {
		return urlNerdOffice;
	}

	public String getViewVideoDesceALetra() {
		return urlDesceALetra;
	}

	public String getCountry() {
		return country;
	}

	public void setViewVideoNerdOffice(String urlNerdOffice) {
		this.urlNerdOffice = urlNerdOffice;
	}

	public void setViewVideoDessceALetra(String urlDesceALetra) {
		this.urlDesceALetra = urlDesceALetra;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
