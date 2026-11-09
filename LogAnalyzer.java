
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class LogAnalyzer
{
    public static final int HOURS_PER_DAY = 24;
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    // question 1: 10 am, 2pm and 6pm
    // question 2: used once in each method that counts the hour
    // question 3: nothing changes
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(); 
        //question 7:
        numberOfAccesses();
        //question 8:
        busiestHour();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        // question 4:
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    //question 5:
    public int numberOfAccesses(){
        int total = 0;
        for(int hour = 0; hour < hourCounts.length; hour++){
            total += hourCounts[hour];
        }
        return total;
    }
    //question 8:
    public int busiestHour(){
        int busiest = 0;
        for(int hour = 0; hour < hourCounts.length; hour++){
            if (hourCounts[hour] > hourCounts[busiest]){
                hour = busiest;
            }
        }
        return busiest;
    }
    //question 9:
    public int quietestHour(){
        int quietest = 0;
        for(int hour = 0; hour < hourCounts.length; hour++){
            if (hourCounts[hour] < hourCounts[quietest]){
                hour = quietest;
            }
        }
        return quietest;
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while (hour < hourCounts.length){
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
