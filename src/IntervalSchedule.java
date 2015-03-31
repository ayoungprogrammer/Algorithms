import java.util.Collections;
import java.util.Vector;

public class IntervalSchedule {

  static class Interval implements Comparable<Interval> {
    int start, end;
    public Interval(int start, int end){
      this.start = start;
      this.end = end;
    }
    @Override
    public int compareTo(Interval i) {
      return end - i.end;
    }
  }
  
  static int maxEvents(Vector<Interval> intervals) {
    // Sort intervals by earliest end time.
    Collections.sort(intervals);
    int curTime = 0;
    int events = 0;
    for (int i = 0; i < intervals.size(); i++) {
      // Find next interval greater or equal to current time.
      while (i < intervals.size() && intervals.get(i).start < curTime) {
        i++;
      }
      // Set current time as end of interval.
      curTime = intervals.get(i).end;
      // Increment number of intervals.
      events++;
    }
    return events;
  }
  
  public static void main(String[] args) {
    Vector<Interval> list = new Vector<Interval>();
    list.add(new Interval(1,5));
    list.add(new Interval(2,4));
    list.add(new Interval(4,6));
    System.out.println(maxEvents(list));
  }
}
