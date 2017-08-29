import java.util.ArrayList;
import java.util.Scanner;

public class Main_5 {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<User> all = new ArrayList<User>();

	public static void main(String[] args) {

		for (int i = 1; i < 19; i++) {
			all.add(new User(i));
		}
		getUser(2).addFriend(getUser(6));
		getUser(1).addFriend(getUser(6));
		getUser(3).addFriend(getUser(6));
		getUser(6).addFriend(getUser(4));
		getUser(5).addFriend(getUser(6));
		getUser(7).addFriend(getUser(6));
		getUser(3).addFriend(getUser(4));
		getUser(5).addFriend(getUser(4));
		getUser(5).addFriend(getUser(3));
		getUser(8).addFriend(getUser(7));
		getUser(8).addFriend(getUser(9));
		getUser(10).addFriend(getUser(9));
		getUser(10).addFriend(getUser(11));
		getUser(12).addFriend(getUser(11));
		getUser(12).addFriend(getUser(9));
		getUser(13).addFriend(getUser(12));
		getUser(13).addFriend(getUser(14));
		getUser(15).addFriend(getUser(13));
		getUser(15).addFriend(getUser(3));
		getUser(17).addFriend(getUser(16));
		getUser(17).addFriend(getUser(18));
		getUser(16).addFriend(getUser(18));

\System.out.println(getUser(2).degreeOfSeperation(16));
	}

	public static class User {

		int id;
		ArrayList<User> friends = new ArrayList<User>();

		public User(int id) {
			this.id = id;
		}

		public void addFriend(User friend) {
			if (friends.indexOf(friend) == -1) {
				friends.add(friend);
				friend.friends.add(this);
			}
		}

		public void deleteFriend(User friend) {
			friends.remove(friend);
			friend.friends.remove(this);
		}

		public int countFriends() {
			return friends.size();
		}

		public int countFOFs() {

			ArrayList<User> fofs = new ArrayList<User>();

			for (User friend : friends) {
				for (User fof : friend.friends) {
					if (friends.indexOf(fof) == -1) {
						if (fofs.indexOf(fof) == -1) {
							if (!(fof == this))
								fofs.add(fof);
						}
					}
				}
			}

			return fofs.size();

		}

		public int degreeOfSeperation(int id) {
			ArrayList<User> personDeg = new ArrayList<User>();
			ArrayList<Integer> degree = new ArrayList<Integer>();

			int index = 0;
			
			personDeg.add(this);
			degree.add(0);
			
			while (index < degree.size()) {
				User currentPerson = personDeg.get(index);
				for (int i = 0; i < currentPerson.countFriends(); i++) {
					User currentCurrentPerson = currentPerson.friends.get(i);
					if (currentCurrentPerson.id == id) {
						return 1 + degree.get(index);
					}
					if (personDeg.indexOf(currentCurrentPerson) == -1) {
						personDeg.add(currentCurrentPerson);
						degree.add(1 + degree.get(index));
					}
				}
				index++;
			}
			
			return -1;
		}

	}

	public static User getUser(int id) {
		for (User user : all) {
			if (user.id == id) {
				return user;
			}
		}
		return null;
	}

}
