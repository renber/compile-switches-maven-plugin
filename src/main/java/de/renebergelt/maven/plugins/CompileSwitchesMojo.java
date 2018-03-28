package de.renebergelt.maven.plugins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import de.renebergelt.maven.plugins.compileswitches.Field;
import de.renebergelt.maven.plugins.compileswitches.Switch;
import de.renebergelt.maven.plugins.compileswitches.SwitchesFile;

/**
 * A maven plugin which generates a static class with boolean public static
 * final fields which can be used to have some kind of conditional compilation
 * in Java
 * 
 **/
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CompileSwitchesMojo extends AbstractMojo {

	@Parameter(property = "switches")
	public List<Switch> switches;

	@Parameter(readonly = true, defaultValue = "${project}")
	private MavenProject project;

	public void execute() throws MojoExecutionException {
		log("CompileSwitchesMojo Copyright (c) 2018 by René Bergelt, TU Chemnitz");

		checkParams();		
		
		if (switches == null || switches.size() == 0) {
			warn("No compile switches have been defined. Skipping code-generation");
		} else {
			for (Switch sw : switches) {
				SwitchesFile genFile = new SwitchesFile(sw.getPackageName(), sw.getClassName(), sw.fields);

				String targetDir = project.getBuild().getDirectory() + "/generated-sources/compile-switches/";
				targetDir += sw.getPackageName().replace(".", "/");

				if (!new File(targetDir).exists()) {
					if (!new File(targetDir).mkdirs())
						throw new MojoExecutionException("Could not create target directory for code generation: " + targetDir);
				}

				try {
					genFile.save(targetDir + "/" + sw.getClassName() + ".java");

					// mark the generated file for compilation
					project.addCompileSourceRoot(targetDir);
				} catch (IOException e) {
					throw new MojoExecutionException(e.getMessage());
				}
			}
		}
	}

	private void log(String message) {
		getLog().info(message);
	}

	private void warn(String message) {
		getLog().warn(message);
	}

	private void error(String message) {
		getLog().error(message);
	}

	void checkParams() throws MojoExecutionException {
	}
}
