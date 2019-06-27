import java.util.TreeMap;
import java.util.Scanner;

public class JumpingLeprechauns{

    public static TreeMap<Leprechaun, Integer> tracker = new TreeMap<Leprechaun, Integer>();

    public static class Leprechaun implements Comparable<Leprechaun>{
	int x_i; //position on horizon
	int g_i; //gold

	public Leprechaun(){
	    x_i = 0;
	    g_i = 1000000;
	}

	public void steal (Leprechaun from){
	    g_i += (from.g_i / 2.);
	    from.g_i /= 2.;
	}

	public void move(){
	    float r = (float) Math.random() - 1;
	    x_i += r * g_i;
	}

	public int compareTo(Leprechaun comparing){
	    return Integer.compare(x_i, comparing.x_i);
	}

	public String toString(){
	    return "[position: " + x_i + ", gold: " + g_i + "]";
	}

    }

    public static void populate(){
	Scanner sys = new Scanner(System.in);
	System.out.print("Cuantos leprechauns quieres? (How many leprechauns?): ");
	int leps = sys.nextInt();
	int i = 0 ;
	while (i < leps){
	    Leprechaun bob = new Leprechaun();
	    bob.move();
	    tracker.put(bob, bob.x_i);
	    i++;
	}
    }

    public static void main(String [] args){

	populate();
	int numleps = tracker.keySet().size();
	System.out.println("This is the original set: ");
	Leprechaun[] arrLep = tracker.keySet().toArray(new Leprechaun[numleps]);
	for (Leprechaun k: arrLep){
	    System.out.println(k);
	}

	System.out.println();

	for (int i = 0; i < Integer.parseInt(args[0]); i++){
	    for (int j = 0; j < numleps; j++){
		Leprechaun joe = arrLep[j];
		tracker.remove(joe);
		joe.move();
		tracker.put(joe, joe.x_i);
	    }
	    System.out.println("positions rn: ");
	    for (Leprechaun k: arrLep){
		System.out.println(k);
	    }
	    System.out.println();

	    for (int k = 0; k < numleps; k++){
		Leprechaun[] updated = tracker.keySet().toArray(new Leprechaun[numleps]);
		if (k==0){
		    updated[k].steal(updated[1]);
		}
		else if (k + 1 == numleps){
		    updated[k].steal(updated[k-1]);
		}
		else {
		    updated[k].steal(updated[k-1]);
		    updated[k].steal(updated[k+1]);

	    }


	System.out.println("\nafter all stealing it looks like this: ");
	for (Leprechaun z: arrLep){
	    System.out.println(z);
	}
    }
	}}}
