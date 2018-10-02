class TeamDetails {
	private Team[] teamsArray;
	private int size;
	TeamDetails() {
		teamsArray = new Team[10];
		size = 0;
	}
	public void addCricketTeam(Team t) {
		teamsArray[size++] = t;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += teamsArray[i].nameOfTeam+",";
		}
		return s.substring(0, s.length() - 1);
	}
	public void exchange(Team[] teams, int i, int j) {
		Team ct = teams[j];
		teams[j] = teams[i];
		teams[i] = ct; 
	}
	public void selectionSort() {
		for (int i = 0; i < size - 1; i++) {
			int minimum = i;
			for (int j = i + 1; j < size; j++) {
				if (lessthan(teamsArray, j, minimum)) {
					minimum = j;
				} 
			}
			exchange(teamsArray, i, minimum);
        }
	}
	boolean lessthan(Team[] array, int i, int j) {
		return  array[i].compareTo(array[j]) > 0;
	}
}