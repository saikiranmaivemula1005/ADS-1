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
	public void exchange(Team[] teamsArray, int i, int j) {
		Team t = teamsArray[j];
		teamsArray[j] = teamsArray[i];
		teamsArray[i] = t; 
	}
	public void InsertionSort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (lessthan(teamsArray, j - 1, j)) {
					exchange(teamsArray, j -1, j);
				} 
			}
        }
	}
	public boolean lessthan(Team[] arr, int i, int j) {
		return  arr[i].compareTo(arr[j]) < 0;
	}
}