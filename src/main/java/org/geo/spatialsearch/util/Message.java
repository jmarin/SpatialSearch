package org.geo.spatialsearch.util;

public enum Message {

	GEOGRAPHY_TYPE_NOT_VALID("Malformed URL: Geography Type not valid"), NO_STATE_RESULTS_FOUND(
			"No tate results found"), NO_COUNTY_RESULTS_FOUND(
			"No county results found"), NO_TRACT_RESULTS_FOUND(
			"No tract results found"), NO_BLOCK_RESULTS_FOUND(
			"No block results found"), NO_RESULTS_FOUND("No results found");

	private String message;

	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
