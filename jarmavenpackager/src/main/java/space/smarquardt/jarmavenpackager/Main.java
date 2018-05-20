package space.smarquardt.jarmavenpackager;

import java.io.File;

import com.beust.jcommander.Parameter;

public class Main {
	@Parameter(names = { "--manifest", "-m" }, required = false)
	File manifestPath;
	@Parameter(names = { "--install", "-i" }, required = true)
	File installPath;
	@Parameter(names = { "--libs", "-l" }, required = false)
	File libDir;

	public Main() {

	}

}
