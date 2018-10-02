import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDetails teamDetails = new TeamDetails();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] tokens = data.split(",");
            Team team = new Team(tokens[0], tokens[1],
                tokens[2], tokens[2 + 1]);
            teamDetails.addCricketTeam(team);
        }
        teamDetails.InsertionSort();
        System.out.println(teamDetails);
    }
}
