package de.renebergelt.maven.plugins.compileswitches;

public class Field {
	
	public String fieldName;	
	public boolean fieldValue;	
	
	public String getFieldName() {
		return fieldName;
	}
	
	public boolean getFieldValue() {
		return fieldValue;
	}
	
	public Field() {
		// --
	}
	
	public Field(String fieldName, boolean fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
