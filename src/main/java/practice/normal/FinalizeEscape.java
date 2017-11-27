package practice.normal;

public class FinalizeEscape {

	public static FinalizeEscape fe = null;

	public FinalizeEscape() {
		// TODO Auto-generated constructor stub
	}

	public static void alive() {
		System.out.println("i am alive!");
	}

	public static void dead() {
		System.out.println("i am death");
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		// FinalizeEscape.fe = this;
		System.out.println("excute finalize method!");
	}

	public static void main(String[] args) throws Throwable {
		fe = new FinalizeEscape();
		fe = null;
		System.gc();
		Thread.sleep(500);
		if (fe != null) {
			alive();
		} else {
			dead();
		}
		fe = null;
		System.gc();
		Thread.sleep(500);
		if (fe != null) {
			alive();
		} else {
			dead();
		}

	}

}
