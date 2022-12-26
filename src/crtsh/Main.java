package crtsh;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArgumentParser parser = ArgumentParsers.newFor("crtsh").build()
				.description("gather subdomain of a domain from certificate transparency");
		parser.addArgument("-d", "--domain").type(String.class).required(true);

		try {

			Namespace ns = parser.parseArgs(args);
			Api api = new Api();
			String domain = ns.getString("domain");
			api.api(domain);
		} catch (ArgumentParserException e) {
			parser.handleError(e);
			System.exit(1);
		}
	}

}
