package net.sample.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sample.constructor.model.JSONModel.Coords;
import net.sample.constructor.model.JSONModel.Locations;
import net.sample.constructor.model.JSONModel.Name;

public class ModelParser {

	public static Name parseName(String string) {
		Pattern pattern = Pattern.compile("<(\\w*)>");
		Matcher matcher = pattern.matcher(string);
		matcher.find();
		String firstName = matcher.group(1);
		matcher.find();
		String secName = matcher.group(1);
		matcher.find();
		String lastName = matcher.group(1);
		Name name = new Name(firstName, secName, lastName);
		return name;
	}

	public static List<Locations> parseLocations(String string) {
		List<Locations> loca = new ArrayList<Locations>(0);
		String [] locs = string.split(",");
		for (String loc : locs) {
			Pattern pattern = Pattern.compile("<(.*?)>");
			Matcher matcher = pattern.matcher(loc);
			matcher.find();
			String area = matcher.group(1);
			matcher.find();
			loc = loc.substring(area.length() + 3, loc.length() -1);
			pattern = Pattern.compile("<(.*?)>");
			matcher = pattern.matcher(loc);
			matcher.find();
			String lat = matcher.group(1);
			matcher.find();
			String longi = matcher.group(1);
			int a = 0;
			Coords coord = new Coords(longi, lat);
			Locations locat = new Locations(area, coord);
			loca.add(locat);
		}
		return loca;
	}

}
