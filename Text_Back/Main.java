import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<byte[]> list = new ArrayList<byte[]>(); // list is used for stored
		byte[] unit = new byte[10000];// unit
		int index = 0;
		byte p = 0; // p is used as a point
		int start = 0;
		while (in.hasNext()) {
			String line = in.nextLine();
			for (int j = 0; j + 1 < line.length(); j++) {
				// find the first letter in the unit
				p = (byte) line.charAt(j);
				while (p == ' ' && j + 1 < line.length()) {
					j++;
					p = (byte) line.charAt(j);
				}
				while (j + 1 < line.length()) {

					for (index = 0; index < 10000 && j + 1 < line.length();) {
						if (p >= 'a' && p <= 'z') {
							if (start == 0) {
								unit[index++] = (byte) (p - 32);
								start = 1;
							} else
								unit[index++] = p;
							j = j + 1;
							p = (byte) line.charAt(j);
							if (p == ' ') {

								unit[index++] = p;
								while (p == ' ' && j + 1 < line.length()) {
									j++;
									p = (byte) line.charAt(j);
								}

							} else {
								if (p == ',') {
									unit[index++] = p;
									unit[index++] = ' ';
									j = j + 1;
									p = (byte) line.charAt(j);
									while (p == ' ' && j + 1 < line.length()) {
										j++;
										p = (byte) line.charAt(j);
									}

								} else if (p == '.') {
									start = 0;
									unit[index++] = p;
									unit[index++] = ' ';
									j = j + 1;
									p = (byte) line.charAt(j);
									while (p == ' ' && j + 1 < line.length()) {
										if (p != ' ') {
											if (p == '\n')
												unit[index - 1] = '\n';
											else
												break;
										}
										j++;
										p = (byte) line.charAt(j);
									}

								}
							}
							if (p == ',') {
								unit[index - 1] = p;
								unit[index++] = ' ';
								j = j + 1;
								p = (byte) line.charAt(j);
								while (p == ' ' && j + 1 < line.length()) {
									j++;
									p = (byte) line.charAt(j);
								}

							} else if (p == '.') {
								start = 0;
								unit[index - 1] = p;
								unit[index++] = ' ';
								j = j + 1;
								p = (byte) line.charAt(j);
								while (p == ' ' && j + 1 < line.length()) {
									if (p != ' ') {
										if (p == '\n')
											unit[index - 1] = '\n';
										else
											break;
									}
									j++;
									p = (byte) line.charAt(j);
								}

							}

						}

						else if (p >= 'A' && p <= 'Z') {
							if (start == 0) {
								unit[index++] = p;
								start = 1;
							} else {
								unit[index++] = (byte) (p + 32);
							}
							j = j + 1;
							p = (byte) line.charAt(j);
							if (p == ' ') {

								unit[index++] = p;
								while (p == ' ' && j + 1 < line.length()) {
									j++;
									p = (byte) line.charAt(j);
								}

							} else {
								if (p == ',') {
									unit[index++] = p;
									unit[index++] = ' ';
									j = j + 1;
									p = (byte) line.charAt(j);
									while (p == ' ' && j + 1 < line.length()) {
										j++;
										p = (byte) line.charAt(j);
									}

								} else if (p == '.') {
									start = 0;
									unit[index++] = p;
									unit[index++] = ' ';
									j = j + 1;
									p = (byte) line.charAt(j);
									while (p == ' ' && j + 1 < line.length()) {
										if (p != ' ') {
											if (p == '\n')
												unit[index - 1] = '\n';
											else
												break;
										}
										j++;
										p = (byte) line.charAt(j);
									}

								}
							}
							if (p == ',') {
								unit[index - 1] = p;
								unit[index++] = ' ';
								j = j + 1;
								p = (byte) line.charAt(j);
								while (p == ' ' && j + 1 < line.length()) {
									j++;
									p = (byte) line.charAt(j);
								}

							} else if (p == '.') {
								start = 0;
								unit[index - 1] = p;
								unit[index++] = ' ';
								j = j + 1;
								p = (byte) line.charAt(j);
								while (p == ' ' && j + 1 < line.length()) {
									if (p != ' ') {
										if (p == '\n')
											unit[index - 1] = '\n';
										else
											break;
									}
									j++;
									p = (byte) line.charAt(j);
								}

							}

						}

					}

				}

			}

			System.out.println(new String(unit));
		}
		in.close();
	}

}
