import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try {

			FileInputStream fileInStreamObj = new FileInputStream("parole.txt");
			InputStream inStreamObject = ((InputStream) fileInStreamObj);
			Scanner sc = new Scanner(inStreamObject);
			Scanner s = new Scanner(System.in);

			String input = sc.nextLine();
			String input1 = sc.nextLine();
			String input2 = sc.nextLine();

			String[] arr = input.split(" ");
			String[] arr1 = input1.split(" ");
			String[] arr2 = input2.split(" ");
			String[] usernames = { arr[0], arr1[0], arr2[0] };
			String[] parole = { arr[1], arr1[1], arr2[1] };

			int k = 0;
			int pp = 0;
			int zz = 0;
			while (k <= 15) {
				System.out.println("Enter user name");
				String user = s.nextLine();

				System.out.println("Enter user pass");
				String pass = s.nextLine();

				int i = 0;
				for (i = 0; i < usernames.length; i++) {
					if (user.equals(usernames[i])) {

						if (pass.equals(parole[i])) {
							System.out.println("acces permis");
							k = 16;
							pp = 0;
							zz = 0;
						} else {
							zz = zz + 5;

						}
						pp = 0;
					} else {

						pp = pp + 5;

					}

				}
				System.out.println(zz);
				System.out.println(pp);
				if (zz >= 15) {

					System.out.println("Cont Blocat");
					k=16;
				}
				if (pp >= 75) {

					System.out.println("Ar trebui sa inregistrezi");
					FileOutputStream fout=new FileOutputStream("parole.txt",true);    
					System.out.println("Enter  new user name");
					 user = s.nextLine();
					 byte a[]=user.getBytes();
					 fout.write(13);
					 fout.write(a);
					 fout.write(32);
					System.out.println("Enter  new user pass");
					 pass = s.nextLine();
		             byte b[]=pass.getBytes();
		             
		             fout.write(b);
		             fout.close();    
		             System.out.println("success...");   
		             k=16;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
