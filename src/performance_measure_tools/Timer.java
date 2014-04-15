package performance_measure_tools;

public class Timer {
	private long start;
	private long stop;
	public Timer(){
	
	}
	
	public void Start(){
		start = System.nanoTime();
	}
	public void Stop(){
		stop = System.nanoTime();
	}
	public void PrintTime(){
		System.out.println("working time: " + (stop - start) + "ns");
		
	}
}	

