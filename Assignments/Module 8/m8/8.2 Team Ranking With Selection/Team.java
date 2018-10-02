class Team implements Comparable<Team>{
	String nameOfTeam;
	int numberOfWins;
	int numberOfLosses;
	int numberOfDraws;
	Team(String nameOfTeam, String numberOfWins, String numberOfLosses, String numberOfDraws) {
		this.nameOfTeam = nameOfTeam;
		this.numberOfWins = Integer.parseInt(numberOfWins);
		this.numberOfLosses = Integer.parseInt(numberOfLosses);
		this.numberOfDraws = Integer.parseInt(numberOfDraws);
	}
	public String getNameOfTeam() {
		return nameOfTeam;
	}
	public int getnumberOfWins() {
		return numberOfWins;
	}
	public int getnumberOfLosses() {
		return numberOfLosses;
	}
	public int getnumberOfDraws() {
		return numberOfDraws;
	}
	public int compareTo(Team c) {
		if (this.numberOfWins > c.numberOfWins) {
			return 1;
		}
		if (this.numberOfWins < c.numberOfWins) {
			return -1;
		}
		if (this.numberOfLosses < c.numberOfLosses) {
			return 1;
		}
		if (this.numberOfLosses > c.numberOfLosses) {
			return -1;
		}
		if (this.numberOfDraws > c.numberOfDraws) {
			return 1;
		}
		if (this.numberOfDraws < c.numberOfDraws) {
			return -1;
		}
		return 0;  
	}
	public String toString() {
		return this.nameOfTeam;
	}
}