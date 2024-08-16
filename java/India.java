
public class India {
	final int COURSER_SPEED = 71;

	void showFlag() {
		// System.out.println("Hey, Make Some Noise");
		// System.out.;
		// System.out.println("Let's Start!!!!");
		// System.out.flush();
		int ROWS , COLS , BRIKS = 7;
		ROWS = 5 * BRIKS;
		COLS = 6 * BRIKS;
		for (int i = 0; i < ROWS - BRIKS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (j < BRIKS)
					System.out.print(" ");
				else if (j == BRIKS) {
					System.out.print("|");
				}
				if ((i == 2 || i == 4 || i == 6 || i == 8) && j > BRIKS) {
					System.out.print("-");
				} else if (((i == 3 || i == 5 || i == 7) && j == COLS - 1)) {
					System.out.print("|");
				} else {
					if (i == 5 && j == COLS - (int)(BRIKS * 2.5)) {
						System.out.print("O");
					} else {

						System.out.print(" ");
					}

				}
				delay(COURSER_SPEED);
			}
			System.out.println();
		}
		for (int i = 0; i <= BRIKS; i++) {
			// Space 
			for (int j = 0; j <= BRIKS*2 - i - 1; j++) {
				System.out.print(" ");
				delay(COURSER_SPEED);
			}
			for (int j = i; j < 2 * i + 1; j++) {
				System.out.print("*");
				delay(COURSER_SPEED);
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
				delay(COURSER_SPEED);
			}
			System.out.println();
		}
		happyIndipendenceDay();
		
	}

	void buildIndianMap2() {
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 14; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 4 * i + 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j < (12 + i + i) + 2; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * 8 - i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 14 + i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 3 * (4 - i + 2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= (12 + i + i) + 2; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 12; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 18; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i + 6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2 * (9 - i + 1) - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i + 12; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2 * (7 - i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 3 * i + 13; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 3 * (11 - i + 1) + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 5 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j < 2 * (10 - 5 * (i) + (i * 2) - 1) + i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 7 * i + 16; k++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 2 * (8 - i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 4 * (2 - i + 1) + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i + 8; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= i + 4; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 24 * i + 13; j++) {
				System.out.print("*");
			}
			for (int j = i; j <= 1; j++) {
				System.out.print("        **      ********");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= i + 6; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (22 - i + 2); j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 12; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 1 - i + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 4 + 2 * i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 1 - i + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (40 + i + i) + 2; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 2 * (4 - i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 7 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 2 * (2 - i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 4 * i + 45; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 8; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (2 - i + 1) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 3 + i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 7 - i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 40 - 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 12 - i + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 35; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 12; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 30; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 12; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (14 - i + 1); j++) {
				System.out.print("*");
			}
			for (int j = i; j <= 1; j++) {
				System.out.print("");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= i + 11; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 25 - i + 1; j++) {
				System.out.print("*");
			}
			for (int j = i; j <= 1; j++) {
				System.out.print("");
			}

			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 14; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 20 - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= i + 14; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 16; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= i + 15; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 15 - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 18; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 12; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 20; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 10 - 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 1; i++) {
			for (int j = 1; j <= 21; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 4; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	void buildIndianMap() {
		int a = 10, b = 0, c = 10;

		// The encoded string after removing first 31 characters
		// Its individual characters determine how many spaces
		// or exclamation marks to draw consecutively.
		String s1 = "TFy!QJu ROo TNn(ROo)SLq SLq ULo+UHs UJq TNn*RPn/QP,\n"
				+ "bEWS_JSWQAIJO^NBELPeHBFHT}TnALVlBLOFAkHFOuFETpHCStHAUFAgcEAelc,\n"
				+ "lcn^r^r\\tZvYxXyT|S~Pn SPm SOn TNn ULo0ULo#ULo-WHq!WFs XDt!";

		// read each character of encoded string
		a = s1.charAt(b);

		while (a != 0) {
			if (b < 170) {
				a = s1.charAt(b);
				b++;
				while (a-- > 64) {

					if (++c == 'Z') {

						c /= 9;

						System.out.print((char) (c));
					} else
						System.out.print((char) (33 ^ (b & 0x01)));
					delay(this.COURSER_SPEED);
				}
			} else
				break;
		}
	}

	public static void main(String[] args) {
		India india = new India();
		india.showFlag();

		// india.happyIndipendenceDay();
		// india.buildIndianMap();

	}

	void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void happyIndipendenceDay() {
		// TODO Auto-generated method stub
		String indipendece = "Happy Independence Day ";
		for (int i = 0; i < 20; i++) {
			System.out.print(" ");
			delay(this.COURSER_SPEED);
		}
		for (char ch : indipendece.toCharArray()) {
			System.out.print("\\u001B[1m" + ch);
			delay(this.COURSER_SPEED);
		}
		System.out.println();
	}
}
