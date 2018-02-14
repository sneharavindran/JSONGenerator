package net.sample.constructor;

import net.sample.constructor.model.JSONModel;
import net.sample.utility.ModelParser;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONConstructor {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		if (args.length != 1) {
			System.out.println("Wrong data format.. Usage : 'java JSONConstructor <string to be parsed>'");
			System.exit(0);
		}
		String queryString = args[0];
		String [] fields = queryString.split("\\|");
		JSONModel.JSONModelBuilder modelBuilder = new JSONModel.JSONModelBuilder();
		JSONModel model = modelBuilder.setId(fields[1]).setName(ModelParser.parseName(fields[2])).setDob(fields[3])
		.setLocations(ModelParser.parseLocations(fields[4])).setImageId(fields[5]).build();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(model);
		System.out.println("JSON String:\n".concat(jsonString));
	}

}
