import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {

			FileInputStream fileInStreamObj = new FileInputStream("parole.txt");
			InputStream inStreamObject = ((InputStream) fileInStreamObj);
			Scanner sc = new Scanner(inStreamObject);
			FileInputStream fileInStreamObj1 = new FileInputStream("parole.txt");
			InputStream inStreamObject1 = ((InputStream) fileInStreamObj1);
			Scanner sc1 = new Scanner(inStreamObject1);
			Scanner s = new Scanner(System.in);
			int numberoflines = 0;
			while (sc1.hasNextLine()) {

				sc1.nextLine();
				numberoflines++;
			}

			String ppp[] = new String[numberoflines];
			for (int i = 0; i < numberoflines; i++) {
				String input = sc.nextLine();
				ppp[i] = input;
			}
			String usernames[] = new String[numberoflines];
			String parole[] = new String[numberoflines];
			for (int i = 0; i < numberoflines; i++) {
				String arr[] = ppp[i].split(" ");

				usernames[i] = arr[0];
				parole[i] = arr[1];
			}

			int k = 0;
			int zz = 0;
			int pp = 0;
			while (k <= 15) {
				System.out.println("Enter user name");
				String user = s.nextLine();

				System.out.println("Enter user pass");
				String pass = s.nextLine();

				int i = 0;
				for (i = 0; i < numberoflines; i++) {
					if (user.equals(usernames[i])) {

						if (pass.equals(parole[i])) {
							System.out.println("acces permis");
							k = 16;

						} else {

							zz = zz + 3;
						}

					} else {

						pp = pp + 1;

					}

				}

				if (zz >= 9) {

					System.out.println("Cont Blocat");
					k = 16;
				} else {
					System.out.println(zz);
				}
				if (pp >= 5 * numberoflines) {

					System.out.println("Ar trebui sa inregistrezi");
					FileOutputStream fout = new FileOutputStream("parole.txt", true);
					System.out.println("Enter  new user name");
					user = s.nextLine();
					byte a[] = user.getBytes();
					fout.write(13);
					fout.write(a);
					fout.write(32);
					System.out.println("Enter  new user pass");
					pass = s.nextLine();
					byte b[] = pass.getBytes();

					fout.write(b);
					fout.close();
					System.out.println("success...");
					k = 16;
				} else {
					System.out.println(pp);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
