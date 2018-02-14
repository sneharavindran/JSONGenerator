package net.sample.constructor.model;

import java.util.List;

public class JSONModel {

	private String id;

	private Name name;

	private String dob;

	private List<Locations> locations;

	private String imageId;


	public JSONModel(JSONModelBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.dob = builder.dob;
		this.locations = builder.locations;
		this.imageId = builder.imageId;
	}

	public String getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public List<Locations> getLocations() {
		return locations;
	}

	public String getImageId() {
		return imageId;
	}


	public static class JSONModelBuilder {

		private String id;

		private Name name;

		private String dob;

		private List<Locations> locations;

		private String imageId;

		public JSONModelBuilder setId(String id) {
			this.id = id;
			return this;
		}

		public JSONModelBuilder setName(Name name) {
			this.name = name;
			return this;
		}

		public JSONModelBuilder setDob(String dob) {
			this.dob = dob;
			return this;
		}

		public JSONModelBuilder setLocations(List<Locations> locations) {
			this.locations = locations;
			return this;
		}

		public JSONModelBuilder setImageId(String imageId) {
			this.imageId = imageId;
			return this;
		}

		public JSONModel build() {
			return new JSONModel(this);
		}


	}

	public static class Name {
		private String first;

		private String middle;

		private String last;

		public Name(String first, String middle, String last) {
			super();
			this.first = first;
			this.middle = middle;
			this.last = last;
		}

		public String getFirst() {
			return first;
		}

		public String getMiddle() {
			return middle;
		}

		public String getLast() {
			return last;
		}
		
		
	}


	public static class Locations {
		private String name;

		private Coords coords;

		public Locations(String name, Coords coords) {
			super();
			this.name = name;
			this.coords = coords;
		}

		public String getName() {
			return name;
		}

		public Coords getCoords() {
			return coords;
		}
		
		
	}

	public static class Coords {
		private String longi;

		private String lat;

		public Coords(String longi, String lat) {
			super();
			this.longi = longi;
			this.lat = lat;
		}

		public String getLongi() {
			return longi;
		}

		public String getLat() {
			return lat;
		}
		
		
		
	}


}


