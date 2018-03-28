package de.renebergelt.maven.plugins.compileswitches;

import java.util.List;

public class Switch {

	public String packageName;
	
	public String className;
	
	public List<Field> fields;
	
	public String getPackageName() {
		return packageName;
	}
	
	public String getClassName() {
		return className;
	}

	public List<Field> getFields() {
		return fields;
	}
	
}
