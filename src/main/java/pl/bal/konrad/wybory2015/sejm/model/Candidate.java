package pl.bal.konrad.wybory2015.sejm.model;

import java.util.Arrays;
import java.util.List;

public class Candidate {
	private final String firstName;
	private final String lastName;
	private final String occupation;
	private final Integer listNumber;
	private final Integer positionOnList;
	private final boolean isMale;
	private final String city;
	private final Integer region;
	private final String listName;
	private final String partyName;

	public Candidate(String line) {
		List<String> lineAsList = Arrays.asList(line.split(","));

		region = Integer.valueOf(lineAsList.get(0));
		listNumber = Integer.valueOf(lineAsList.get(1));
		listName = lineAsList.get(2);
		positionOnList = Integer.valueOf(lineAsList.get(3));
		lastName = lineAsList.get(4);
		firstName = lineAsList.get(5);
		isMale = lineAsList.get(7).equals("M");
		city = lineAsList.get(8);
		occupation = lineAsList.get(9).toLowerCase();
		partyName = lineAsList.get(10);

	}

	public String getFirstName() {
		return firstName;
	}

	public Integer getPositionOnList() {
		return positionOnList;
	}

	public String getListName() {
		return listName;
	}

	public String getPartyName() {
		return partyName;
	}

	public String getLastName() {

		return lastName;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getCity() {
		return city;
	}

	public Integer getRegion() {
		return region;
	}

	public boolean isMale() {
		return isMale;
	}

	public boolean isFemale() {
		return !isMale;
	}

	public Integer getListNumber() {
		return listNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isMale ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((listName == null) ? 0 : listName.hashCode());
		result = prime * result + ((listNumber == null) ? 0 : listNumber.hashCode());
		result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		result = prime * result + ((positionOnList == null) ? 0 : positionOnList.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isMale != other.isMale)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (listName == null) {
			if (other.listName != null)
				return false;
		} else if (!listName.equals(other.listName))
			return false;
		if (listNumber == null) {
			if (other.listNumber != null)
				return false;
		} else if (!listNumber.equals(other.listNumber))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		if (positionOnList == null) {
			if (other.positionOnList != null)
				return false;
		} else if (!positionOnList.equals(other.positionOnList))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}
	

	@Override

	public String toString() {
		return firstName + " " + lastName + " (" + listName + ") ";
	}
}