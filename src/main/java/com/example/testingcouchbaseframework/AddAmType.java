package com.example.testingcouchbaseframework;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

@Document 
public class AddAmType {
	@IdAttribute
	private String addAmTypeCd;

	/**
	 * @return the addAmTypeCd
	 */
	public String getAddAmTypeCd() {
		return addAmTypeCd;
	}

	/**
	 * @param addAmTypeCd the addAmTypeCd to set
	 */
	public void setAddAmTypeCd(String addAmTypeCd) {
		this.addAmTypeCd = addAmTypeCd;
	}
}
