package performance_measure_tools;

public class Timer {
	private long start;
	private long stop;
	private long globalStart;
	public Timer() {
		this.globalStart = System.nanoTime();
	}
	public void Start() {
		this.start = System.nanoTime();
	}
	public void Stop() {
		this.stop = System.nanoTime();
	}
	public long Time() {
		return (this.stop - this.start);
	}
	public long TotalTime() {
		return (System.nanoTime() - this.globalStart);
	}
	public void PrintTime(String action) {
		System.out.println(action+" time: "+(this.stop - this.start)+"ns");
	}
	public void PrintTime() {
		System.out.println("Action time: "+(this.stop - this.start)+"ns");
	}
	public void PrintTotalTime() {
		System.out.println("Total time: "+ (System.nanoTime() - this.globalStart)+"ns");
	}


}
