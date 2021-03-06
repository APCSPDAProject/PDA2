package FBUtils;

import java.util.ArrayList;

import Main.Main;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class FireBaseUtils {

	static Firebase firebase;

	public static String chatName;

	public static long count;

	public static String myName = "testName";

	public static int MaxAge, MinAge;

	public static boolean initReciever;

	private static String userPass;

	public static void init() {
		firebase = new Firebase("https://pda.firebaseio.com/");

	}

	public static void setChat(String name2) {
		firebase = new Firebase("https://pda.firebaseio.com/");

		initReciever = false;
		Main.window.chat.removeAll();
		Main.window.chat.repaint();
		Main.window.chat.revalidate();
		chatName = (myName.compareTo(name2) == 1) ? (myName + name2)
				: (name2 + myName);
		getChildCount();
		System.out.println(chatName);

		if (!initReciever) {
			receiveMessage();

		}

	}

	public static void SendMessage(String data) {
		getChildCount();
		firebase.child("Chats").child(chatName).child("" + (count))
				.setValue(myName + ": " + data);
		Main.window.CI.setText("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void receiveMessage() {

		ValueEventListener value = new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {

				ArrayList<String> messages = (ArrayList<String>) snapshot
						.getValue();
				if (messages != null && !initReciever) {
					for (String m : messages) {

						Main.window.chat.UpdateChat("NotMe: test");
						Main.window.chat.UpdateChat(m);
						// System.out.println(m);
						initReciever = true;
					}
				} else {
					Main.window.chat
							.UpdateChat(messages.get(messages.size() - 1));
				}

			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}
		};

		firebase.child("Chats").child(chatName).addValueEventListener(value);
		// firebase.child("Chats").child(chatName).removeEventListener(value);
	}

	public static void getChildCount() {

		firebase.child("Chats").child(chatName)
				.addValueEventListener(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot snapshot) {
						count = snapshot.getChildrenCount();
					}

					@Override
					public void onCancelled(FirebaseError arg0) {
						// TODO Auto-generated method stub

					}
				});
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static ArrayList<String> users = new ArrayList<String>();

	public static boolean createUser(String userName, String password, String age) {

		firebase.child("Users").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if ((ArrayList<String>) snapshot.getValue() != null) {
					users = (ArrayList<String>) snapshot.getValue();
				}
			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}
		});
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String s : users) {

			if (s.startsWith(userName + ","))
				return false;
			else
				break;

		}

		userPass = userName + "," + password;
		firebase.child("Users").child(userName + "," + password).child("age")
				.setValue(age);

		firebase.child("Users").child(userName + "," + password)
				.child("MinAge")
				.setValue(Math.ceil((Float.parseFloat(age) / 2) + 7));

		firebase.child("Users").child(userName + "," + password)
				.child("MaxAge")
				.setValue(Math.floor((Float.parseFloat(age) - 7) * 2));

		return true;

	}

	public static boolean checkLogin(final String userName, final String password) {

		firebase.child("Users").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if ((ArrayList<String>) snapshot.getValue() != null) {
					users = (ArrayList<String>) snapshot.getValue();
				}
			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub

			}
		});
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String s : users) {

			if (s.startsWith(userName + ",")) {
				return true;

			}
		}

		return false;

	}

}
